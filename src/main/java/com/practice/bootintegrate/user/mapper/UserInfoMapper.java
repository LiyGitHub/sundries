package com.practice.bootintegrate.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.practice.bootintegrate.user.domain.UserInfo;

import java.util.List;

/**
 * <p>
 * 管理平台用户信息表 Mapper 接口
 * </p>
 *
 * @author liy
 * @since 2022-06-08
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> getList();
}
