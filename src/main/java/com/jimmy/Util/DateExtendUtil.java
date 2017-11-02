package com.jimmy.Util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.sql.Timestamp;
import java.text.*;
import java.util.*;

/**
 * 日期操作工具类（新）
 */
@Slf4j
public class DateExtendUtil {
    public final static long SECOND = 1000;
    public final static long MINUTE = 60 * SECOND;
    public final static long HOUR = 60 * MINUTE;
    public final static long DAY = 24 * HOUR;

    public final static String YEAR_PART = "yyyy";
    public final static String MONTH_PART = "MM";
    public final static String DATE_PART = "dd";
    public final static String HOUR_PART = "HH";
    public final static String MINUTE_PART = "mm";
    public final static String SECOND_PART = "ss";
    public final static String MILlISECOND_PART = "SSS";

    public final static String SMALL_DATE_FORMAT = "yyyy-MM-dd";
    public final static String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String FULL_DATE_NUMBER_FORMAT = "yyyyMMddHHmmss";
    public final static String MILLIS_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public final static String UTC_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * @param dateStr 字符串转日期（年月日）
     * @return
     */
    public static Date parseString2Date(String dateStr) throws Exception {
        Date dt = null;
        try {
            dt = new SimpleDateFormat(MILLIS_DATE_FORMAT).parse(dateStr);
        } catch (ParseException e0) {
            try {
                dt = new SimpleDateFormat(FULL_DATE_FORMAT).parse(dateStr);
            } catch (ParseException e1) {
                try {
                    dt = new SimpleDateFormat(SMALL_DATE_FORMAT).parse(dateStr);
                } catch (ParseException e2) {
                    throw new Exception(e2);
                }
            }
        }
        return dt;
    }

    /**
     * 将当前日期转换到秒的格式 格式如2012-12-12 12:12:12
     *
     * @param
     * @return
     */
    public static String getNowFullDate() {
        return formatDate2FullDateString(new Date());
    }

    /**
     * 将当前日期转换到日的格式 如2012-12-12
     *
     * @param
     * @return
     */
    public static String getNowSmallDate() {
        return formatDate2SmallDateString(new Date());
    }

    /**
     * 将日期转换成指定到秒格式的字符串
     *
     * @param date
     * @param
     * @return
     */
    public static String formatDate2FullDateString(Date date) {
        return formatDate2String(date, FULL_DATE_FORMAT);
    }

    public static String formatDate2FullDateString(String dateStr) throws Exception {
        Date date = parseString2Date(dateStr);
        return formatDate2String(date, FULL_DATE_FORMAT);
    }

    /**
     * 将日期转换成指定到日格式的字符串
     *
     * @param date
     * @param
     * @return
     */
    public static String formatDate2SmallDateString(Date date) {
        return formatDate2String(date, SMALL_DATE_FORMAT);
    }

    public static String formatDate2SmallDateString(String dateStr) throws Exception {
        Date date = parseString2Date(dateStr);
        return formatDate2String(date, SMALL_DATE_FORMAT);
    }

    /**
     * 将日期转换成指定格式的字符串
     *
     * @param date
     * @param formatString
     * @return
     */
    public static String formatDate2String(Date date, String formatString) {
        return new SimpleDateFormat(formatString).format(date);
    }

    public static String formatDate2String(String dateStr, String formatString) throws Exception {
        Date date = parseString2Date(dateStr);
        return new SimpleDateFormat(formatString).format(date);
    }

    /**
     * @param datePart 日期操作部分 "day"为日，"month"为月，"year"为年
     * @param count    日期数
     * @param date     日期
     * @return 日期加法结果
     */
    public static Date dateAdd(String datePart, int count, Date date) // 日期加法操作
    {
        Date resultDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        GregorianCalendar gc = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
        datePart = datePart.toLowerCase();
        if ("day".equals(datePart)) // 日
        {
            gc.add(Calendar.DATE, count);
            resultDate = (Date) gc.getTime();
        } else if ("month".equals(datePart)) // 月
        {
            gc.add(Calendar.MONTH, count);
            resultDate = (Date) gc.getTime();
        } else if ("year".equals(datePart)) // 年
        {
            gc.add(Calendar.YEAR, count);
            resultDate = (Date) gc.getTime();
        } else if ("hour".equals(datePart)) // 小时
        {
            gc.add(Calendar.HOUR, count);
            resultDate = (Date) gc.getTime();
        } else if ("minute".equals(datePart)) // 分钟
        {
            gc.add(Calendar.MINUTE, count);
            resultDate = (Date) gc.getTime();
        } else if ("second".equals(datePart)) // 秒
        {
            gc.add(Calendar.SECOND, count);
            resultDate = (Date) gc.getTime();
        }
        return resultDate;
    }

