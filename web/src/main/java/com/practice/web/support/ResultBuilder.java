package com.practice.web.support;

import com.practice.model.enums.ResultEnum;
import com.practice.model.result.ReturnResult;

/**
 * @author Mark Wang
 * @date 2021/10/01
 * 返回结果工具类
 */
public class ResultBuilder {

    public static <T> ReturnResult<T> success() {
        ReturnResult<T> t = new ReturnResult<>();
        t.setStatus(ResultEnum.SUCCESS.getCode());
        t.setMessage(ResultEnum.SUCCESS.getDesc());
        return t;
    }

    public static <T> ReturnResult<T> success(T data) {
        ReturnResult<T> t = new ReturnResult<>();
        t.setStatus(ResultEnum.SUCCESS.getCode());
        t.setMessage(ResultEnum.SUCCESS.getDesc());
        t.setData(data);
        return t;
    }

    public static <T> ReturnResult<T> buildResult(int status, String message) {
        ReturnResult<T> t = new ReturnResult<>();
        t.setStatus(status);
        t.setMessage(message);
        return t;
    }

    public static <T> ReturnResult<T> buildResult(int status, String message, T data) {
        ReturnResult<T> t = new ReturnResult<>();
        t.setStatus(status);
        t.setMessage(message);
        t.setData(data);
        return t;
    }

    public static <T> ReturnResult<T> buildResult(ResultEnum e) {
        ReturnResult<T> t = new ReturnResult<>();
        t.setStatus(e.getCode());
        t.setMessage(e.getDesc());
        return t;
    }

}
