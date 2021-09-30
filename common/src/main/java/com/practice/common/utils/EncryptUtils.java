package com.practice.common.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 加密工具类
 */
public class EncryptUtils {

    /**
     * 利用Apache的工具类实现SHA-256加密
     *
     * @param str
     * @return
     */
    public static String getSHA256String(String str) {
        String encodeString = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes());
            encodeString = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeString;
    }

    public static String mask(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        char[] chars = code.toCharArray();
        int n = code.length();
        for (int j = 3; j < n - 4; j++) {
            chars[j] = '*';
        }
        return new String(chars);
    }

}
