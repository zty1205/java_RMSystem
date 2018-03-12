package com.view.Calendar;

/**
 * Created by zty on 2017/12/26.
 */
public class isLeapYear {
    public boolean isLeapYear(int year)
    {
        if(year%4==0&&year%100!=0||year%400==0)
            return true;
        else
            return false;
    }
}

