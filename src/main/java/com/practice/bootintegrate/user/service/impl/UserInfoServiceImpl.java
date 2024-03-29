package com.practice.bootintegrate.user.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.practice.bootintegrate.user.domain.UserInfo;
import com.practice.bootintegrate.user.mapper.UserInfoMapper;
import com.practice.bootintegrate.user.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理平台用户信息表 服务实现类
 * </p>
 *
 * @author liy
 * @since 2022-06-08
 */
@Service
//@DS("slave")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Override
    public List<UserInfo> getList(String name) {
        return baseMapper.getList();
    }


}