    public static String dateAdd(String datePart, int count, String date, String dateFormat) throws Exception // 日期加法操作
    {
        Date resultDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseString2Date(date));
        GregorianCalendar gc = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
        datePart = datePart.toLowerCase();
        if ("day".equals(datePart)) // 日
        {
            gc.add(Calendar.DATE, count);
            resultDate = (Date) gc.getTime();
        } else if ("month".equals(datePart)) // 月
        {
            gc.add(Calendar.MONTH, count);
            resultDate = (Date) gc.getTime();
        } else if ("year".equals(datePart)) // 年
        {
            gc.add(Calendar.YEAR, count);
            resultDate = (Date) gc.getTime();
        } else if ("hour".equals(datePart)) // 小时
        {
            gc.add(Calendar.HOUR, count);
            resultDate = (Date) gc.getTime();
        } else if ("minute".equals(datePart)) // 分钟
        {
            gc.add(Calendar.MINUTE, count);
            resultDate = (Date) gc.getTime();
        } else if ("second".equals(datePart)) // 秒
        {
            gc.add(Calendar.SECOND, count);
            resultDate = (Date) gc.getTime();
        }
        return formatDate2String(resultDate, dateFormat);
    }

    /**
     * 获取本月1号的日期字符串，比如2012-12-01
     *
     * @return
     */
    public static String getFirstDayOfMonth() {
        String ret = "";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1); // 设为本月1号
        ret = formatDate2SmallDateString(cal.getTime());
        return ret;
    }

    /**
     * 获取本周第一天
     *
     * @return
     */
    public static String getFirstDayOfWeek() {
        String ret = "";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 2);    //设为本周第一天
        ret = formatDate2SmallDateString(cal.getTime());
        return ret;
    }

    /**
     * 获取下一天（明天）
     *
     * @return
     */
    public static String getNextDay() {
        String ret = "";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1); // 日期数加1
        ret = formatDate2SmallDateString(cal.getTime());
        return ret;
    }

    /**
     * 获取下一天
     *
     * @return 下一天
     */
