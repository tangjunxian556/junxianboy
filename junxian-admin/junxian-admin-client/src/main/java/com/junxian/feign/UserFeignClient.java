package com.junxian.feign;

import com.junxian.dto.UserDTO;
import com.junxian.feign.fallback.UserFeignClientFallbackFactory;
import com.junxian.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname: UserFeignClient
 * @Date: 2022-01-04 8:37
 * @Author: tang_junXian
 * @Description: 用户接口
 */
@FeignClient(contextId = "UserFeignClient", name = "junxian-admin", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    /**
     * 根据用户名查询用户详细信息
     * @param userName 用户名
     * @return 用户信息
     */
    @GetMapping("/admin/user/info/byUserName")
    Result<UserDTO> getUserInfoByUserName(@RequestParam String userName);

}
