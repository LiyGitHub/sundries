package com.practice.bootintegrate.config;

import com.practice.bootintegrate.user.service.TestService;
import com.practice.bootintegrate.user.service.impl.TestService2Impl;
import com.practice.bootintegrate.user.service.impl.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liy
 * @description 自定义配置类
 * @date 2022/7/25
 */
@Configuration
public class CustomConfiguration {

    //同名bean的加载，写在上面的会覆盖下面的
    @Bean("testService")
    public TestService testService2() {
        return new TestService2Impl();
    }

    //生成一个TestService bean
    @Bean("testService")
    public TestService testService() {
        return new TestServiceImpl();
    }




}
