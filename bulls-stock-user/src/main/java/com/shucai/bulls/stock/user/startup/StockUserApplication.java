package com.shucai.bulls.stock.user.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.shucai"})
@RestController
public class StockUserApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StockUserApplication.class, args);
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome to bulls stock platform !";
    }
}
