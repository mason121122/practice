package com.practice.model.bo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/10/1
 */
@Data
public class UserTestBo {
    /**
     * id
     */
    private Long id;
    /**
     * 性别
     */
    private String string;
    /**
     * 生日
     */
    private Date date;

    private BigDecimal bigDecimal;

    private Double aDouble;

    private Float aFloat;

    private Integer integer;

    private Boolean aBoolean;

    private LocalDateTime localDateTime;

    private LocalDate localDate;


}
