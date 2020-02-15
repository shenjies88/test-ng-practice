package com.application;

import com.application.entity.DatabaseTestEntity;
import com.application.service.DatabaseTestService;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 内置数据库测试
 *
 * @author shenjies88
 * @since 2020/2/14-8:47 PM
 */
@SpringBootTest
public class DatabaseTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private DatabaseTestService databaseTestService;

    @Autowired
    private Flyway flyway;

    @Test
    public void testSave() {

        DatabaseTestEntity foo = new DatabaseTestEntity();
        foo.setName("Bob");
        databaseTestService.save(foo);

        assertEquals(countRowsInTable("FOO"), 1);
        countRowsInTableWhere("FOO", "name = 'Bob'");
    }

    @Test(dependsOnMethods = "testSave")
    public void testDelete() {

        assertEquals(countRowsInTable("FOO"), 0);

        DatabaseTestEntity foo = new DatabaseTestEntity();
        foo.setName("Bob");
        databaseTestService.save(foo);

        databaseTestService.delete(foo.getName());
        assertEquals(countRowsInTable("FOO"), 0);

    }

    @AfterTest
    public void cleanDb() {
        flyway.clean();
    }
}