//    public static String getNextDay(String currentTime) {
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTimeInMillis(pareDate(currentTime, SMALL_DATE_FORMAT).getTime());
//        cal.add(Calendar.DATE, 1); // 日期数加1
//        return formatDate2SmallDateString(cal.getTime());
//    }

    /**
     * 日期的加法操作
     *
     * @param datePart
     * @param count
     * @param date
     * @return
     */
    public static Timestamp dateAddTimestamp(String datePart, int count, Timestamp date) // 日期加法操作
    {
        Timestamp resultDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        GregorianCalendar gc = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
        datePart = datePart.toLowerCase();
        if ("day".equals(datePart)) // 日
        {
            gc.add(Calendar.DATE, count);
            resultDate = new Timestamp(gc.getTimeInMillis());
        } else if ("month".equals(datePart)) // 月
        {
            gc.add(Calendar.MONTH, count);
            resultDate = new Timestamp(gc.getTimeInMillis());
        } else if ("year".equals(datePart)) // 年
        {
            gc.add(Calendar.YEAR, count);
            resultDate = new Timestamp(gc.getTimeInMillis());
        } else if ("hour".equals(datePart)) // 小时
        {
            gc.add(Calendar.HOUR, count);
            resultDate = new Timestamp(gc.getTimeInMillis());
        } else if ("minute".equals(datePart)) // 分钟
        {
            gc.add(Calendar.MINUTE, count);
            resultDate = new Timestamp(gc.getTimeInMillis());
        } else if ("second".equals(datePart)) // 秒
        {
            gc.add(Calendar.SECOND, count);
            resultDate = new Timestamp(gc.getTimeInMillis());
        }
        return resultDate;
    }

    /**
     * 日期加法操作 如果被加日期小于现在，则从现在开始加上
     *
     * @param datePart
     * @param count
     * @param date
     * @return
     */
    public static Timestamp dateAddTimestampFromNow(String datePart, int count, Timestamp date) // 日期加法操作
    {
        Timestamp timeNow = new Timestamp(new Date().getTime());
        if (date.before(timeNow))
            date = timeNow;
        return dateAddTimestamp(datePart, count, date);
    }

    /**
     * --------------------------added at
     * 2009-12-3-----------------------------------------------
     */
    /**
     * 计算两个日期的月份差
     *
     * @param cal  被减数
     * @param cal1 减数
     * @return
     */
    public static int getMonthDiff(Calendar cal, Calendar cal1) {
        int m = (cal.get(Calendar.MONTH)) - (cal1.get(Calendar.MONTH));
        int y = (cal.get(Calendar.YEAR)) - (cal1.get(Calendar.YEAR));
        return y * 12 + m;
    }

    public static int getMonthDiff(String beginStr, String endStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = sdf.parse(beginStr);
        Date endDate = sdf.parse(endStr);
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int m = (beginCalendar.get(Calendar.MONTH)) - (endCalendar.get(Calendar.MONTH));
        int y = (beginCalendar.get(Calendar.YEAR)) - (endCalendar.get(Calendar.YEAR));
        return y * 12 + m;
    }

    /**
     * 计算日期相差天数
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;
    }

    /**
     * 获取两个日期的差值 date2-date1
     *
     * @param datePart
     * @param date1
     * @param date2
     * @return
     */
    public static long dateDiff(String datePart, Date date1, Date date2) {

        long ret = 0;

        // 年
        if ("year".equalsIgnoreCase(datePart) || "y".equalsIgnoreCase(datePart)) {
            ret = (date2.getTime() - date1.getTime()) / (365 * 24 * 60 * 60 * 1000);
            return ret;
        }
        // 月
        if ("month".equalsIgnoreCase(datePart) || "m".equalsIgnoreCase(datePart)) {
            ret = (date2.getTime() - date1.getTime()) / (30 * 24 * 60 * 60 * 1000);
            return ret;
        }
        // 日
        if ("day".equalsIgnoreCase(datePart) || "d".equalsIgnoreCase(datePart)) {
            ret = (date2.getTime() - date1.getTime()) / (1 * 24 * 60 * 60 * 1000);
            return ret;
        }
        // 时
        if ("hour".equalsIgnoreCase(datePart) || "h".equalsIgnoreCase(datePart)) {
            ret = (date2.getTime() - date1.getTime()) / (1 * 60 * 60 * 1000);
            return ret;
        }
        // 分
        if ("minute".equalsIgnoreCase(datePart) || "min".equalsIgnoreCase(datePart)) {
            ret = (date2.getTime() - date1.getTime()) / (1 * 60 * 1000);
            return ret;
        }
        // 秒
        if ("second".equalsIgnoreCase(datePart) || "s".equalsIgnoreCase(datePart)) {
            ret = (date2.getTime() - date1.getTime()) / (1 * 1000);
            return ret;
        }
        //
        return ret;
    }

    /**
     * 获取两个日期的差值 date2-date1 日期格式为字符串
     *
     * @param datePart
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static long dateDiff(String datePart, String date1, String date2) throws Exception {

        return dateDiff(datePart, parseString2Date(date1), parseString2Date(date2));
    }

    /**
     * 获取两个日期的差值（天数） date2-date1 日期格式为字符串
     *
     * @param
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static long dateDayDiff(String date1, String date2) throws Exception {

        return dateDiff("day", parseString2Date(date1), parseString2Date(date2));
    }

    /**
     * 获取两个日期的差值（月数） date2-date1 日期格式为字符串
     *
     * @param
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static long dateMonthDiff(String date1, String date2) throws Exception {

        return dateDiff("month", parseString2Date(date1), parseString2Date(date2));
    }

    /**
     * 获取两个日期的差值（年数） date2-date1 日期格式为字符串
     *
     * @param
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static long dateYearDiff(String date1, String date2) throws Exception {

        return dateDiff("year", parseString2Date(date1), parseString2Date(date2));
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Timestamp getNowTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 获取过去的多少天的时间
     *
     * @param passDay      passDay 过去1天：-1
     * @param formatString 返回时间格式
     * @return
     * @author zhour
     * @version 2012-11-14 下午4:02:12
     */
    public static String getPassByDate(int passDay, String formatString) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, passDay);
        //
        return new SimpleDateFormat(formatString).format(cal.getTime());
    }

    /**
     * 获取UTC时间
     *
     * @param opDate
     * @return
     */
    public static Date getUTCDate(Date opDate) {

        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance();
        cal.setTime(opDate);

        // 2、取得时间偏移量：
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);

        // 3、取得夏令时差：
        int dstOffset = cal.get(Calendar.DST_OFFSET);

        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        return new Date(cal.getTimeInMillis());
    }

    /**
     * 将String转Timestamp
     *
     * @param dateTime
     * @return
     * @author zhour
     * @version 2012-12-14 上午11:33:46
     */
    public static Timestamp getTimestampForString(String dateTime) {
        return Timestamp.valueOf(dateTime);
    }

    /**
     * 获取两个日期间所有日期的集合
     *
     * @param beginDate
     * @param endDate
     * @param dateFormat
     * @return
     */
    public static List<String> getAllBetweenTwoDate(String beginDate, String endDate, String dateFormat) {
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        Date start = null;
        Date end = null;
        try {
            start = df.parse(beginDate);
            end = df.parse(endDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            log.error("call Exception:{}", e);
            ;
        }
        startCalendar.setTime(start);
        endCalendar.setTime(end);
        List<String> dateList = new ArrayList<String>();
        while (true) {
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {// TODO
                dateList.add(df.format(startCalendar.getTime()));
            } else {
                break;
            }
        }
        return dateList;
    }

    /**
     * 周计数,为全年中的周计数
     *
     * @param year
     * @param weekCount
     * @return
     */
    public static List<String> getWeekDateByWeekInYear(int year, int weekCount) {
        List<String> returnDayList = new ArrayList<String>();
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        // 设置calendar的日期,此处可以确定某一天
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, weekCount);
        // 获取该天的信息(理论而言,通过改变get函数的参数,可以获取该天的任意信息)
        int day = cal.get(Calendar.DAY_OF_YEAR);
        int[] days = new int[7];
        for (int i = 0; i < 7; i++) {
            days[i] = cal.get(Calendar.DAY_OF_MONTH);
            String dayStr = (cal.get(Calendar.YEAR)) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
            if (!returnDayList.contains(dayStr)) {
                returnDayList.add(dayStr);
            }
            day++;
            cal.set(Calendar.DAY_OF_YEAR, day);
        }
        return returnDayList;
    }

    /**
     * 得到一天是一年中的第几周     
     */
    public static String getWeekForYear(String date) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(date));
        } catch (Exception e) {
            log.error("call Exception:{}", e);
            ;
        }
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        return year + "-" + week;
    }


    /**
     * 获取两个日期之间的周
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static List<String> getAllBetweenTwoWeek(String beginDate, String endDate) {
        List<String> weekLists = new ArrayList<String>();
        //
        List<String> days = getAllBetweenTwoDate(beginDate, endDate, SMALL_DATE_FORMAT);
        for (String day : days) {
            if (!weekLists.contains(day)) {
                weekLists.add(day);
            }
        }
        //
        return weekLists;
    }

    /**
     * 设置转换时间格式，可自行添加
     */
    @SuppressWarnings("serial")
    private static final Map<Integer, String> FTimeType = new HashMap<Integer, String>() {{
        put(0, "yyyy-MM-dd HH:mm:ss");
        put(1, "yyyy-MM-dd");
    }};

    /**
     * 比较时间相差天数
     * -1起始时间大于结束时间
     * 0同一天
     * -2 时间格式异常
     */
    public static long compare_date(String start, String end, int TimeType) {
        try {
            DateFormat df = new SimpleDateFormat(FTimeType.get(TimeType));//日期格式控制
            Date dt1 = df.parse(start);
            Date dt2 = df.parse(end);
            if (dt1.getTime() > dt2.getTime()) {
                return -1;            //	"start 在end后面"
            } else if (dt1.getTime() < dt2.getTime()) {
                return (dt2.getTime() - dt1.getTime()) / (24 * 60 * 60 * 1000);          //相差天数
            } else {
                return 0;
            }        //同一天
        } catch (Exception exception) {
            return -2;
        }
    }

    /**
     * 获取日期之间月相差值
     *
     * @param begin_time
     * @param end_time
     * @return
     */
    public static List<String> getBaseListByMonth(String begin_time, String end_time) {
        List<String> returnList = new ArrayList<String>();
        //
        List<String> dayList = getAllBetweenTwoDate(begin_time, begin_time, DateExtendUtil.SMALL_DATE_FORMAT);
        for (String day : dayList) {
            day = day.substring(0, 7);
            if (!returnList.contains(day)) {
                returnList.add(day);
            }
        }
        //
        return returnList;
    }

    /**
     * 获取日期之间周相差值
     *
     * @param
     * @param
     * @param
     * @return
     */
    public static List<String> getBaseListByWeek(Calendar c_begin, Calendar c_end) {
        List<String> ret = new ArrayList<String>();

        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weeks = dfs.getWeekdays();
        int count = 1;
        int temp = 1;
        String tempStr = "";
        //
        String timeStr = DateExtendUtil.formatDate2SmallDateString(c_begin.getTime());
        String endStr = DateExtendUtil.formatDate2SmallDateString(c_end.getTime());
        //
        c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
        while (c_begin.before(c_end)) {
            if (temp != count) {
                timeStr = timeStr + "~" + tempStr.substring(tempStr.indexOf("-") + 1, tempStr.length());
                ret.add(timeStr);
                temp = count;
                timeStr = DateExtendUtil.formatDate2SmallDateString(c_begin.getTime());
            }
            if (c_begin.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                tempStr = DateExtendUtil.formatDate2SmallDateString(c_begin.getTime());
                count++;
            }
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
        }
        ret.add(timeStr + "~" + endStr.substring(endStr.indexOf("-") + 1, endStr.length()));

        return ret;
    }

    /**
     * 获取日期相差值
     *
     * @param start
     * @param end
     * @param calendarType
     * @return
     */
    public static List<String> getBaseListByDay(Date start, Date end, int calendarType) {
        ArrayList<String> ret = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        Date tmpDate = calendar.getTime();

        long endTime = end.getTime();

        while (tmpDate.before(end) || tmpDate.getTime() == endTime) {
            ret.add(DateExtendUtil.formatDate2SmallDateString(calendar.getTime()));
            calendar.add(calendarType, 1);
            tmpDate = calendar.getTime();
        }

        return ret;
    }

    /**
     * 获取小时相差值
     *
     * @param
     * @param
     * @param
     * @return
     */
    public static List<String> getBaseListByHour(List<String> listDay) {
        List<String> ret = new ArrayList<String>();
        String[] timePoint = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
                , "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        for (int m = 0; m < listDay.size(); m++) {
            for (int i = 0; i < timePoint.length; i++) {
                String day = listDay.get(m);
                if (day.startsWith("0")) {
                    day = day.substring(1, day.length());
                }
                ret.add(day + " " + timePoint[i]);
            }
        }
        return ret;
    }

    /**
     * 获取是周几
     *
     * @param date
     * @return
     */
    public static int getDateForWeek(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        try {
            beginDate = sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            log.error("call Exception:{}", e);
            ;
        }
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        int week = beginCalendar.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {
            week = 7;
        } else {
            week = week - 1;
        }
        //
        return week;
    }

    /**
     * 默认日期格式
     */
    public static final String DATE_SHOW_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SHORT_FORMAT = "yyyyMMdd";
    public static final String DATE_MONTH_FORMAT = "yyyyMM";
    public static final String DATE_MONTH_FORMAT2 = "yyyy-MM";
    public static final String DATE_TIMEC_FORMAT = "yyyyMMddHH24ssmm";
    public static final String DATE_TIMES_FORMAT = "yyyyMMddhhmmss";
    public static final String DATE_TIME_FORMAT_NO_SPLIT = "yyyyMMddHHmmss";

    /**
     * 得到指定月的最后一天的日期
     *
     * @param month yyyyMM 如：201309 返回 20130930
     * @return 返回结果
     */
