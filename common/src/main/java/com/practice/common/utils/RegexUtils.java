package com.practice.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 正则表达式工具类
 */
public class RegexUtils {

    /**
     * 验证数字正则
     */
    public static final String NUM_REG = "\\d+";

    /**
     * 1-6位数字
     */
    public static final String LE_SIX_NUM_REG = "^\\d{1,6}$";

    /**
     * 验证手机号正则
     */
    public static final String MOBILE_REG = "^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$";

    /**
     * 校验手机号
     *
     * @param mobile String
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkIsMobile(String mobile) {
        return matches(mobile, MOBILE_REG);
    }

    /**
     * 校验数字
     *
     * @param value String
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkIsNumber(String value) {
        return matches(value, NUM_REG);
    }

    /**
     * 校验是否1-6位数字
     *
     * @param value String
     * @return 校验通过返回true，否则返回false
     */
    public static boolean checkIsLeSixNumber(String value) {
        return matches(value, LE_SIX_NUM_REG);
    }

    /**
     * 正则表达式匹配
     *
     * @param value  String
     * @param regexp String
     * @return boolean
     */
    public static boolean matches(String value, String regexp) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(regexp)) {
            return false;
        } else {
            return value.matches(regexp);
        }
    }

}