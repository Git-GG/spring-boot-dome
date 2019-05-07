package com.feng.customer.service.serviceImpl;

import com.feng.customer.mapper.TbCustomerMapper;
import com.feng.customer.model.TbCustomer;
import com.feng.customer.service.customerService;
import com.feng.customer_api.domain.CustomerParam;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author bee
 * @create 2019-04-10 9:49
 * @desc
 **/
@Service
public class customerServiceImpl implements customerService {
@Autowired
private TbCustomerMapper tbCustomerMapper;

    @Override
    public TbCustomer findOne(Integer customerId) {
        TbCustomer tbCustomer = tbCustomerMapper.selectByPrimaryKey(customerId);
        return tbCustomer;
    }


}