//    public static String getLastDayFromMonth(String month) {
//        if (month.length() != 6) {
//            return "";
//        }
//        DateTime dt = DateTime.parse(month, DateTimeFormat.forPattern(DATE_MONTH_FORMAT));
//
//        return month + "" + dt.dayOfMonth().getMaximumValue();
//    }

    /**
     * 得到指定月的第一天的日期
     *
     * @param month yyyyMM 如：201309 返回 20130901
     * @return 返回结果
     */
//    public static String getFirstDayFromMonth(String month) {
//        if (month.length() != 6) {
//            return "";
//        }
//        DateTime dt = DateTime.parse(month, DateTimeFormat.forPattern(DATE_MONTH_FORMAT));
//
//        return month + "0" + dt.dayOfMonth().getMinimumValue();
//    }

    /**
     * 得到今天指定格式的日期
     *
     * @param format 日期格式
     * @return 返回结果
     */
//    public static String getToDay(String format) {
//        return new DateTime().toString(StringUtils.isEmpty(format) ? DATE_SHORT_FORMAT : format);
//    }

    /**
     * 得到昨天的日期
     *
     * @return YYYYMMDD
     */
//    public static String getYesterdayDate(String format) {
//        if (StringUtils.isEmpty(format)) {
//            format = DATE_SHORT_FORMAT;
//        }
//        return DateExtendUtil.getAroundDateByDay(-1, DateExtendUtil.getToDay(DATE_SHORT_FORMAT), format);
//    }

    /**
     * 得到指定日期的相隔日期
     *
     * @param cycleNum 相隔多少天
     * @param inDate   传入的时间，格式：yyyyMMdd
     * @param format   传出的时间格式
     * @return 返回结果
     */
