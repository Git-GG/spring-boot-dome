package com.feng.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@MapperScan("com.feng.customer.mapper")
@ServletComponentScan
@EnableFeignClients(basePackages = {"com.feng.product_fegin"})
@ComponentScan({"com.feng.customer","com.feng.customer_api","com.feng.product_fegin"})
@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
//@SpringCloudApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
