package com.feng.customer.service;

import com.feng.customer.model.TbCustomer;
import com.feng.customer_api.domain.CustomerParam;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface customerService {
   

    Map findOne(Integer customerId,int status);

}
