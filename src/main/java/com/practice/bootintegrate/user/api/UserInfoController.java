package com.practice.bootintegrate.user.api;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.practice.bootintegrate.common.JsonResult;
import com.practice.bootintegrate.user.domain.UserInfo;
import com.practice.bootintegrate.user.param.DateParam;
import com.practice.bootintegrate.user.service.UserInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 管理平台用户信息表 前端控制器
 * </p>
 *
 * @author liy
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;



    //查询所有用户信息
    @GetMapping("/getList")
    public JsonResult<List<UserInfo>> getList() {
        List<UserInfo> list = userInfoService.list();
        return JsonResult.success(list);
    }
    //添加用户
    @PostMapping("/addUser")
    public JsonResult<String> addUser(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return JsonResult.success("添加成功");
    }

    public static void main(String[] args) {
        List<UserInfo> userInfoList = new ArrayList<>();
        //循环5次添加不同用户
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName("张三" + i);
            userInfo.setId(1L);
            userInfoList.add(userInfo);
        }
        Map<Long, UserInfo> collect = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, Function.identity(),(u1,u2) -> u2));
        System.out.println(collect);
        List<String> list = new ArrayList<>();
        list.add("01");
        Test test = new Test();
        test.setStrings(list);
        test.getStrings().add("02");
        System.out.println(list);
    }

    @Data
    static class Test{
        private List<String> strings;
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/getUserInfo")
    public JsonResult<UserInfo> getUserInfo(@RequestParam("id") Long id) {
        UserInfo userInfo = userInfoService.getById(id);
        return JsonResult.success(userInfo);
    }
}

