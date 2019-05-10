package com.feng.customer.service.serviceImpl;

import com.feng.customer.mapper.TbCustomerMapper;
import com.feng.customer.model.TbCustomer;
import com.feng.customer.service.customerService;
import com.feng.customer_api.domain.CustomerParam;
import com.feng.product_api.domain.YwProductsVo;
import com.feng.product_fegin.ProductFegin;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bee
 * @create 2019-04-10 9:49
 * @desc
 **/
@Service
public class customerServiceImpl implements customerService {
    @Autowired
    private TbCustomerMapper tbCustomerMapper;
    @Autowired
    private ProductFegin productFegin;

    @Override
//    @HystrixCommand(
//            fallbackMethod = "fallbackMethod",
//            commandProperties = {
//                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "70")
//            })
    @HystrixCommand(fallbackMethod = "fallbackMethod"
          )
    public Map findOne(Integer customerId,int status) {
        TbCustomer tbCustomer = tbCustomerMapper.selectByPrimaryKey(customerId);
        List<YwProductsVo> all =null;
        if(status==1){
            all =productFegin.getAll();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("customer", tbCustomer);
        map.put("product", all);
        return map;
    }


    private Map fallbackMethod(Integer customerId,int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("稍后重试", "稍后重试");
        return map;
    }
}
