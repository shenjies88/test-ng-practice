package com.application;

import com.application.service.FooService;
import com.application.service.impl.FooServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author shenjies88
 * @since 2020/2/14-2:03 PM
 */
@TestPropertySource(
        properties = {"foo=xyz", "bar=uvw", "PATH=aaa", "java.runtime.name=bbb"},
        locations = "classpath:application.yml"
)
@ActiveProfiles
@SpringBootTest(classes = FooServiceImpl.class)
public class FooServiceImplTest extends AbstractTestNGSpringContextTests implements EnvironmentAware {

    @Autowired
    private FooService foo;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(foo.getCount(), 0);

        foo.plusCount();
        assertEquals(foo.getCount(), 1);
    }

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        Map<String, Object> systemEnvironment = ((ConfigurableEnvironment) environment).getSystemEnvironment();
        System.out.println("=== System Environment ===");
        System.out.println(getMapString(systemEnvironment));
        System.out.println();

        System.out.println("=== Java System Properties ===");
        Map<String, Object> systemProperties = ((ConfigurableEnvironment) environment).getSystemProperties();
        System.out.println(getMapString(systemProperties));
    }

    @Test
    public void testOverridePropertySource() {
        assertEquals(environment.getProperty("foo"), "xyz");
    }

    @Test
    public void testOverrideSystemEnvironment() {
        assertEquals(environment.getProperty("PATH"), "aaa");
    }

    @Test
    public void testOverrideJavaSystemProperties() {
        assertEquals(environment.getProperty("java.runtime.name"), "bbb");
    }

    @Test
    public void testInlineTestPropertyOverrideResourceLocationTestProperty() {
        assertEquals(environment.getProperty("bar"), "uvw");
    }

    private String getMapString(Map<String, Object> map) {
        return map.keySet().stream().map(k -> k + "=" + map.get(k)).collect(Collectors.joining("\n"));
    }
}
