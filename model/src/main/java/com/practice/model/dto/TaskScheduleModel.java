package com.practice.model.dto;

import lombok.Data;

/**
 * @author Mark Wang
 * @date 2021/10/7
 */
@Data
public class TaskScheduleModel {
    /**
     * 所选作业类型:
     * 0  -> 每秒
     * 1  -> 每天
     * 2  -> 每月
     * 3  -> 每周
     * 4  -> 每分
     */
    Integer jobType;

    /**一周的哪几天*/
    Integer[] dayOfWeeks;

    /**一个月的哪几天*/
    Integer[] dayOfMonths;

    /**秒  */
    Integer second;

    /**分  */
    Integer minute;

    /**时  */
    Integer hour;
}
