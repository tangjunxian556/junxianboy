package com.junxian.dao;

import com.junxian.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname: UserDao
 * @Date: 2022-01-04 10:57
 * @Author: tang_junXian
 * @Description: 用户mapper层
 */
@Mapper
public interface UserDao {

    /**
     * 通过用户名查询用户详细信息
     * @param userName 用户名
     * @return 用户信息
     */
    UserDTO selectUserInfoByUserName(@Param("userName") String userName);

}
