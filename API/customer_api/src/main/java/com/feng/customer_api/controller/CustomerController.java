package com.feng.customer_api.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * @version 1.0
 * @author: ciyuan
 * @date: 2019/1/8 18:04
 */

@RequestMapping("/customer")
@RestController
public interface CustomerController {

    /**
     *  登陆时如果有上级用户id 即 customerOwnerId 不为空
     *  说明该用户是扫码进入小程序的 那么该用户即成为 customerOwnerId 的下级
     * @param code 登陆时获取的code
     * @param encrypteData 消息密文
     * @param iv 加密算法的初始向量
     * @param request 会话请求
     * @param customerOwnerId 上级用户ID
     * @return
     */
    @ApiOperation(value = "用户登陆接口")
    @GetMapping("/login")
    Object login(@RequestParam(value = "code",required = false)String code,
                 @RequestParam(value = "encrypteData",required = false)String encrypteData,
                 @RequestParam(value = "iv",required = false)String iv, HttpServletRequest request,
                 @RequestParam(value = "customerOwnerId",required = false)Integer customerOwnerId);

    /**
     * 小店登陆有两种情况
     * 1：店主登陆（customerOwnerId不为空）
     *
     * 2：通过二维码或者其他方式登陆（customerOwnerId不为空）
     * @param code
     * @param encrypteData
     * @param iv
     * @param request
     * @param customerOwnerId
     * @return
     */
    @ApiOperation(value = "小店小程序：登陆")
    @GetMapping("/smallShopLogin")
    public Object smallShopLogin(@RequestParam(value = "code",required = false)String code,
                                 @RequestParam(value = "encrypteData",required = false)String encrypteData,
                                 @RequestParam(value = "iv",required = false)String iv, HttpServletRequest request,
                                 @RequestParam(value = "customerOwnerId",required = false)Integer customerOwnerId);

    @ApiOperation(value = "根据用户id查询用户所有信息")
    @GetMapping("/findOne")
    public Object findOne(@RequestParam(value = "customerId")Integer customerId);


    @ApiOperation(value = "查询用户信息(优惠卷)")
    @GetMapping("/queryByParam")
    public Object queryByParam(@RequestParam(value = "id")Integer id,
                               @RequestParam(value = "weixinNumber")String weixinNumber,
                               @RequestParam(value = "iphone")String iphone);

    /**
     *
     * @param type 参数类型 1微信号 2手机号 3地区
     * @param keyword 关键字
     * @return
     */
    @ApiOperation(value = "用户列表")
    @GetMapping("/list")
    public Object query(@RequestParam(value = "type",defaultValue = "0")int type,
                        @RequestParam(value = "keyword",required = false)String keyword,
                        @RequestParam(value = "pageNum",defaultValue = "0")int pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "10")int pageSize);

    /**
     *  微信号 手机号 查询用户
     * @param keyword
     * @return
     */
    @ApiOperation(value = "转发--选择用户")
    @GetMapping("/forwardList")
    public Object queryForwardList(@RequestParam(value = "keyword",required = false)String keyword,
                                   @RequestParam(value = "pageNum",defaultValue = "0")int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10")int pageSize);

    @ApiOperation(value = "更改用户等级")
    @GetMapping("/customerLevel")
    public Object changeCustomerLevel(@RequestParam(value = "customerId")Integer customerId,
                                      @ApiParam(name = "level",value = "更改后的用户等级 1游客 2代理 3会员" ,required = true) @RequestParam(value = "level")Short level);


    /**
     * 创建个人推广二维码
     * @param customerId 用户ID
     * @param page 必须是已经发布的小程序页面，例如 "pages/index/index" ,如果不填写这个字段，默认跳主页面
     * @return
     */
    @ApiOperation(value = "创建个人推广码")
    @GetMapping("/createQrCode")
    public Object createQrCode(@RequestParam(value = "customerId")Integer customerId,
                               @RequestParam(value = "page")String page);

    @ApiOperation(value = "创建个人小店推广码")
    @GetMapping("/ createStorePromotionQrCode")
    Object createStorePromotionQrCode(@RequestParam(value = "customerId")Integer customerId,
                                      @RequestParam(value = "page")String page);

    @ApiOperation(value = "修改个人小店的公告")
    @GetMapping("/updateAnnouncement")
    Object updateAnnouncement(@RequestParam(value = "customerId")Integer customerId,
                              @RequestParam(value = "announcement")String announcement);

}
