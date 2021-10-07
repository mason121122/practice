package com.example.time.test;

import com.practice.common.utils.DateUtil;
import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Mark Wang
 * @date 2021/10/7
 */
public class CronTest {
    public static void main(String[] args) throws ParseException {
        CronExpression exp = new CronExpression("12 12 12 1,21,13 * ?");//传入需要验证的cron表达式
        Date d = DateUtil.strToDateLong("2021-10-07 10:00:00");//可以传入随意时间也可以是当前时间new date
        TimeZone tz = exp.getTimeZone();//查询当前时区，有时候时区问题会导致job异常执行
        System.out.println(tz.getID());
        int i = 0;
        // 循环得到接下来n此的触发时间点，供验证
        while (i < 20) {
            d = exp.getNextValidTimeAfter(d);
            System.out.println(DateUtil.getStringDate(d));
            ++i;
        }
    }

}
