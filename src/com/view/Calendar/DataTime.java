package com.view.Calendar;

/**
 * Created by zty on 2017/12/26.
 */

import java.util.*;
public class DataTime {

    Calendar date=Calendar.getInstance();
    isLeapYear leapYear=new isLeapYear();
    int year,month,dayofweek,februaryDays;
    String monthDays[];
    public DataTime(int year,int month)
    {
        this.year=year;
        this.month=month;
        date.set(year,month-1,1);
        dayofweek=date.get(Calendar.DAY_OF_WEEK)-1;
        if(leapYear.isLeapYear(year))
            februaryDays=28;
        else
            februaryDays=29;
    }
    public String[] getMonthDays()
    {
        if(month==2)
            monthDays=new String[dayofweek+februaryDays];
        else if(month==4||month==6||month==9||month==11)
            monthDays=new String[dayofweek+30];
        else
            monthDays=new String[dayofweek+31];

        for(int i=0;i<dayofweek;i++)
            monthDays[i]="##"; // 原本是**
        for(int i=dayofweek,n=1;i<monthDays.length;i++)
        {
            if(n<=9)
                monthDays[i]=" "+String.valueOf(n);
            else
                monthDays[i]=String.valueOf(n);
            n++;
        }
        return monthDays;
    }
}

