package com.practice.bootintegrate.task;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author liy
 * @Description 定时查询打款申请订单状态
 * @Date 2023/1/5 14:31
 **/
@Slf4j
@Component
public class OrderQueryTask {


//    @Scheduled(cron = "0 3/1 * * * ?")
    public void orderQuery() {
        System.out.println("==========一号定时任务启动==========");
        log.info("==========一号定时任务启动==========");
    }

    public static void main(String[] args) {
        String s = HttpUtil.get("http://localhost:8090/userInfo/getList", 1000);
        System.out.println(s);
    }
}
