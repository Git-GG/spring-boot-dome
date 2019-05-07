package com.feng.customer.service;

import com.feng.customer.model.TbCustomer;
import com.feng.customer_api.domain.CustomerParam;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface customerService {
   

    TbCustomer findOne(Integer customerId);

}
