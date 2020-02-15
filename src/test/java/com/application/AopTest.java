package com.application;

import com.application.aop.AopTestAspect;
import com.application.service.AopTestService;
import com.application.service.impl.AopTestServiceImpl;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.util.AopTestUtils;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

/**
 * @author shenjies88
 * @since 2020/2/15-5:30 PM
 */
@SpringBootTest
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class AopTest extends AbstractTestNGSpringContextTests {

    @SpyBean
    private AopTestAspect aopTestAspect;

    @Autowired
    private AopTestService aopTestService;

    @Test
    public void testFooService() {

        assertNotEquals(aopTestService.getClass(), AopTestServiceImpl.class);

        assertTrue(AopUtils.isAopProxy(aopTestService));
        assertTrue(AopUtils.isCglibProxy(aopTestService));

        assertEquals(AopProxyUtils.ultimateTargetClass(aopTestService), AopTestServiceImpl.class);

        assertEquals(AopTestUtils.getTargetObject(aopTestService).getClass(), AopTestServiceImpl.class);
        assertEquals(AopTestUtils.getUltimateTargetObject(aopTestService).getClass(), AopTestServiceImpl.class);

        assertEquals(aopTestService.incrementAndGet(), 0);
        assertEquals(aopTestService.incrementAndGet(), 0);

        verify(aopTestAspect, times(2)).changeIncrementAndGet(any());

    }
}
