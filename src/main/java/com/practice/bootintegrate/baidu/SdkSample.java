package com.practice.bootintegrate.baidu;

import java.io.IOException;
import java.util.*;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
public class SdkSample {
    //设置APPID/AK/SK
    public static final String APP_ID = "1";
    public static final String API_KEY = "2";
    public static final String SECRET_KEY = "3";

    public static void main(String[] args) throws IOException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        AipFace aipFace = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        sample(client);
        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口

//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));

    }


    public static void sample(AipOcr client) throws IOException {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地图片路径
        String image = "5";
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
//        byte[] file = Util.readFileByBytes(image);
//        res = client.idcard(file, idCardSide, options);
//        System.out.println(res.toString(2));
//测试提交
    }


}
