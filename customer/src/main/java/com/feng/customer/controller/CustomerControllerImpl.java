package com.feng.customer.controller;

import com.feng.customer.service.customerService;
import com.feng.customer_api.bean.ResponseBean;
import com.feng.customer_api.controller.CustomerController;
import com.feng.customer_api.domain.CustomerParam;
import com.feng.customer_api.model.TbCustomer;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bee
 * @create 2019-04-09 16:47
 * @desc 用户
 **/
@Slf4j
@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
public class CustomerControllerImpl extends ResponseBean implements CustomerController {
    @Autowired
    private customerService customerService;


    /**
     * 登陆时如果有上级用户id 即 customerOwnerId 不为空
     * 说明该用户是扫码进入小程序的 那么该用户即成为 customerOwnerId 的下级
     *
     * @param code            登陆时获取的code
     * @param encrypteData    消息密文
     * @param iv              加密算法的初始向量
     * @param request         会话请求
     * @param customerOwnerId 上级用户ID
     * @return
     */
    @ApiOperation(value = "用户登陆接口")
    @GetMapping("/login")
    @Override
    public Object login(@RequestParam(value = "code", required = false) String code,
                        @RequestParam(value = "encrypteData", required = false) String encrypteData,
                        @RequestParam(value = "iv", required = false) String iv, HttpServletRequest request,
                        @RequestParam(value = "customerOwnerId", required = false) Integer customerOwnerId) {
        TbCustomer customer = customerService.login(code, encrypteData, iv, customerOwnerId, request);
        Map<String, Object> map = new HashMap<>();
        map.put("customer", customer);
        return ok(map);
    }

    /**
     * 小店登陆有两种情况
     * 1：店主登陆（customerOwnerId不为空）
     * <p>
     * 2：通过二维码或者其他方式登陆（customerOwnerId不为空）
     *
     * @param code
     * @param encrypteData
     * @param iv
     * @param request
     * @param customerOwnerId
     * @return
     */
    @ApiOperation(value = "小店小程序：登陆")
    @GetMapping("/smallShopLogin")
    @Override
    public Object smallShopLogin(@RequestParam(value = "code", required = false) String code,
                                 @RequestParam(value = "encrypteData", required = false) String encrypteData,
                                 @RequestParam(value = "iv", required = false) String iv, HttpServletRequest request,
                                 @RequestParam(value = "customerOwnerId", required = false) Integer customerOwnerId) {
        TbCustomer customer = customerService.loginOnStore(code, encrypteData, iv, customerOwnerId, request);
        Map<String, Object> map = new HashMap<>();
        map.put("customer", customer);
        return ok(map);
    }

    @ApiOperation(value = "根据用户id查询用户所有信息")
    @GetMapping("/findOne")
    @Override
    public Object findOne(@RequestParam(value = "customerId") Integer customerId) {
        Map<String, Object> map = new HashMap<>();
        TbCustomer customer = customerService.findOne(customerId);
        map.put("customer", customer);
        return ok(map);
    }


    @ApiOperation(value = "查询用户信息(优惠卷)")
    @GetMapping("/queryByParam")
    @Override
    public Object queryByParam(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "weixinNumber") String weixinNumber,
                               @RequestParam(value = "iphone") String iphone) {
        CustomerParam param = new CustomerParam();
        param.setId(id);
        param.setIphone(iphone);
        param.setWeixinNumber(weixinNumber);
        log.info("查询用户信息（优惠券），参数={}", param);
        List<TbCustomer> customerList = customerService.queryByParam(param);
        Map<String, Object> map = new HashMap<>();
        map.put("customerList", customerList);
        return ok(map);
    }

    /**
     * @param type    参数类型 1微信号 2手机号 3地区
     * @param keyword 关键字
     * @return
     */
    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    @Override
    public Object query(@RequestParam(value = "type", defaultValue = "0") int type,
                        @RequestParam(value = "keyword", required = false) String keyword,
                        @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        log.info("用户列表，参数=【type={},keyword={},pageNum={},pageSize={}】", type, keyword, pageNum, pageSize);
        PageInfo<TbCustomer> pageInfo = customerService.queryOnPC(type, keyword, pageNum, pageSize);
        log.info("用户列表，结果={}", pageInfo);
        return ok(pageInfo);
    }

    /**
     * 微信号 手机号 查询用户
     *
     * @param keyword
     * @return
     */
    @ApiOperation(value = "转发--选择用户")
    @GetMapping("/forwardList")
    @Override
    public Object queryForwardList(@RequestParam(value = "keyword", required = false) String keyword,
                                   @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageInfo<TbCustomer> pageInfo = customerService.queryForwardList(pageNum, pageSize, keyword);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", pageInfo);
        return ok(map);
    }

    @ApiOperation(value = "更改用户等级")
    @GetMapping("/customerLevel")
    @Override
    public Object changeCustomerLevel(@RequestParam(value = "customerId") Integer customerId,
                                      @ApiParam(name = "level", value = "更改后的用户等级 1游客 2代理 3会员", required = true) @RequestParam(value = "level") Short level) {
        boolean flag = customerService.changeCustomerLevel(customerId, level);
        if (flag) {
            return ok();
        }
        return fail();
    }


    /**
     * 创建个人推广二维码
     *
     * @param customerId 用户ID
     * @param page       必须是已经发布的小程序页面，例如 "pages/index/index" ,如果不填写这个字段，默认跳主页面
     * @return
     */
    @ApiOperation(value = "创建个人推广码")
    @GetMapping("/createQrCode")
    @Override
    public Object createQrCode(@RequestParam(value = "customerId") Integer customerId,
                               @RequestParam(value = "page") String page) {
        String promotionCodeUrl = customerService.createQrCode(customerId, page);
        Map<String, Object> map = new HashMap<>();
        map.put("promotionCodeUrl", promotionCodeUrl);
        return ok(map);
    }

    @ApiOperation(value = "创建个人小店推广码")
    @GetMapping("/ createStorePromotionQrCode")
    @Override
    public Object createStorePromotionQrCode(@RequestParam(value = "customerId") Integer customerId,
                                             @RequestParam(value = "page") String page) {
        String storePromotionQrCode = customerService.createStorePromotionQrCode(customerId, page);
        Map<String, Object> map = new HashMap<>();
        map.put("storePromotionQrCode", storePromotionQrCode);
        return ok(map);
    }

    @ApiOperation(value = "修改个人小店的公告")
    @GetMapping("/updateAnnouncement")
    @Override
    public Object updateAnnouncement(@RequestParam(value = "customerId") Integer customerId,
                                     @RequestParam(value = "announcement") String announcement) {
        boolean flag = customerService.updateAnnouncement(customerId, announcement);
        if (flag) {
            return ok();
        }
        return fail();
    }
}
