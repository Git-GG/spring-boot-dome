package com.feng.customer.service;

import com.feng.customer_api.domain.CustomerParam;
import com.feng.customer_api.model.TbCustomer;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface customerService {
   
    
    TbCustomer login(String code, String encrypteData, String iv, Integer customerOwnerId, HttpServletRequest request);

    TbCustomer loginOnStore(String code, String encrypteData, String iv, Integer customerOwnerId, HttpServletRequest request);

    TbCustomer findOne(Integer customerId);

    List<TbCustomer> queryByParam(CustomerParam param);

    PageInfo<TbCustomer> queryOnPC(int type, String keyword, int pageNum, int pageSize);

    PageInfo<TbCustomer> queryForwardList(int pageNum, int pageSize, String keyword);

    boolean changeCustomerLevel(Integer customerId, Short level);

    String createQrCode(Integer customerId, String page);

    String createStorePromotionQrCode(Integer customerId, String page);

    boolean updateAnnouncement(Integer customerId, String announcement);
}
