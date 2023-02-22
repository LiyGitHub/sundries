package com.practice.bootintegrate.stream;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author liy
 * @description java8 Stream测试
 * @date 2022/5/24
 */
public class Java8StreamTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("及时雨-宋公明");
        list.add("黑旋风-李逵");
        list.add("花和尚-鲁智深");
        System.out.println(list.stream().limit(1).collect(Collectors.toList()));

    }
}
