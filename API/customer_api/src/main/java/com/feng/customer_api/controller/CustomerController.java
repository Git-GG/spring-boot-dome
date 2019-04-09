package com.feng.customer_api.controller;

import com.feng.customer_api.model.TbCustomer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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



    @PostMapping("/register")
    public Object register(@RequestParam(value = "phoneNumber") String phoneNumber,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "realName") String realName,
                           @RequestParam(value = "yzm") String yzm,
                           @RequestParam(value = "spreads", required = false) String spreadsPeople,
                           HttpServletRequest request);


    @ApiOperation(value = "（E）用户登录接口（使用密码登录）")
    @PostMapping("/loginPassword")
    public Object loginPassword(@RequestParam(value = "phonenumber") String phonenumber,
                                @RequestParam(value = "password") String password,
                                HttpServletRequest request);

    @ApiOperation(value = "（E）修改密码接口")
    @PostMapping("/changePassword")
    public Object changePassword(@RequestParam(value = "customerId") Integer customerId,
                                 @RequestParam(value = "oldPassword") String oldPassword,
                                 @RequestParam(value = "password") String password) ;

    @ApiOperation(value = "（E）后台查看用户列表")
    @GetMapping("/getCustomerList")
    public Object getCustomerList(@RequestParam(value = "customerId", required = false) Integer customerId,
                                  @RequestParam(value = "customerLevelId", required = false) Integer customerLevelId,
                                  @RequestParam(value = "realName", required = false) String realName,
                                  @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) ;
    @ApiOperation(value = "（E）修改用户信息 前后台适用")
    @PutMapping("/updateCustomer")
    public Object updateCustomer(@RequestBody TbCustomer tbCustomer) ;


    @ApiOperation(value = "（E）获取个人信息")
    @GetMapping("/getCustomer")
    public Object getCustomer(@RequestParam Integer customerId) ;
}
