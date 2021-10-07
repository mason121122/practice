package com.example.time.test;

import com.practice.model.dto.TaskScheduleModel;
import com.practice.common.utils.CronUtil;

/**
 * @author Mark Wang
 * @date 2021/10/7
 */
public class CreationCron {
    //参考例子
    public static void main(String[] args) {
        //执行时间：每天的12时12分12秒 start
        TaskScheduleModel taskScheduleModel = new TaskScheduleModel();

        taskScheduleModel.setJobType(0);//按每秒
        taskScheduleModel.setSecond(30);
        String cronExp = CronUtil.createCronExpression(taskScheduleModel);
        System.out.println(cronExp);

        taskScheduleModel.setJobType(4);//按每分钟
        taskScheduleModel.setMinute(8);
        String cronExpp = CronUtil.createCronExpression(taskScheduleModel);
        System.out.println(cronExpp);

        taskScheduleModel.setJobType(1);//按每天
        Integer hour = 12; //时
        Integer minute = 12; //分
        Integer second = 12; //秒
        taskScheduleModel.setHour(hour);
        taskScheduleModel.setMinute(minute);
        taskScheduleModel.setSecond(second);
        String cropExp = CronUtil.createCronExpression(taskScheduleModel);
        System.out.println(cropExp + ":" + CronUtil.createDescription(taskScheduleModel));
        //执行时间：每天的12时12分12秒 end

        taskScheduleModel.setJobType(3);//每周的哪几天执行
        Integer[] dayOfWeeks = new Integer[3];
        dayOfWeeks[0] = 1;
        dayOfWeeks[1] = 2;
        dayOfWeeks[2] = 3;
        taskScheduleModel.setDayOfWeeks(dayOfWeeks);
        cropExp = CronUtil.createCronExpression(taskScheduleModel);
        System.out.println(cropExp + ":" + CronUtil.createDescription(taskScheduleModel));

        taskScheduleModel.setJobType(2);//每月的哪几天执行
        Integer[] dayOfMonths = new Integer[3];
        dayOfMonths[0] = 1;
        dayOfMonths[1] = 21;
        dayOfMonths[2] = 13;
        taskScheduleModel.setDayOfMonths(dayOfMonths);
        cropExp = CronUtil.createCronExpression(taskScheduleModel);
        System.out.println(cropExp + ":" + CronUtil.createDescription(taskScheduleModel));
    }
}
