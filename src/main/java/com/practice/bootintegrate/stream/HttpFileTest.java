package com.practice.bootintegrate.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

/**
 * @author liy
 * @description 网络文件读取
 * @date 2023/1/19
 */
public class HttpFileTest {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://uploadfile.bizhizu.cn/up/b5/5d/ba/b55dba33e5c476a1d751ca7c4a41a369.jpg");
        InputStream stream = url.openStream();
        File file = new File("image.jpg");
        Files.copy(stream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        System.out.println("data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(buffer));
    }
}
