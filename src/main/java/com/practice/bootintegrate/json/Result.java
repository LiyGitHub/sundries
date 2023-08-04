package com.practice.bootintegrate.json;

import lombok.Data;

/**
 * 通用结果类
 *
 * @author liy
 * @date 2023/8/4
 */
@Data
public class Result {
    private Integer code;
    private String msg;

}
