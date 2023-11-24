package com.practice.bootintegrate.user.api;

import com.practice.bootintegrate.annotation.RepeatSubmit;
import com.practice.bootintegrate.common.JsonResult;
import com.practice.bootintegrate.json.Result;
import com.practice.bootintegrate.user.domain.UserInfo;
import com.practice.bootintegrate.user.service.UserInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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


    /**
     * 获取用户信息列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getList")
    @RepeatSubmit(interval = 10000)
    public JsonResult<List<UserInfo>> getList() {
//        List<UserInfo> list = userInfoService.getList("");
        List<UserInfo> list = userInfoService.list();
        return JsonResult.success(list);
    }


    /**
     * 添加用户信息
     * @param userInfo
     * @return
     */
    @PostMapping("/addUser")
    public JsonResult<String> addUser(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        //userInfoService.addUser(userInfo);
        return JsonResult.success("添加成功");
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
        //UserInfo userInfo = userInfoService.getUserInfo(id);
        UserInfo userInfo = userInfoService.getById(id);
        return JsonResult.success(userInfo);
    }

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    @GetMapping("/deleteUserInfo")
    public JsonResult<String> deleteUserInfo(@RequestParam("id") Long id) {
        userInfoService.removeById(id);
        return JsonResult.success("删除成功");
    }

    public static void main(String[] args) {
        Result result = new Result();
        UserInfo userInfo = new UserInfo();
        result.setUserInfo(userInfo);
        userInfo.setName("haha");
        System.out.println(result);
    }
}

