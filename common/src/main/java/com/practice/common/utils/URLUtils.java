package com.practice.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * URL工具类
 */
public class URLUtils {

    /**
     * url解码
     *
     * @param str
     * @return
     */
    public static String decode(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
