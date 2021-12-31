package com.junxian.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname: TestDao
 * @Date: 2021-12-31 10:39
 * @Author: tang_junXian
 * @Description:
 */
@Mapper
public interface TestDao {

    String select();

}
