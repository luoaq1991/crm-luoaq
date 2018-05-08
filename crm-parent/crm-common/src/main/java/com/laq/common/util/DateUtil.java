package com.laq.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 时间工具类
 *
 * @author Mr.YongGan.Zhang
 * @version 1.0.0
 * <p>
 * 适用于 高并发 场景的时间获取
 */
public final class DateUtil {

    // 日志
    private static final Logger LOGGER = Logger.getLogger(DateUtil.class);

    private DateUtil() {
    }

    /**
     * 时间的格式 yyyy-MM-dd hh:mm:ss
     */
    public static final String DATE_FORMATE_YMDHMS = "yyyy-MM-dd hh:mm:ss";

    /**
     * 时间的格式 yyyy-MM-dd
     */
    public static final String DATE_FORMATE_YMD = "yyyy-MM-dd";

    private static String DEFUALT_DATEFORMAT;

    private static final ThreadLocal<DateFormat> DATEFORMAT_DEFUALT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(DEFUALT_DATEFORMAT);
        }
    };

    /**
     * 获取当前线程 时间 格式 yyyy-MM-dd hh:mm:ss
     *
     * @return
     */
    public static String getDateTimes(final String timeFormat) {
        setDefualtDateformat(timeFormat);
        DateFormat format = DATEFORMAT_DEFUALT.get();
        return format.format(new Date());
    }

    /**
     * 获取 时间 格式 yyyy-MM-dd hh:mm:ss
     *
     * @param timeFormat 格式
     * @param date       日期
     * @return
     */
    public static String getDateTimes(Date date, final String timeFormat) {

        setDefualtDateformat(timeFormat);
        // 设置装换格式
        DateFormat format = DATEFORMAT_DEFUALT.get();
        return format.format(date);
    }

    /**
     * 获取指定的日期
     *
     * @param dateStr
     * @param timeFormat
     * @return Date
     */
    public static Date getDateTimes(final String dateStr, final String timeFormat) {

        setDefualtDateformat(timeFormat);
        // 设置装换格式
        DateFormat format = DATEFORMAT_DEFUALT.get();
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            LOGGER.error("日期装换异常  params :" + dateStr, e);
        }
        return date;
    }

    /**
     * 设置装换格式
     *
     * @param timeFormat
     */
    private static void setDefualtDateformat(final String timeFormat) {
        if (StringUtil.isEmpty(timeFormat)) {
            throw new RuntimeException("日期类型 装换格式不能为 null ,  params :  " + timeFormat);
        }
        // 设置装换格式
        DEFUALT_DATEFORMAT = timeFormat;
    }
}
