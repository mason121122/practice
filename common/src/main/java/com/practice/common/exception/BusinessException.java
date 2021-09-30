package com.practice.common.exception;

import com.practice.model.enums.ResultEnum;

/**
 * @author Mark Wang
 * @date 2021/9/30
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
