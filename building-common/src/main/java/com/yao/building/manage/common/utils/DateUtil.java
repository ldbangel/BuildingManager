package com.yao.building.manage.common.utils;

import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DateUtil {

    public static String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    public static String yyyy_MM_dd = "yyyy-MM-dd";

    public static String yyyyMMdd = "yyyyMMdd";

    public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static long DAY_MILLISECOND = 24 * 60 * 60 * 1000;


    /**
     * 使用ThreadLocal来解决SimpleDateFormat非线程安全的问题
     */
    private static ThreadLocal<Map<String, SimpleDateFormat>> threadLocal = new ThreadLocal<Map<String, SimpleDateFormat>>(){
        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            log.debug("Thread-Id:{} init pattern:{}", Thread.currentThread().getId(), Thread.currentThread());
            return new HashMap<String, SimpleDateFormat>(2);
        }
    };

    public static SimpleDateFormat getSimpleDateFormat(final String format) {
        Map<String, SimpleDateFormat> dateFormatMap = threadLocal.get();
        SimpleDateFormat sdf = dateFormatMap.get(format);
        if (sdf == null) {
            log.debug("Thread-Id:{} put new SimpleDateFormat to map ,the format:{}", Thread.currentThread().getId(), format);
            sdf = new SimpleDateFormat(format);
            dateFormatMap.put(format, sdf);
        }
        return sdf;
    }

    public static Date parse(String date, String format) throws ParseException {
        if(StringUtil.isEmpty(date) || StringUtil.isEmpty(format)){
            return null;
        }
        return getSimpleDateFormat(format).parse(date);
    }

    public static boolean between(Date date, Date ltDate, Date gtDate){
        if(null == date){
            return false;
        }

        if(null != ltDate){
            if(date.before(ltDate)){
                return false;
            }
        }

        if(null != gtDate){
            if(date.after(gtDate)){
                return false;
            }
        }
        return true;
    }

    public static String format(Date date, String format){
        if(null == date || null == format){
            return StringUtils.EMPTY;
        }

        return getSimpleDateFormat(format).format(date);
    }

    /**
     * 获得两个日期之间相差多少个月份
     *
     * @param beforeDate
     * @param afterDate
     * @return
     */
    public static int getMonthBetweenTwoDate(Date beforeDate, Date afterDate) {
        Calendar before = Calendar.getInstance();
        Calendar after = Calendar.getInstance();

        before.setTime(beforeDate);
        after.setTime(afterDate);

        int month = after.get(Calendar.MONTH) - before.get(Calendar.MONTH);
        int yearMonth = (after.get(Calendar.YEAR) - before.get(Calendar.YEAR)) * 12;
        return month + yearMonth;
    }

    /**
     * 转换前端传过来的年月
     *
     * @param month 如:"2017-06"
     * @return
     */
    public static Date getMonthDate(String month) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");

        try {
            Date date = df.parse(month);
            return date;
        } catch (Exception e) {
            log.error("date parse error,month:{},e:{}", month, e.getMessage());
            return null;
        }

    }

    /**
     * 转换前端传过来的年月
     *
     * @param day 如:"2017-08-04"
     * @return
     */
    public static Date getFormatDate(String day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = df.parse(day);

            return date;
        } catch (Exception e) {
            log.error("date parse error,day:{}", day, e);
            return null;
        }

    }

    /**
     * 获得某日第0秒
     *
     * @param day
     * @return
     */
    public static String getStartTimeForDay(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return getSimpleDateFormat(yyyy_MM_dd_HH_mm_ss).format(calendar.getTime());
    }

    /**
     * 获得某日最后一秒
     *
     * @param day
     * @return
     */
    public static String getEndTimeForDay(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return getSimpleDateFormat(yyyy_MM_dd_HH_mm_ss).format(calendar.getTime());
    }

    /**
     * 获取i天后的日期，i为正为i天后，i为负为|i|天前，时间为00:00:00
     *
     * @return
     */
    public static Date[] getYesterdayScope() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, +1);

        Date endDate = calendar.getTime();

        return new Date[]{startDate, endDate};

    }

    /**
     * 获得传入时间所在月份的第一秒和最后一秒Date
     */
    public static Date[] getMonthDayScope(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date startDate = calendar.getTime();
        //calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, -1);

        Date endDate = calendar.getTime();

        return new Date[]{startDate, endDate};
    }

    /**
     * 获取i个月后的最后一天(i可以为负数)
     *
     * @param i
     * @return
     */
    public static Date getLastDayOfIMonthAgo(int i) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, i);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取两个日期间相隔的天数(startDate 大于 endDate输出0)
     *
     * @return
     */
    public static int getDaysBetweenDates(Date startDate, Date endDate) {

        long startTime = startDate.getTime();
        long endTime = endDate.getTime();

        if (startTime > endTime) {
            return 0;
        }

        return (int) ((endTime - startTime) / (1000 * 3600 * 24)) + 1;
    }

    /**
     * 获取昨天最后一秒
     */
    public static Date getYesterdayLastSecond() {
        Date now = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    /**
     * 格式化日期为 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return getSimpleDateFormat(yyyy_MM_dd_HH_mm_ss).format(date);
    }


    /**
     * 获取当月第一天时间
     */
    public static Date getStartDateOfCurrentMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }


    /**
     * 获取上月第一天
     *
     * @return
     */
    public static Date getStartDateOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取上月最后时间
     */
    public static Date getLastDateOfLastMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);

        return calendar.getTime();
    }


    /**
     * 获取当月最后时间
     */
    public static Date getLastDateOfCurrentMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);

        return calendar.getTime();
    }

    /**
     * @param date
     * @param num  num 1 明天 -1 昨天 ，以此类推
     * @return
     */
    public static Date getDateNear(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 0 + num);
        Date time = cal.getTime();
        return time;
    }

    /**
     * @param date1
     * @param date2
     * @return
     * @throws Exception
     */
    public static int subDay(Date date1, Date date2) throws Exception {
        if (null == date1 || null == date2) {
            return 0;
        }

        Date d1 = null;
        Date d2 = null;
        if(date1.getTime() > date2.getTime()) {
            d1 = getSimpleDateFormat(yyyy_MM_dd).parse(getSimpleDateFormat(yyyy_MM_dd).format(date1));
            d2 = getSimpleDateFormat(yyyy_MM_dd).parse(getSimpleDateFormat(yyyy_MM_dd).format(date2));
        }else{
            d2 = getSimpleDateFormat(yyyy_MM_dd).parse(getSimpleDateFormat(yyyy_MM_dd).format(date1));
            d1 = getSimpleDateFormat(yyyy_MM_dd).parse(getSimpleDateFormat(yyyy_MM_dd).format(date2));
        }

        Long distance = (d1.getTime() - d2.getTime()) / (DAY_MILLISECOND);
        return distance.intValue();
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date str2Date(String strDate) {
        if (StringUtil.isEmpty(strDate)) {
            return null;
        }

        SimpleDateFormat formatter = null;
        if (StringUtils.length(strDate) == 10) {
            formatter = getSimpleDateFormat(yyyy_MM_dd);
        } else if (StringUtils.length(strDate) == 19) {
            formatter = getSimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        } else {
            return null;
        }

        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 获取T-{index}时间
     * @param date
     * @param index
     * @return
     */
    public static Date getDateTime(Date date, int index){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, index);
        return setDateStartTime(calendar.getTime());
    }

    /**
     * 设置日期为0点0分0秒
     * @param date
     * @return
     */
    public static Date setDateStartTime(Date date){

        return setDateWithTime(date, 0, 0, 0);
    }

    /**
     * 设置日期的时分秒
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date setDateWithTime(Date date, int hour, int minute, int second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 判断两个日期是否属于同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
    }

    /**
     * 获取当天对应星期
     * @param weekDays 枚举，默认周日周一..可自定义星期日星期一
     * @param date
     * @return
     */
    public static String getWeek(String[] weekDays, Date date){
        if(weekDays == null){
            weekDays = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }

        return weekDays[w];
    }

    /**
     * 获取两个日期相差天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    public static void main(String[] args) throws Exception {
        Date tmp01 = getSimpleDateFormat(yyyy_MM_dd).parse("2018-09-11");
        Date tmp02 = getSimpleDateFormat(yyyy_MM_dd).parse("2018-09-12");
        Date tmp03 = getSimpleDateFormat(yyyy_MM_dd).parse("2018-01-03");
        System.out.println(format(tmp01, yyyy_MM_dd_HH_mm_ss));
        System.out.println(between(tmp01, tmp03, tmp02));

    }
}
