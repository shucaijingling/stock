package com.shucai.bulls.stock.cat.demo.order.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.shucai"})
@RestController
public class CatDemoOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatDemoOrderApplication.class, args);
    }

    @Autowired
    RestTemplate restTemplate;
    @Value("${service3.address:localhost:8083}")
    String serviceAddress3;
    @Value("${service4.address:localhost:8083}")
    String serviceAddress4;

    public static final int MOCK_PORT = 8765;

    @RequestMapping("/order")
    public String  service2MethodInController() throws Exception {
        Thread.sleep(200);
//        restTemplate.getForObject("http://" + serviceAddress3)
        return  null;
    }
}
