package com.practice.bootintegrate.factory;

import com.practice.bootintegrate.user.service.UserInfoService;
import com.practice.bootintegrate.user.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 自定义FactoryBean
 * FactoryBean是一个特殊的Bean。
 * 我们自定义的CustomerFactoryBean实现了FactoryBean接口，
 * 所以当CustomerFactoryBean被扫描进Spring容器时，
 * 实际上它向容器中注册了两个bean，一个是CustomerFactoryBean类的单例对象；
 * 另外一个就是getObject()方法返回的对象，
 * 在demo中，我们重写的getObject()方法中，
 * 我们通过new UserService()返回了一个UserService的实例对象，
 * 所以我们从容器中能获取到UserService的实例对象。
 * 如果我们想通过beanName去获取CustomerFactoryBean的单例对象，
 * 需要在beanName前面添加一个&符号，
 * 主要的作用就是按照自己定义的逻辑去创建一个bean
 * @Author liy
 * @Date 2023/5/12 15:46
 **/
@Component
public class CustomerFactoryBean implements FactoryBean<UserInfoService> {
    @Override
    public UserInfoService getObject() {
//        return new UserInfoServiceImpl();
        return null;
    }

    @Override
    public Class<?> getObjectType() {
//        return UserInfoService.class;
        return null;
    }
}

