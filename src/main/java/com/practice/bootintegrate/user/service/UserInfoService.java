package com.practice.bootintegrate.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.bootintegrate.user.domain.UserInfo;

import java.util.List;

/**
 * <p>
 * 管理平台用户信息表 服务类
 * </p>
 *
 * @author liy
 * @since 2022-06-08
 */
public interface UserInfoService extends IService<UserInfo> {

    //查询用户列表
    List<UserInfo> getList(String name);
}
