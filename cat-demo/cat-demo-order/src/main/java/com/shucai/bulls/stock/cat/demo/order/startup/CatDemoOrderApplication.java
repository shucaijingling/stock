package com.shucai.bulls.stock.cat.demo.order.startup;

import com.dianping.cat.Cat;
import com.dianping.cat.CatConstants;
import com.dianping.cat.message.Transaction;
import com.shucai.bulls.stock.cat.demo.order.catutils.CatRestInterceptor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.shucai"})
@RestController
@Log4j2
public class CatDemoOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatDemoOrderApplication.class, args);
    }

    @Autowired
    RestTemplate restTemplate;
    @Value("${service3.address:localhost:8083}")
    String serviceAddress3;
    @Value("${service4.address:localhost:8084}")
    String serviceAddress4;

    public static final int MOCK_PORT = 8765;

    @RequestMapping("/order")
    public String service2MethodInController() throws Exception {
        Thread.sleep(200);
        String service3 = restTemplate.getForObject("http://" + serviceAddress3 + "/account", String.class);
        String service4 = restTemplate.getForObject("http://" + serviceAddress4 + "/stock", String.class);
        return String.format("Calling order service[order success] ==> Calling Account Service[%s] => Calling Custom Service [%s]", service3, service4);
    }

    @RequestMapping("/readtimeout")
    public String connectionTimeout() throws Exception {
        Transaction t = Cat.newTransaction(CatConstants.TYPE_CALL, "connectionTimeout");
        Thread.sleep(500);
        try {
            log.info("Calling a missing service");
            restTemplate.getForObject("http://localhost:" + MOCK_PORT + "/readtimeout", String.class);
            return "Should blow up";
        } catch (Exception e) {
            t.setStatus(e);
            Cat.getProducer().logError(e);
            throw e;
        } finally {
            t.complete();
        }
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        template.setInterceptors(Collections.singletonList(new CatRestInterceptor()));
        return template;
    }
}
