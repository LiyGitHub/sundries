package com.practice.bootintegrate.ali;

import com.aliyun.cloudauth20190307.Client;
import com.aliyun.cloudauth20190307.models.ContrastFaceVerifyAdvanceRequest;
import com.aliyun.cloudauth20190307.models.ContrastFaceVerifyResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class ContrastFaceVerifyWithVideoFile {

    public static void main(String[] args) throws Exception {

        // 通过以下代码创建API请求并设置参数。
        ContrastFaceVerifyAdvanceRequest request = new ContrastFaceVerifyAdvanceRequest();

        // 请输入场景ID+L。
        request.setSceneId(1L);

        request.setOuterOrderNo("商户请求的唯一标识");
        request.setProductCode("ID_MIN_VIDEO");
        // 卡证核身类型，固定值。
        request.setModel("FRONT_CAMERA_LIVENESS");
        // 证件类型，固定值。
        request.setCertType("IDENTITY_CARD");
        request.setCertName("张先生");
        request.setCertNo("xxxx");
        //request.setDeviceToken("xxxx");
        //request.setMobile("130xxxxxxxx");
        //request.setIp("114.xxx.xxx.xxx");
        //request.setUserId("12345xxxx");
        // 如需开启个人信息加密传输。
        // request.setEncryptType("SM2");
        // request.setCertName("BCRD/7ZkNy7Q*****M1BMBezZe8GaYHrLwyJv558w==");
        // request.setCertNo("BMjsstxK3S4b1YH*****Pet8ECObfxmLN92SLsNg==");

        InputStream inputStream = null;
        try {
            // 设置本地文件路径。
            inputStream = new FileInputStream("test.mp4");
            request.setFaceContrastFileObject(inputStream);

            // 推荐，支持服务路由。
            ContrastFaceVerifyResponse response = contrastFaceVerifyAutoRoute(request);

            // 不支持服务自动路由。
            //ContrastFaceVerifyResponse response = contrastFaceVerify("cloudauth.cn-shanghai.aliyuncs.com", request);

            System.out.println(response.getBody().getRequestId());
            System.out.println(response.getBody().getCode());
            System.out.println(response.getBody().getMessage());
            System.out.println(response.getBody().getResultObject() == null ? null
                    : response.getBody().getResultObject().getPassed());
            System.out.println(response.getBody().getResultObject() == null ? null
                    : response.getBody().getResultObject().getSubCode());
            System.out.println(response.getBody().getResultObject() == null ? null
                    : response.getBody().getResultObject().getIdentityInfo());
            System.out.println(response.getBody().getResultObject() == null ? null
                    : response.getBody().getResultObject().getMaterialInfo());
        } finally {
            if(inputStream != null){
                inputStream.close();
            }
        }
    }

    private static ContrastFaceVerifyResponse contrastFaceVerifyAutoRoute(ContrastFaceVerifyAdvanceRequest request) {
        // 第一个为主区域Endpoint，第二个为备区域Endpoint。
        List<String> endpoints = Arrays.asList("cloudauth.cn-shanghai.aliyuncs.com", "cloudauth.cn-beijing.aliyuncs.com");
        ContrastFaceVerifyResponse lastResponse = null;
        for (int i=0; i<endpoints.size(); i++) {
            try {
                ContrastFaceVerifyResponse response = contrastFaceVerify(endpoints.get(i), request);
                lastResponse = response;

                // 服务端错误，切换到下个区域调用。
                if(response != null){
                    if(500 == response.getStatusCode()){
                        continue;
                    }
                    if(response.getBody() != null){
                        if("500".equals(response.getBody().getCode())){
                            continue;
                        }
                    }
                }

                return response;
            } catch (Exception e) {
                e.printStackTrace();
                if(i == endpoints.size()-1){
                    throw new RuntimeException(e);
                }
            }
        }

        return lastResponse;
    }

    private static ContrastFaceVerifyResponse contrastFaceVerify(String endpoint, ContrastFaceVerifyAdvanceRequest request)
            throws Exception {
        Config config = new Config();
        config.setAccessKeyId("您的AccessKey ID");
        config.setAccessKeySecret("您的AccessKey Secret");
        config.setEndpoint(endpoint);
        // 设置http代理。
        //config.setHttpProxy("http://xx.xx.xx.xx:xxxx");
        // 设置https代理。
        //config.setHttpsProxy("http://xx.xx.xx.xx:xxxx");
        Client client = new Client(config);

        // 创建RuntimeObject实例并设置运行参数。
        RuntimeOptions runtime = new RuntimeOptions();
        runtime.readTimeout = 10000;
        runtime.connectTimeout = 10000;

        return client.contrastFaceVerifyAdvance(request, runtime);
    }

}
