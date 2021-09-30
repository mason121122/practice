package com.practice.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 时间工具类
 */
@Slf4j
public class DateUtils {

    private final static String DATE_YYYY_MM_DD = "yyyy-MM-dd";

    private final static String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private final static String DATE_YYYYMMDD = "yyyyMMdd";

    /**
     * 判断日期格式是否有效
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static boolean isValidDate(String dateStr, String format) {

        if (StringUtils.isBlank(dateStr)) {
            return false;
        }

        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }

        boolean isValid = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(dateStr.trim());
        } catch (Exception e) {
            // 格式不正确
            isValid = false;
        }
        return isValid;
    }

    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS);
        return dateFormat.format(new Date());
    }

    /**
     * 将日期字符串按照指定格式转换成Date类型
     *
     * @param date   String
     * @param format String
     * @return Date
     */
    public static Date strToDate(String date, String format) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }

        Date result = null;
        try {
            result = new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            log.error("时间格式不正确，date={}, format={}，失败原因={}.", date, format, e.getMessage());
        }
        return result;
    }

    /**
     * 将日期字按照指定格式转换成Date类型
     * 20181228 -> 2018-12-28
     *
     * @param date
     * @return
     */
    public static Date intToDate(Integer date) {

        if (null == date) {
            return null;
        }

        Date result = null;
        try {
            result = new SimpleDateFormat(DATE_YYYYMMDD).parse(date.toString());
        } catch (ParseException e) {
            log.error("时间格式不正确，date={}, format={}，失败原因={}.", date, DATE_YYYYMMDD, e.getMessage());
        }
        return result;
    }

    /**
     * 将日期按照指定格式转换成int类型
     * 2018-12-28 -> 20181228
     *
     * @param date
     * @return
     */
    public static Integer dateToInt(Date date) {
        if (null == date) {
            return null;
        }
        return Integer.valueOf(new SimpleDateFormat(DATE_YYYYMMDD).format(date));
    }

    /**
     * 将日期类型按照指定格式转换成String
     *
     * @param date
     * @param format
     * @return
     */
    public static String getDateStr(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (StringUtils.isBlank(format)) {
            format = DATE_YYYY_MM_DD_HH_MM_SS;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 在指定日期的基础上添加天数，返回添加后的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    /**
     * 获取指定日期 23：59：59 日期
     *
     * @param date
     * @return
     */
    public static Date addDaysEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, 23);
        c.add(Calendar.MINUTE, 59);
        c.add(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 判断time时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param time      当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date time, Date startTime, Date endTime) {

        if (time == null || startTime == null || endTime == null) {
            return false;

        }
        if (time.after(startTime) && time.before(endTime)) {
            return true;
        }
        return (time.getTime() == startTime.getTime() || time.getTime() == endTime.getTime());
    }

    /**
     * 日期加一个分钟后的日期时间戳
     *
     * @param dateString
     * @param minute
     * @return
     */
    public static Long addDateMinute(String dateString, int minute) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_YYYY_MM_DD_HH_MM_SS);// 24小时制
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (date == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        date = c.getTime();
        return date.getTime();
    }

    /**
     * 获取指定时间的下n个小时整点时间
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextHourTime(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + n);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取指定日期的下n个天数的0点
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getNextDayTime(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, n);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取n天前00:00:00对应的时间
     *
     * @param n
     * @return
     */
    public static Date getBeforeDayStartTime(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        return calendar.getTime();
    }

    /**
     * 获取n天前23:59:59对应的时间
     *
     * @param n
     * @return
     */
    public static Date getBeforeDayEndTime(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        return calendar.getTime();
    }

    /**
     * 格式 yyyy-MM-dd
     *
     * @return
     */
    public static String formatDatetimeStr(Date date) {
        if (date == null) return null;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 格式化，根据指定格式
     *
     * @return
     */
    public static Date parseDatetimeString(String dateStr, String dateFormat) {
        Date date = null;
        DateFormat format = new SimpleDateFormat(dateFormat);
        try {
            if (Strings.isNotBlank(dateStr)) {
                date = format.parse(dateStr);
            }
        } catch (ParseException e) {
            log.error("日期转换出错:" + e.getMessage());
        }
        return date;
    }

    /**
     * 获取指定日期的23：59：59时间格式
     *
     * @param dateStr
     * @return
     */
    public static Date dayEnd(String dateStr) {
        if (null == dateStr) return null;
        Date date = parseDatetimeString(dateStr, "yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    public static Date dayEnd(Date date) {
        if (null == date) return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    public static Date dayStart(Date date) {
        if (null == date) return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取年份
     *
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(date);
    }

    /**
     * 获取月份
     *
     * @param date
     * @return
     */
    public static Integer getMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }


    public static Date monthStart(Date date) {
        if (null == date) return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date monthEnd(Date date) {
        if (null == date) return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }
}
