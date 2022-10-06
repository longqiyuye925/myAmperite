package com.example.amperite.config;

import com.example.amperite.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AmperiteConfig
 * @Description 限流器切面配置类
 * @Author wushichao5
 * @Date 2022/10/5 15:36
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class AmperiteConfig {
    AtomicInteger threadCount = new AtomicInteger();
    @Value("${maxThread}")
    int maxThread;

    /***
     * @Author wushichao
     * @Description 限流器切入点
     * @Date 15:47 2022/10/5
     * @Param []
     * @return void
     */
    @Pointcut("@annotation(com.example.amperite.annotation.Amperite)")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {


    }

    @After("log()")
    public void doAfter() {
        //todo 出参都可以有哪些？
        //变量-1
        int count = threadCount.decrementAndGet();
        log.info("doAfter count :" + String.valueOf(count));
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //todo 上下文如何获取
        //todo 入参都可以有哪些？
        int count = threadCount.incrementAndGet();
        log.info("around count :" + String.valueOf(count));
        //变量+1
        if (maxThread < count) {
            TestVo testVo = new TestVo();
            testVo.setMsg("max");
            return testVo;
        }

        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}
