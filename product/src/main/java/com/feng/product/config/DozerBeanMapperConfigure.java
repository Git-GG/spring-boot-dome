package com.feng.product.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author bee
 * @create 2019-04-19 10:05
 * @desc
 **/

public class DozerBeanMapperConfigure {

    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList("dozer/*.xml"));
        return mapper;
    }
}
