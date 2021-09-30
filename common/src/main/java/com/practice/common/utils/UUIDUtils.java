package com.practice.common.utils;

import java.util.UUID;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * UUID随机生成字符串工具类
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
