package com.view.Calendar;

/**
 * Created by zty on 2017/12/26.
 */
import java.util.*;
public class Dates {
    String year;
    String month;
    String day;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    String week;
    public Dates()
    {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        year=String.valueOf(calendar.get(Calendar.YEAR));
        month=String.valueOf(calendar.get(Calendar.MONTH)+1);
        day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        week=String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1);
    }
}
