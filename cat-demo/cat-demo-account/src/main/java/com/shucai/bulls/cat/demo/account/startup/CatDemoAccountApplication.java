package com.shucai.bulls.cat.demo.account.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.shucai"})
@RestController
public class CatDemoAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatDemoAccountApplication.class, args);
    }

    @RequestMapping("/account")
    public String account() throws Exception {
        Thread.sleep(150);
        return "account success";
    }
}
