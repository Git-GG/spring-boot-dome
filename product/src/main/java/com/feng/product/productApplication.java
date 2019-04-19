package com.feng.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bee
 * @create 2019-04-18 21:00
 * @desc
 **/
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.feng.product.mapper")
@EnableDiscoveryClient
public class productApplication {
    public static void main(String[] args) {
        SpringApplication.run(productApplication.class,args);
    }
}
