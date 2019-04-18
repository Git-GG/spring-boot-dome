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
    public TbCustomer login(String code, String encrypteData, String iv, Integer customerOwnerId, HttpServletRequest request) {
        return null;
    }

    @Override
    public TbCustomer loginOnStore(String code, String encrypteData, String iv, Integer customerOwnerId, HttpServletRequest request) {
        return null;
    }

    @Override
    public TbCustomer findOne(Integer customerId) {
        TbCustomer tbCustomer = tbCustomerMapper.selectByPrimaryKey(customerId);
        return tbCustomer;
    }

    @Override
    public List<TbCustomer> queryByParam(CustomerParam param) {
        return null;
    }

    @Override
    public PageInfo<TbCustomer> queryOnPC(int type, String keyword, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public PageInfo<TbCustomer> queryForwardList(int pageNum, int pageSize, String keyword) {
        return null;
    }

    @Override
    public boolean changeCustomerLevel(Integer customerId, Short level) {
        return false;
    }

    @Override
    public String createQrCode(Integer customerId, String page) {
        return null;
    }

    @Override
    public String createStorePromotionQrCode(Integer customerId, String page) {
        return null;
    }

    @Override
    public boolean updateAnnouncement(Integer customerId, String announcement) {
        return false;
    }
}
