package com.feng.customer.service.serviceImpl;

import com.feng.customer.mapper.TbCustomerMapper;
import com.feng.customer.model.TbCustomer;
import com.feng.customer.service.customerService;
import com.feng.product_api.domain.YwProductsVo;
import com.feng.product_fegin.ProductFegin;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bee
 * @create 2019-04-10 9:49
 * @desc
 **/
@Service
@Slf4j
public class customerServiceImpl implements customerService {
    @Autowired
    private TbCustomerMapper tbCustomerMapper;
    @Autowired
    private ProductFegin productFegin;



    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod"
    )
    public Map findOne(Integer customerId, int status) {
        TbCustomer tbCustomer = tbCustomerMapper.selectByPrimaryKey(customerId);
        List<YwProductsVo> all = null;
        if (status == 1) {
            int a = 1 / 0;
            all = productFegin.getAll();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("customer", tbCustomer);
        map.put("product", all);
        return map;
    }

    private Map fallbackMethod(Integer customerId, int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("稍后重试", "稍后重试");
        return map;
    }
}
