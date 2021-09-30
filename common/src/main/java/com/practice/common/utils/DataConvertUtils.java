package com.practice.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 数据转换工具类
 */
@Slf4j
public class DataConvertUtils {

    /**
     * 将Json String转成指定对象
     *
     * @param jsonMessage
     * @param objectClass
     * @param <T>
     * @return
     */
    public static <T> T getObject(String jsonMessage, Class<T> objectClass) {
        T result;
        try {
            result = JSON.parseObject(jsonMessage, objectClass);
        } catch (Exception e) {
            log.error("【Failed to deserialize message:{}.】", jsonMessage, e);
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

}
