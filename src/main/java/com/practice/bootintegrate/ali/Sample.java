// This file is auto-generated, don't edit it. Thanks.
package com.practice.bootintegrate.ali;

import com.aliyun.ocr_api20210707.models.RecognizeIdcardResponse;
import com.aliyun.tea.*;

import java.io.File;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.ocr_api20210707.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "ocr-api.cn-hangzhou.aliyuncs.com";
        return new com.aliyun.ocr_api20210707.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        //读取桌面的图片并且转化为InputStream
        File file = new File("C:\\Users\\76168\\Desktop\\229ba9dded28fec04590488dddba1a9.jpg");
        java.util.List<String> args = java.util.Arrays.asList(args_);
        // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        com.aliyun.ocr_api20210707.Client client = Sample.createClient("", "");
        com.aliyun.ocr_api20210707.models.RecognizeIdcardRequest recognizeIdcardRequest = new com.aliyun.ocr_api20210707.models.RecognizeIdcardRequest()
                .setBody(file.toURL().openStream());
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            RecognizeIdcardResponse recognizeIdcardResponse = client.recognizeIdcardWithOptions(recognizeIdcardRequest, runtime);
            System.out.println(recognizeIdcardResponse.getBody().getData());
        } catch (TeaException error) {
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }
}
