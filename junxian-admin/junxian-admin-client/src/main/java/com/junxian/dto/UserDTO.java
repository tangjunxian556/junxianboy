package com.junxian.dto;

import lombok.Data;

/**
 * @Classname: UserDTO
 * @Date: 2022-01-04 10:05
 * @Author: tang_junXian
 * @Description: 用户详细信息类
 */
@Data
public class UserDTO {

    /** ID */
    private Long id;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;

}
