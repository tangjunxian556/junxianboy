package com.junxian.feign.fallback;

import com.junxian.dto.UserDTO;
import com.junxian.feign.UserFeignClient;
import com.junxian.utils.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Classname: UserFeignClientFallbackFactory
 * @Date: 2022-01-04 8:38
 * @Author: tang_junXian
 * @Description: 用户接口 FallbackFactory
 */
@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        log.error("调用用户接口出现错误: {}", cause);

        return new UserFeignClient() {
            @Override
            public Result<UserDTO> getUserInfoByUserName(String userName) {
                return new Result<>();
            }
        };
    }

}
