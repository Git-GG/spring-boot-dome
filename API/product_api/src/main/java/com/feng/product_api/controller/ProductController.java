package com.feng.product_api.controller;

import com.feng.product_api.domain.YwProductsVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public interface ProductController {
    @GetMapping("/getAll")
    List<YwProductsVo> getall();
}
