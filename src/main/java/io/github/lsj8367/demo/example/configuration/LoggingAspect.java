package io.github.lsj8367.demo.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* io.github.lsj8367.demo.example.web.SampleController.hello())")
    public void beforeLog() {
        log.info("โ Before Log");
    }

    @AfterReturning("execution(* hello*(..))")
    public void afterReturningLog() {
        log.info("๐ After Log");
    }

    @Around("execution(* around*(..))")
    public Object aroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("์ปจํธ๋กค๋ฌ ๋ฉ์๋ ์์ ์ ");
//        joinPoint.getArgs(); //์ด arguments๋ก ๋งค๊ฐ๋ณ์์ ์ด๋ค ํ์๋ฅผ ๊ฐํ  ์ ์๋ค.
        final Object executeProcess = joinPoint.proceed();// ์ด๋ถ๋ถ์ด ์ค์  ์ปจํธ๋กค๋ฌ์ ๋์ ๋ฉ์๋
        log.info("์ปจํธ๋กค๋ฌ ๋ฉ์๋ ์คํ ํ");
        return executeProcess;
    }

}
