package com.feng.product_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public interface ProductController {
    @GetMapping(value = "/getall")
    Object getall();
}