//    public static String getAroundDateByDay(int cycleNum, String inDate, String format) {
//        inDate = inDate.substring(0, 4) + "-" + inDate.substring(4, 6) + "-" + inDate.substring(6, 8);
//        return new DateTime(inDate).plusDays(cycleNum).toString(StringUtils.isEmpty(format) ? DATE_SHORT_FORMAT : format);
//    }

    /**
     * 得到指定日期的相隔时间
     *
     * @param cycleNum 相隔多少分钟
     * @param inDate   传入的时间，格式：yyyyMMddhhmmss
     * @param format   传出的时间格式
     * @return 返回结果
     */
//    public static String getAroundDateByMinu(int cycleNum, String inDate, String format) {
//        DateTime dt = new DateTime(Integer.valueOf(inDate.substring(0, 4)),
//                Integer.valueOf(inDate.substring(4, 6)),
//                Integer.valueOf(inDate.substring(6, 8)),
//                Integer.valueOf(inDate.substring(8, 10)),
//                Integer.valueOf(inDate.substring(10, 12)),
//                Integer.valueOf(inDate.substring(12, 14)), 0);
//        DateTime time = dt.minusMinutes(cycleNum);
//        return time.toString(StringUtils.isEmpty(format) ? DATE_SHORT_FORMAT : format);
//    }

    /**
     * 得到指定日期的相隔日期
     *
     * @param cycleNum 相隔多少小时
     * @param inDate   传入的时间，格式：yyyyMMdd
     * @param format   传出的时间格式
     * @return 返回结果
     */
