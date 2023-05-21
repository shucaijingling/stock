package com.shucai.bulls.stock.gateway.startuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.shucai"})
public class StockGatewayApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(StockGatewayApplication.class, args);
    }
}
