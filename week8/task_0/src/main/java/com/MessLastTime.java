package com;

import java.util.Date;

public class MessLastTime
{
    private Date date;

    public MessLastTime(Date date)
    {
        this.date = date;
    }

    public String getMessLastTime(String str)
    {
        return date + ": " + str + "\n";
    }
}
