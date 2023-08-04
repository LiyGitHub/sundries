package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.practice.bootintegrate.json.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String data = "{\"code\":200,\"msg\":\"操作成功\",\"data\":{\"merchantNo\":\"202307061435451286\",\"merOrderNo\":\"YXLM1689067348173\",\"amount\":\"1\",\"curType\":\"CNY\",\"sendupTime\":\"20230711\",\"version\":null,\"signType\":null,\"orderNo\":\"2023070614354512862023071117222969252\",\"tradeStatus\":\"02\",\"tradeDesc\":\"交易成功\",\"finishTime\":\"20230711172335\",\"attach\":\"顾客消费\",\"commodityName\":\"文具盒\",\"trxFee\":\"1\",\"discountTrxAmount\":\"0\",\"actualTrxAmount\":\"0\",\"payInfo\":\"oKKPRsjFmCinVOGh0ilVFCBorsZU\",\"transactionNo\":\"4200001966202307110041820349\",\"channelOrderNo\":\"11020230711172229017354635768002\"}}";
        DataResult data1 = JSONObject.parseObject(data, DataResult.class);
        log.info("聚合系统订单查询返回转化实体类：{}", data1);
        log.info("聚合系统订单查询返回转化实体类：{}", data1.getMsg());
    }

}
