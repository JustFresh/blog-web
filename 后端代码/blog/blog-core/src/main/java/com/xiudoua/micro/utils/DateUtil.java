package com.xiudoua.micro.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @desc 日期格式化工具类
 * @author JustFresh
 * @time 2018年11月23日 下午4:35:01
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class DateUtil {

    public static String format(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        if ((pattern == null) || (pattern.equals(""))
                || (pattern.equals("null"))) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date format(String date) {
        return format(date, null);
    }

    public static Date format(String date, String pattern) {
        if ((pattern == null) || (pattern.equals(""))
                || (pattern.equals("null"))) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        if ((date == null) || (date.equals("")) || (date.equals("null"))) {
            return new Date();
        }
        Date d = null;
        try {
            d = new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException localParseException) {
        }
        return d;
    }

    public static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        return f.format(new Date());
    }

    public static String getNowDateNoSpace() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return f.format(new Date());
    }

    public static String getNowDate() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(new Date());
    }

    public static String getYear(Date d) {
        if (d == null) {
            d = new Date();
        }
        return format(d, "yyyy");
    }

    public static String dateToString(Object date, String pattern) {
        if (date == null) {
            return "";
        }
        if ((date instanceof Date)) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }
        return "";
    }

    public static String dateToFixString(Object date, String pattern) {
        if (date == null) {
            return "&nbsp;";
        }
        if ((date instanceof Date)) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }
        return "&nbsp;";
    }

    public static String dateToFixString(Object date) {
        if (date == null) {
            return "&nbsp;";
        }
        if ((date instanceof Date)) {
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss.SSS");
            return sdf.format(date);
        }
        return "&nbsp;";
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        if (pattern == null) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatTime(Date date) {
        return formatDate(date, "HH:mm:ss");
    }

    public static String formatDate(Object o) {
        if (o == null) {
            return "";
        }
        if (o.getClass() == String.class) {
            return (String) o;
        }
        if (o.getClass() == Date.class) {
            return formatDate((Date) o);
        }
        if (o.getClass() == Timestamp.class) {
            return formatDate(new Date(((Timestamp) o).getTime()));
        }
        return o.toString();
    }

    public static String formatDateTime(Object o) {
        if (o.getClass() == String.class) {
            return (String) o;
        }
        if (o.getClass() == Date.class) {
            return formatDateTime((Date) o);
        }
        if (o.getClass() == Timestamp.class) {
            return formatDateTime(new Date(((Timestamp) o).getTime()));
        }
        return o.toString();
    }

    public static Date formatString(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            date = new Date();
        }
        return date;
    }

    public static List getWeekListOfYear(int year, String format) {
        List weekString = new ArrayList();
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        int weekAmountOfYear = time.getActualMaximum(3);
        for (int i = 1; i <= weekAmountOfYear; i++) {
            time.set(3, i);
            time.set(7, 1);
            String str = "��" + i + "��  (" + df.format(time.getTime()) + "~";
            time.set(7, 7);
            str = str + df.format(time.getTime()) + ")";
            weekString.add(str);
        }
        return weekString;
    }

    public static String getWeekStringOfNum(int year, int weekNum) {
        String str = year + "_" + weekNum + "["
                + getFirstDayOfWeek(year, weekNum) + "..";

        str = str + getLastDayOfWeek(year, weekNum) + "]";
        return str;
    }

    public static String getFirstDayOfWeek(int year, int weekNum) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        time.set(3, weekNum);
        time.set(7, time.getFirstDayOfWeek() + 1);
        return df.format(time.getTime());
    }

    public static String getLastDayOfWeek(int year, int weekNum) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        time.set(3, weekNum);
        time.setFirstDayOfWeek(2);
        time.set(7, time.getFirstDayOfWeek() + 6);
        return df.format(time.getTime());
    }

    public static int getMaxWeekNumOfYear(int year) {
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        int weekAmountOfYear = time.getActualMaximum(3);
        return weekAmountOfYear;
    }

    public static int getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(3);
    }

    public static int getLastWeekOfYear(int year) {
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        int weekAmountOfYear = time.getActualMaximum(3);
        return weekAmountOfYear;
    }

    public static Date getFirstDateOfWeek(int year, int week) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        time.set(3, week);
        time.set(7, time.getFirstDayOfWeek() + 1);
        int month = time.get(2);
        int date = time.get(5);
        time.set(year, month, date, 0, 0, 0);
        return time.getTime();
    }

    public static Date getLastDateOfWeek(int year, int week) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar time = Calendar.getInstance();
        time.set(1, year);
        time.set(3, week);
        time.setFirstDayOfWeek(2);
        time.set(7, time.getFirstDayOfWeek() + 6);
        int month = time.get(2);
        int date = time.get(5);
        time.set(year, month, date, 23, 59, 59);
        return time.getTime();
    }

    public static Date getFirstDateOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month - 1);
        int date = c.getActualMinimum(5);
        c.set(year, month - 1, date, 0, 0, 0);
        return c.getTime();
    }

    public static Date getLastDateOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month - 1);
        int date = c.getActualMaximum(5);
        c.set(year, month - 1, date, 23, 59, 59);
        return c.getTime();
    }

    public static long getDateMargin(Date beginDate, Date endDate) {
        long margin = 0L;
        margin = endDate.getTime() - beginDate.getTime();
        margin /= 86400000L;
        return margin;
    }

    public static Date getFirstDateOfYear(int year) {
        return format(year + "-1-1", "yyyy-MM-dd");
    }
    
}