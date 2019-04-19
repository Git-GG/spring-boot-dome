package com.feng.product_fegin;

import com.feng.product_api.domain.YwProductsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(value = "product")
@RequestMapping
@RestController
public interface ProductFegin {
    @GetMapping("/product/getAll")
    List<YwProductsVo> getAll();
}
