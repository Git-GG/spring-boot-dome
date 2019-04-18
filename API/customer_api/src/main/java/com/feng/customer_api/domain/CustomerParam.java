package com.feng.customer_api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @author: ciyuan
 * @date: 2019/1/15 14:04
 *
 * 查询用户 参数类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerParam {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 微信号
     */
    private String weixinNumber;

    /**
     * 手机号
     */
    private String iphone;

}
