package com.feng.product.controller;

import com.feng.product.service.ProductService;
import com.feng.product_api.controller.ProductController;
import com.feng.product_api.domain.YwProductsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author bee
 * @create 2019-04-18 21:34
 * @desc
 **/
@Controller
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductService productService;

    @Override
    public List<YwProductsVo> getall() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<YwProductsVo> o = productService.getAll();
        return o;
    }
}
