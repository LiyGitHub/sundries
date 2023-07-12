package com.practice.bootintegrate.baidu;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.*;

class Sample {
    public static final String API_KEY = "1";
    public static final String SECRET_KEY = "2";

    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static void main(String []args) throws IOException{
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"plan_id\":\"3\"}");
        Request request = new Request.Builder()
            .url("https://aip.baidubce.com/rpc/2.0/brain/solution/faceprint/verifyToken/generate?access_token=" + getAccessToken())
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build();
        System.out.println("打印日志");
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(JSONObject.parseObject(response.body().string()).getJSONObject("result").getString("verify_token"));
    }


    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    static String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return JSONObject.parseObject(response.body().string()).getString("access_token");
    }

    static void getResult() throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"verify_token\":\"4\"}");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/brain/solution/faceprint/result/simple?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
