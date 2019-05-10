package com.feng.customer_api.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * @version 1.0
 * @author: ciyuan
 * @date: 2019/1/8 18:04
 */

@RequestMapping("/customer")
@RestController
public interface CustomerController {


    @ApiOperation(value = "根据用户id查询用户所有信息")
    @GetMapping("/findOne")
     Object findOne(@RequestParam(value = "customerId")Integer customerId,int status);


}
