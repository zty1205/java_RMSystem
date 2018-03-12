package com.view.Calendar;

/**
 * Created by zty on 2017/12/26.
 */
import com.view.Calendar.isLeapYear;

import java.util.*;

public class NowDate {

    Calendar nowDate=Calendar.getInstance();
    int day,month,year,dayofweek,februaryDays,hour,minute,second;
    isLeapYear leapYear=new isLeapYear();
    String monthDays[];
    public NowDate()
    {
        month=nowDate.get(Calendar.MONTH)+1;
        year=nowDate.get(Calendar.YEAR);
        day=nowDate.get(Calendar.DAY_OF_MONTH);
        hour=nowDate.get(Calendar.HOUR_OF_DAY);
        minute=nowDate.get(Calendar.MINUTE);
        second=nowDate.get(Calendar.SECOND);
        nowDate.set(year,month-1,1);
        dayofweek=nowDate.get(Calendar.DAY_OF_WEEK)-1;
    }
    public String[] getMonthDays()
    {
        if(leapYear.isLeapYear(year))
            februaryDays=28;
        else
            februaryDays=29;
        if(month==2)
            monthDays=new String[28+dayofweek];
        else if(month==4||month==6||month==9||month==11)
            monthDays=new String[30+dayofweek];
        else
            monthDays=new String[31+dayofweek];
        for(int i=0;i<dayofweek;i++)
            monthDays[i]="**"; //原本是**

        for(int i=dayofweek,n=1;i<monthDays.length;i++)
        {
            if(i<=9)
                monthDays[i]=" "+String.valueOf(n);
            else
                monthDays[i]=String.valueOf(n);
            n++;
        }
        return monthDays;
    }
    public int getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }
    public int getDay()
    {
        return day;
    }
    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }
    public int getSecond()
    {
        return second;
    }
}

