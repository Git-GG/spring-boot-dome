package com.feng.customer_api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bee
 * @create 2019-04-10 9:37
 * @desc 返回值类
 **/
@Data
@NoArgsConstructor
public class ResponseBean {
    private int code;
    private String massage;
    private Object data;

    public ResponseBean ok() {
        this.code = 200;
        return this;
    }

    public ResponseBean ok(Object data) {
        this.code = 200;
        this.data = data;
        return this;
    }

    public ResponseBean ok(int code, Object data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public ResponseBean ok(int code, String massage, Object data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
        return this;
    }

    public ResponseBean fail(int code, String massage, Object data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
        return this;
    }

    public ResponseBean fail(int code, String massage) {
        this.code = code;
        this.massage = massage;
        return this;
    }

    public ResponseBean fail() {
        this.code = -1;
        this.massage = "未知错误";
        return this;
    }
}
