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
        log.info("✅ Before Log");
    }

    @AfterReturning("execution(* hello*(..))")
    public void afterReturningLog() {
        log.info("👍 After Log");
    }

    @Around("execution(* around*(..))")
    public Object aroundLog(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("컨트롤러 메소드 시작 전");
//        joinPoint.getArgs(); //이 arguments로 매개변수에 어떤 행위를 가할 수 있다.
        final Object executeProcess = joinPoint.proceed();// 이부분이 실제 컨트롤러의 동작 메소드
        log.info("컨트롤러 메소드 실행 후");
        return executeProcess;
    }

}
