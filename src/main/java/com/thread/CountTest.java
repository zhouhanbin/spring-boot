package com.thread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CountTest {
    public static void main(String[] args) {
        try {
            int index = 19;
            for (int i = index; i < 30; i++) {
                String date = "2019-04-" + i;
                int studyCountDay = 1;
                int planStartClassNum = 1;
                Date startDate = CountTest.parse(date, "yyyy-MM-dd");
                Date planStartDate = CountTest.parse("2019-04-" + index, "yyyy-MM-dd");
                String weekStr = "1,2,3,4,5,6,7";
                String[] weeks = weekStr.split(",");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                // 获取查询日期为星期几
                Integer week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                week = week == 0 ? 7 : week;
                // 计算开始计划距离查询日期多少天
                int daysBefore = CountTest.daysBefore(startDate, planStartDate);
                // 已经学到第几课时
                int startClassNum;
                // 开始学习为周几
                calendar.setTime(planStartDate);
                // 开始学习日期是周几
                Integer startWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                startWeek = startWeek == 0 ? 7 : startWeek;

                int interval;
                // 已经学习了几周
                int studyWeek = (daysBefore + 1) / 7;
                // 今日星期几间隔开始学习那天星期几天数
                if (week < startWeek) {
                    interval = ((weekStr.indexOf(String.valueOf(week)) / 2) + (weekStr.length() / 2)
                            - (weekStr.indexOf(String.valueOf(startWeek)) / 2) + 1) * studyCountDay;
                } else {
                    interval = (week - startWeek) * studyCountDay;
                }
                // 第一周开始学
                if ((daysBefore + 1) <= weeks.length || studyWeek == 0) {
                    startClassNum = interval + planStartClassNum;
                } else {
                    if (weeks.length == 1) {
                        startClassNum = ((studyWeek) * weeks.length * studyCountDay) + planStartClassNum;
                        startClassNum = startClassNum + interval;
                    } else {
                        if (interval == 6) {
                            // 学习了几周
                            startClassNum = ((studyWeek - 1) * weeks.length * studyCountDay) + planStartClassNum;
                            startClassNum = startClassNum + interval;
                        } else {
                            startClassNum = (studyWeek * weeks.length * studyCountDay) + planStartClassNum;
                            startClassNum = startClassNum + interval;

                        }
                    }

                }
                if (weekStr.contains(String.valueOf(week))) {
                    System.out.println(date);
                    System.out.println(startClassNum);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static int daysBefore(Date source1, Date source2) {
        if (source1 != null && source2 != null) {
            Calendar now = Calendar.getInstance();
            Calendar old = Calendar.getInstance();
            old.setTime(source1);
            old.set(11, 0);
            old.set(12, 0);
            old.set(13, 0);
            now.setTime(source2);
            now.set(11, 0);
            now.set(12, 0);
            now.set(13, 0);
            long l = old.getTimeInMillis() - now.getTimeInMillis();
            return BigDecimal.valueOf(l).divide(BigDecimal.valueOf(86400000L), RoundingMode.HALF_UP).intValue();
        } else {
            return 0;
        }
    }

    public static Date parse(String source, String pattern) throws ParseException {
        if (!(source == null || source.trim().length() == 0) && source != null) {
            if (pattern == null) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.US);
            return format.parse(source);
        } else {
            return null;
        }
    }

    public static int getToday(Integer studyCountDay, String weekStr, Date startDate, Date endDate) {
        String[] weeks = weekStr.split(",");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        week = week == 0 ? 7 : week;
        // 计算开始计划距离查询日期多少天
        int daysBefore = CountTest.daysBefore(endDate, startDate);
        if (daysBefore % weeks.length == 0) {
            return (daysBefore / weeks.length * 7 * studyCountDay) + 1;
        } else {
            int aa = daysBefore % weeks.length;
            int total = daysBefore / weeks.length;
            for (int i = week; i < 8; i++) {
                if (weekStr.contains(String.valueOf(i))) {
                    total++;
                    aa--;
                }
                if (i == 7) {
                    i = 1;
                }
                if (aa == 0) {
                    break;
                }

            }
            return total + 1;
        }
    }

    public static Date addByDate(Date date, int type, int value) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(type, now.get(type) + value);
        return now.getTime();
    }

    public static void a(String[] args) {
        try {
            String weekStr = "1,2,3,4,5,6";
            for (int i = 12; i < 23; i++) {
                String date = "2019-04-" + i;
                Date startDate = CountTest.parse(date, "yyyy-MM-dd");
                Date planStartDate = CountTest.parse("2019-04-12", "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                week = week == 0 ? 7 : week;
                if (weekStr.contains(String.valueOf(week))) {
                    int a = CountTest.getToday(1, weekStr, planStartDate, startDate);
                    System.out.println(date);
                    System.out.println(a);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    int a = 0;
//    // 开始时间下一周
//    Date nextStartDate;
//    int star= 0;
//                if (startWeek == 1) {
//        nextStartDate = planStartDate;
//    } else {
//        for (int j = startWeek; j <7 ; j++) {
//            if (weekStr.contains(String.valueOf(startWeek))){
//                star++;
//            }
//        }
//        nextStartDate = CountTest.addByDate(planStartDate, Calendar.DAY_OF_YEAR, 7 - startWeek + 1);
//    }
//    Date nextEndDate;
//    int end = 0;
//                if (week == 7) {
//        nextEndDate = startDate;
//    } else {
//        nextEndDate = CountTest.addByDate(startDate, Calendar.DAY_OF_YEAR, - week);
//        for (int j = 1; j < week ; j++) {
//            if (weekStr.contains(String.valueOf(week))){
//                end++;
//            }
//        }
//    }
//                if (nextEndDate.getTime() - nextStartDate.getTime() > 0) {
//        int before = CountTest.daysBefore(nextEndDate, nextStartDate);
//        System.out.println(((before + 1) / 7 * weeks.length * studyCountDay) + interval);
//    } else {
//        startClassNum = interval + planStartClassNum;
//        System.out.println(startClassNum);
//    }
}


