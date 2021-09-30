package com.practice.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 类转化器
 * 借助FastJson从一个类转化为另一个类，主要用于同一个模型的VO/BO/DTO/PO之间的转换，他们具有基本相同的属性名称
 */
public class ClazzConverter {

    private ClazzConverter() {
    }

    /**
     * 具有相同属性名称的对象转化
     *
     * @param <T1>     出参类型
     * @param <T2>     入参类型
     * @param srcClazz 待转化的对象
     * @param dstClazz 结果对象类型
     * @return 结果对象值
     */
    public static <T1, T2> T1 converterClass(final T2 srcClazz, Class<T1> dstClazz) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(srcClazz);
        return jsonObject != null ? JSONObject.toJavaObject(jsonObject, dstClazz) : null;
    }

    /**
     * 集合转化
     *
     * @param <T1>          出参类型
     * @param <T2>          入参类型
     * @param srcCollection 待转化的对象集合
     * @param dstClazz      结果对象类型
     * @return 结果对象值
     */
    public static <T1, T2> Collection<T1> converterClass(final Collection<T2> srcCollection, Class<T1> dstClazz) {
        JSONArray jsonArray = (JSONArray) JSONObject.toJSON(srcCollection);
        return jsonArray != null ? JSONArray.parseArray(jsonArray.toJSONString(), dstClazz) : null;
    }

    /**
     * 集合转化
     *
     * @param <T1>     出参类型
     * @param <T2>     入参类型
     * @param srcList  待转化的对象集合
     * @param dstClazz 结果对象类型
     * @return 结果对象值
     */
    public static <T1, T2> List<T1> converterClass(final List<T2> srcList, Class<T1> dstClazz) {
        JSONArray jsonArray = (JSONArray) JSONObject.toJSON(srcList);
        return jsonArray != null ? JSONArray.parseArray(jsonArray.toJSONString(), dstClazz) : new ArrayList<>();
    }
}
