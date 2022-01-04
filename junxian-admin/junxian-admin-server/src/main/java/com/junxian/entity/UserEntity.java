package com.junxian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Classname: UserEntity
 * @Date: 2022-01-04 9:58
 * @Author: tang_junXian
 * @Description: 用户实体
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName(value = "tb_user")
public class UserEntity extends BaseEntity {

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;

}
