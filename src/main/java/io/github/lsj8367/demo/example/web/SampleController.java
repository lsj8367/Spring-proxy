package io.github.lsj8367.demo.example.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/api/v1/hello")
    public String hello() {
        log.info("컨트롤러 실행중");
        return "hello";
    }
}
