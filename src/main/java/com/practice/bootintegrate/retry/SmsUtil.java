package com.practice.bootintegrate.retry;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 短信服务工具类
 * </p>
 *
 * @author 程序员济癫
 * @since 2023-12-21 09:40
 */
@Slf4j
public class SmsUtil {

   /**
    * 发送短信
    */
   public static boolean sendSms() {


      Long l = Long.valueOf("ce");

      return RandomUtil.randomBoolean();
   }

}
