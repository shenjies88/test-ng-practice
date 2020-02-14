package com.application;

import com.application.entity.DbTestEntity;
import com.application.service.DbTestRepository;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author shenjies88
 * @since 2020/2/14-8:47 PM
 */
@SpringBootTest
@SpringBootApplication(scanBasePackageClasses = DbTestRepository.class)
public class DbTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private DbTestRepository dbTestRepository;

    @Autowired
    private Flyway flyway;

    @Test
    public void testSave() {

        DbTestEntity foo = new DbTestEntity();
        foo.setName("Bob");
        dbTestRepository.save(foo);

        assertEquals(countRowsInTable("FOO"), 1);
        countRowsInTableWhere("FOO", "name = 'Bob'");
    }

    @Test(dependsOnMethods = "testSave")
    public void testDelete() {

        assertEquals(countRowsInTable("FOO"), 0);

        DbTestEntity foo = new DbTestEntity();
        foo.setName("Bob");
        dbTestRepository.save(foo);

        dbTestRepository.delete(foo.getName());
        assertEquals(countRowsInTable("FOO"), 0);

    }

    @AfterTest
    public void cleanDb() {
        flyway.clean();
    }
}
