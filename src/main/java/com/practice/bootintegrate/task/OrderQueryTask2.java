package com.practice.bootintegrate.task;

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
public class OrderQueryTask2 {


    @Scheduled(cron = "0 3/2 * * * ?")
    public void orderQuery() {
        System.out.println("==========二号定时任务启动==========");
        log.info("==========二号定时任务启动==========");
    }

}
