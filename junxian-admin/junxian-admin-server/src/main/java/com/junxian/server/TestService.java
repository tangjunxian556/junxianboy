package com.junxian.server;

import com.junxian.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname: TestService
 * @Date: 2021-12-31 10:52
 * @Author: tang_junXian
 * @Description:
 */
@Service
public class TestService {


    @Resource
    private TestDao testDao;

    public String select() {

        return testDao.select();
    }
}
