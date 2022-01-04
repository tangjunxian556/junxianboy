package com.junxian.exception;

import lombok.Data;

/**
 * @Classname: AuthException
 * @Date: 2021-12-31 16:09
 * @Author: tang_junXian
 * @Description: 权限统一异常类
 */
@Data
public final class AuthException extends RuntimeException {
    private static final long serialVersionUID = -1156951780670243758L;

    private int code;
    private String message;

    public AuthException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
