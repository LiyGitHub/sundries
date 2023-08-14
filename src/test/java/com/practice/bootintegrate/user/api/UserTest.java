package com.practice.bootintegrate.user.api;

import com.practice.bootintegrate.user.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
class UserTest {

    @Test
    void main() {
        List<UserInfo> userInfoList = new ArrayList<>();
        //循环5次添加不同用户
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName("张三" + i);
            userInfo.setId(1L);
            userInfoList.add(userInfo);
        }
        Map<Long, UserInfo> collect = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, Function.identity(),(u1, u2) -> u2));
        System.out.println(collect);
        List<String> list = new ArrayList<>();
        list.add("01");
        UserInfoController.Test test = new UserInfoController.Test();
        test.setStrings(list);
        test.getStrings().add("02");
        //test.getStrings().add("03");
        System.out.println(list);
    }

}
