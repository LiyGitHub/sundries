package com.practice.bootintegrate.baidu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MenuParser {
    public static void main(String[] args) {
        HashMap<String, String> menu = new HashMap<>();
        String filePath = "C:\\Users\\76168\\Desktop\\新建 文本文档 (2).md"; // 文件路径

        try {
            // 使用Jsoup解析HTML文件
            Document doc = Jsoup.parse(new File(filePath), "UTF-8");
            // 选择所有<tr>元素
            Elements rows = doc.select("table tr");

            for (Element row : rows) {
                // 选择每一行中的所有<td>元素
                Elements cols = row.select("td");
                for (int i = 0; i < cols.size(); i += 2) {
                    if (i + 1 < cols.size()) {
                        String name = cols.get(i).text().trim();
                        String price = cols.get(i + 1).text().trim();
                        // 检查名称和价格是否为空
                        if (!name.isEmpty() && !price.isEmpty()) {
                            menu.put(name, price);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 打印菜单
        for (String key : menu.keySet()) {
            System.out.println(key + " : " + menu.get(key));
        }
    }
}
