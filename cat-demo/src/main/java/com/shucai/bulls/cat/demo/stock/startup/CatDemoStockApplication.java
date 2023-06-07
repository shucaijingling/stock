package com.shucai.bulls.cat.demo.stock.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 * @date  
 * @author   
 * @version 1.0
 * @name   
 * <p>Copyright:Copyright(c)2020</p>
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.shucai"})
@RestController
public class CatDemoStockApplication {

    /**
     * 提供库存接口
     * @return
     * @throws Exception
     */
    @RequestMapping("/stock")
    public String stock() throws Exception {
        Thread.sleep(200);
        return "stock success";
    }

    public static void main(String[] args) {

        SpringApplication.run(CatDemoStockApplication.class, args);
    }

}
