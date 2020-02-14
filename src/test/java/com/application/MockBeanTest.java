package com.application;

import com.application.impl.AooImpl;
import com.application.interfaces.Aoo;
import com.application.interfaces.Bar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author shenjies88
 * @since 2020/2/14-8:12 PM
 */
@SpringBootTest(classes = {AooImpl.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class MockBeanTest extends AbstractTestNGSpringContextTests {

    @MockBean
    private Bar bar;

    @Autowired
    private Aoo foo;

    @Test
    public void testCheckCodeDuplicate() throws Exception {

        when(bar.getAllCodes()).thenReturn(Collections.singleton("123"));
        assertTrue(foo.checkCodeDuplicate("123"));

    }
}
