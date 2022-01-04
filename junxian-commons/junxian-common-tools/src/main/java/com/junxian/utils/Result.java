package com.junxian.utils;

import com.junxian.enums.MessageEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname: Result
 * @Date: 2022-01-04 10:14
 * @Author: tang_junXian
 * @Description: 响应数据包装类
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 编码：200表示成功，其他值表示失败
     */
    private int code = 200;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public Result<T> error() {
        this.code = 500;
        this.msg = MessageEnum.getMessage(1, 1);
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.msg = MessageEnum.getMessage(1, 1);
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }




}
