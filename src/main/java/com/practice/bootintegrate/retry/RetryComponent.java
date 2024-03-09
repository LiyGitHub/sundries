package com.practice.bootintegrate.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class RetryComponent {

   /**
    * 重试机制发送短信
    */
   @Retryable(
         include = {IllegalArgumentException.class, ArrayIndexOutOfBoundsException.class},
         exclude = {NullPointerException.class},
         maxAttempts = 1,
         backoff = @Backoff(delay = 2000L, multiplier = 2)
   )
   public boolean sendSmsRetry() {

      log.info("[RetryComponent][sendSmsRetry]>>>> 当前时间：{}", getNowTime());
      return SmsUtil.sendSms();
   }


   /**
    * 兜底方法，规则：
    *        1、超出了最大重试次数；
    *        2、抛出了不进行重试的异常；
    */
   @Recover
   public boolean recover() {
      log.info("[RetryComponent][recover]>>>> 短信发送次数过多333，请稍后重试！");
      return false;
   }



   /**
    * 获取当前时间
    */
   private String getNowTime() {

      return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
   }
}
