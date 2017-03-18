package com;

import java.text.DateFormat;
import java.util.Date;

public class MessLastTime {
    private Date date;
    private DateFormat df;

    public MessLastTime(Date date, DateFormat df){
        this.date = date;
        this.df = df;
        System.out.println("In constr MessLastTime...");
    }

    public String getMessLastTime(String str){
        return date + ": " + str;
    }
}
