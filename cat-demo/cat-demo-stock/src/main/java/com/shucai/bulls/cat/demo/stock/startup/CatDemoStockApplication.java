package com.shucai.bulls.cat.demo.stock.startup;

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
public class CatDemoStockApplication {
    public static void main(String[] args) {

        SpringApplication.run(CatDemoStockApplication.class, args);
    }

    @RequestMapping("/stock")
    public String service4MethodInController() throws InterruptedException {
        Thread.sleep(200);
        return "stock success";
    }
}
