package com.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author shenjies88
 * @since 2020/2/15-4:59 PM
 */
@Aspect
@Component
public class AopTestAspect {

    @Pointcut("execution(* com.application.service.AopTestService.incrementAndGet())")
    public void pointcut() {
    }

    @Around("pointcut()")
    public int changeIncrementAndGet(ProceedingJoinPoint pjp) {
        return 0;
    }
}
