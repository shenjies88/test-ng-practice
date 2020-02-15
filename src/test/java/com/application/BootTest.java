package com.application;

import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 取消自动配置
 *
 * @author shenjies88
 * @since 2020/2/14-3:53 PM
 */
@SpringBootTest(classes = BootTest.class)
@OverrideAutoConfiguration(enabled = false)
public class BootTest extends AbstractTestNGSpringContextTests {

    @Test
    public void testName() throws Exception {

    }
}