//    public static String getAroundDateByHour(int cycleNum, String inDate, String format) {
//        DateTime dt = new DateTime(Integer.valueOf(inDate.substring(0, 4)),
//                Integer.valueOf(inDate.substring(4, 6)),
//                Integer.valueOf(inDate.substring(6, 8)),
//                Integer.valueOf(inDate.substring(8, 10)),
//                Integer.valueOf(inDate.substring(10, 12)),
//                Integer.valueOf(inDate.substring(12, 14)), 0);
//        DateTime dtime = dt.minusHours(cycleNum);
//        return dtime.toString(StringUtils.isEmpty(format) ? DATE_SHORT_FORMAT : format);
//    }

    /**
     * 得到指定日期的相隔年数的日期
     *
     * @param cycleNum 相隔多少年
     * @param inDate   传入的时间，格式：yyyyMMdd
     * @param format   传出的时间格式
     * @return 返回结果
     */
//    public static String getAroundDateByYear(int cycleNum, String inDate, String format) {
//        DateTime dt = new DateTime(Integer.valueOf(inDate.substring(0, 4)),
//                Integer.valueOf(inDate.substring(4, 6)),
//                Integer.valueOf(inDate.substring(6, 8)), 0, 0, 0, 0);
//
//        return dt.plusYears(cycleNum).toString(StringUtils.isEmpty(format) ? DATE_SHORT_FORMAT : format);
//    }
//
//
//    /**
//     * 得到指定日期的相隔月数的日期
//     *
//     * @param cycleNum 相隔多少年
//     * @param inDate   传入的时间，格式：yyyyMMdd
//     * @param format   传出的时间格式
//     * @return 返回结果
//     */
//    public static String getAroundDateByMonth(int cycleNum, String inDate, String format) {
//        DateTime dt = new DateTime(Integer.valueOf(inDate.substring(0, 4)),
//                Integer.valueOf(inDate.substring(4, 6)),
//                Integer.valueOf(inDate.substring(6, 8)),
//                Integer.valueOf(inDate.substring(8, 10)),
//                Integer.valueOf(inDate.substring(10, 12)),
//                Integer.valueOf(inDate.substring(12, 14)));
//        DateTime dtime = dt.plusMonths(cycleNum);
//
//        return dtime.toString(StringUtils.isEmpty(format) ? DATE_SHORT_FORMAT : format);
//    }

    /**
     * 计算两个日期的间隔天数
     *
     * @param startDate 开始时间，如：2008-12-03 11:00:00
     * @param endDate   结束时间，如：2009-12-31 11:00:00
     * @return long     间隔天数(long)
     */
    public static long getBetweenDays(Date startDate, Date endDate) {
        if (endDate == null || startDate == null) {
            return -1;
        }
        Long days = endDate.getTime() - startDate.getTime();

        return days / (1000 * 60 * 60 * 24);
    }

    /**
     * 验证输入的文本信息日期是否合法
     *
     * @param dateStr 传入参数
     * @return 返回结果
     */
    public static Date isDate(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        String date_format_1 = "yyyy/MM/dd";
        String date_format_2 = "yyyy-MM-dd";
        String date_format_3 = "yyyyMMdd";
        String date_format_4 = "yyyy.MM.dd";
        String[] date_format = {date_format_1, date_format_2, date_format_3, date_format_4};
        for (String dateFormat : date_format) {
            Date tempDate = isDate(dateStr, dateFormat);
            if (null != tempDate) {
                return tempDate;
            }
        }
        return null;
    }

    /**
     * 验证输入的文本信息日期是否合
     *
     * @param dateStr       需要验证的日期
     * @param patternString 日期格式
     * @return Date
     */
    public static Date isDate(String dateStr, String patternString) {
        if (StringUtils.isEmpty(patternString)) {
            patternString = DateExtendUtil.DATE_SHORT_FORMAT;
        }
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            FastDateFormat formatDate = FastDateFormat.getInstance(patternString);
            ParsePosition pos = new ParsePosition(0);
            Date tempDate = (Date) formatDate.parseObject(dateStr, pos);
            tempDate.getTime();
            return tempDate;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * date 转String
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return 转换之后的字符串
     */
    public static String pareDate(Date date, String pattern) {
        if (null == date) {
            return "";
        }
        if (StringUtils.isEmpty(pattern)) {
            pattern = DATE_SHORT_FORMAT;
        }
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * String 转date
     *
     * @param dateStr 需要转换的字符串
     * @param pattern 转换的格式
     * @return 返回日期
     */
//    public static Date pareDate(String dateStr, String pattern) {
//        if (null == dateStr || "".trim().equals(dateStr)) {
//            return null;
//        }
//        if (StringUtils.isEmpty(pattern)) {
//            pattern = DATE_SHORT_FORMAT;
//        }
//        DateTime dt = DateTime.parse(dateStr, DateTimeFormat.forPattern(pattern));
//        return dt.toDate();
//    }

    /**
     * String 转date
     *
     * @param dateStr 需要转换的字符串
     * @return 返回日期
//     */
//    public static Date pareDate(String dateStr) {
//        return pareDate(dateStr, DATE_TIME_FORMAT_NO_SPLIT);
//    }
//
//    /**
//     * String 转date
//     *
//     * @param dateStr 需要转换的字符串
//     * @return 返回日期
//     */
//    public static Date pareDateNew(String dateStr) {
//        return pareDate(dateStr, DATE_TIME_FORMAT);
//    }

    /**
     * 格式化Date
     *
     * @param date    需要格式化的日期
     * @param pattern 日期格式
     * @return 返回格式化之后的日期
     */
//    public static Date formatDate(Date date, String pattern) {
//        if (null == date) {
//            return null;
//        }
//        if (StringUtils.isEmpty(pattern)) {
//            pattern = DATE_SHORT_FORMAT;
//        }
//        String dateStr = DateFormatUtils.format(date, pattern);
//        return pareDate(dateStr, pattern);
//    }
//
//    /**
//     * 得到两个时间相隔的秒
//     *
//     * @param beginDate 开始日期
//     * @param endDate   结束日期
//     * @return Long
//     */
//    public static long getAroundMinute(String beginDate, String endDate) {
//        return Seconds.secondsBetween(getDateTime(beginDate, DATE_TIME_FORMAT_NO_SPLIT),
//                getDateTime(endDate, DATE_TIME_FORMAT_NO_SPLIT)).getSeconds();
//    }
//
//    /**
//     * 通过指定日期和格式，获取日期时间
//     *
//     * @param inDate 指定日期
//     * @param format 日期格式
//     * @return DateTime
//     */
//    public static DateTime getDateTime(String inDate, String format) {
//        if (StringUtils.isEmpty(format)) {
//            format = DATE_SHORT_FORMAT;
//        }
//        return DateTime.parse(inDate, DateTimeFormat.forPattern(format));
//    }

    /**
     * 判断传入参数格式为yyyyMMdd的数据是否是有效的日期类型
     *
     * @param inputDate 需要验证的日期
     * @return 返回是否校验成功
     */
    public static boolean validDate(String inputDate) {
        return inputDate.matches("[1-9][0-9]{3}(0[0-9]|1[0-2])(0[0-9]|1[0-9]|2[0-9]|3[0-1])");
    }

    /**
     * 增加时间
     *
     * @param date          时间
     * @param calendarField 类型
     * @param amount        时间
     * @return 返回结果
     */
    private static Date addDate(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date could not be null!");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    /**
     * 按秒偏移,根据{@code source}得到{@code seconds}秒之后的日期<Br>
     *
     * @param source  , 要求非空
     * @param seconds , 秒数,可以为负
     * @return 新创建的Date对象
     */
    public static Date addSeconds(Date source, int seconds) {
        return addDate(source, Calendar.SECOND, seconds);
    }

    /**
     * 按秒偏移,根据{@code source}得到{@code seconds}秒之后的String日期<Br>
     *
     * @param source 传入日期
     * @param seconds 秒数
     * @param format 日期格式
     * @return 处理后的日期
     */
    public static String addSeconds(String source, int seconds, String format) {

        Date toDate = null;
        SimpleDateFormat sdf = null;

        try{
            sdf = new SimpleDateFormat(format);
            toDate = sdf.parse(source);
        }catch (Exception e){
            try{
                sdf = new SimpleDateFormat(format);
                toDate = sdf.parse(SMALL_DATE_FORMAT);
                format = SMALL_DATE_FORMAT;
            }catch (Exception e1){
                log.error("增加秒转化日期异常：{}", e1);
            }
        }
        if(toDate != null){
            Date turnDate = addSeconds(toDate, seconds);
            sdf = new SimpleDateFormat(format);
            return sdf.format(turnDate);
        }else{
            return null;
        }

    }

    /**
     * 当前日期移动天数
     *
     * @param source  日期
     * @param addDays 新增天数
     * @return Date
     */
    public static Date addDays(Date source, int addDays) {
        return addDate(source, Calendar.DAY_OF_MONTH, addDays);
    }

    /**
     * Date类型转换String 格式：yyyyMMdd
     *
     * @param date 日期
     * @return String类型
     */
//    public static String defaultFormat(Date date) {
//        if (date == null) return null;
//        return new DateTime(date).toString(DATE_SHOW_FORMAT);
//    }


    /**
     * @param dateStr 字符串转日期（年月日）
     * @return
     */
    public static String parseStringToString(String dateStr, String format) throws Exception {
        String sDate = "";
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        try {
            Date date = sdf1.parse(dateStr);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sDate = sdf.format(date);
        } catch (ParseException e) {
            log.error("parseStringToString 日期转化失败", e);
        }
        return sDate;
    }

    /**
     * 获取当天Date
     */
    public static Date getStartTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天结束Date
     */
    public static Date getEndTime(){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }
}