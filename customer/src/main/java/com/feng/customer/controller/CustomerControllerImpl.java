package com.feng.customer.controller;

import com.feng.customer.model.TbCustomer;
import com.feng.customer.service.customerService;

import com.feng.customer_api.bean.ResponseBean;

import com.feng.customer_api.controller.CustomerController;
import com.feng.customer_api.domain.CustomerParam;
import com.feng.product_api.domain.YwProductsVo;
import com.feng.product_fegin.ProductFegin;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bee
 * @create 2019-04-09 16:47
 * @desc 用户
 **/
@Slf4j
@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
//@HystrixProperty()
public class CustomerControllerImpl extends ResponseBean implements CustomerController {
    @Autowired
    private customerService customerService;
    @Autowired
    private ProductFegin productFegin;


    @ApiOperation(value = "根据用户id查询用户所有信息")
    @GetMapping("/findOne")
    @Override
    @HystrixCommand(fallbackMethod ="fallbackMethod")
    public Object findOne(@RequestParam(value = "customerId") Integer customerId) {
       // int a=1/0;
        Map<String, Object> map = new HashMap<>();
        System.out.println("jifsd");
        TbCustomer customer = customerService.findOne(customerId);
        map.put("customer", customer);
        List<YwProductsVo> all = productFegin.getAll();
        map.put("product", all);
        return ok(map);
    }

    private Object fallbackMethod(Integer customerId) {
        return "稍后重试";
    }
}
