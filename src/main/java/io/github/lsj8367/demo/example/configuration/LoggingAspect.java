package io.github.lsj8367.demo.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    * hello*(..) 도 상관없음
    @Before("execution(* io.github.lsj8367.demo.example.web.SampleController.hello())")
    public void beforeLog() {
        log.info("✅ Before Log");
    }

    @AfterReturning("execution(* hello*(..))")
    public void afterReturningLog() {
        log.info("👍 After Log");
    }

}
