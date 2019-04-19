package com.feng.product.service.serviceImpl;

import com.feng.product.config.DozerBeanMapperConfigure;
import com.feng.product.mapper.TbYwProductMapper;
import com.feng.product.model.TbYwProduct;
import com.feng.product.service.ProductService;
import com.feng.product_api.domain.YwProductsVo;
import com.netflix.discovery.PropertyBasedAzToRegionMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private TbYwProductMapper tbYwProductMapper;

    @Override
    public List<YwProductsVo> getAll() {
        List<TbYwProduct> tbYwProducts = tbYwProductMapper.selectByExample(null);
        ArrayList<YwProductsVo> ywProductsVos = new ArrayList<>(tbYwProducts.size());

        for (TbYwProduct tbYwProduct : tbYwProducts) {
            YwProductsVo ywProductsVo = new YwProductsVo();
            BeanUtils.copyProperties(tbYwProduct, ywProductsVo);
            ywProductsVos.add(ywProductsVo);
        }
        return ywProductsVos;
    }
}
