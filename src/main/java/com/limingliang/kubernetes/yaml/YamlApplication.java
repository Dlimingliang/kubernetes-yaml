package com.limingliang.kubernetes.yaml;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class YamlApplication {

    @Value("${demo.greeting}")
    private String demoGreeting;

    @RequestMapping(value = "index")
    public String index() {

        log.info("this is info");
        log.debug("this is debug");
        log.error("this is error");
        return "Welcome To Kubernetes Index";
    }

    @RequestMapping(value = "greeting")
    public String greeting() {

        return demoGreeting;
    }

    public static void main(String[] args) {
        SpringApplication.run(YamlApplication.class, args);
    }

}
