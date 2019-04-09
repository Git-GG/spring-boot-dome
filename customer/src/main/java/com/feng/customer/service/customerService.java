package com.feng.customer.service;

import com.feng.customer_api.controller.CustomerController;
import com.feng.customer_api.model.TbCustomer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bee
 * @create 2019-04-09 16:47
 * @desc 用户
 **/
@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
public class customerService implements CustomerController {
    @ApiOperation(value = "（E）用户注册接口（）")
    @Override
    public Object register(String phoneNumber, String password, String realName, String yzm, String spreadsPeople, HttpServletRequest request) {
        return null;
    }

    @Override
    public Object loginPassword(String phonenumber, String password, HttpServletRequest request) {
        return null;
    }

    @Override
    public Object changePassword(Integer customerId, String oldPassword, String password) {
        return null;
    }

    @Override
    public Object getCustomerList(Integer customerId, Integer customerLevelId, String realName, String phoneNumber, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public Object updateCustomer(TbCustomer tbCustomer) {
        return null;
    }

    @Override
    public Object getCustomer(Integer customerId) {
        return null;
    }
}
