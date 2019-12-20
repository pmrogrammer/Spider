package com.pansoft.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromatUtil {
    public final static String fromat = "yyyy-MM-dd HH:mm:ss";
    public static SimpleDateFormat dateFormat = new SimpleDateFormat(fromat);
    public static Date converStringToDate(String date) {
            try {
                return dateFormat.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException();
            }
    }
    public static String getCurrentDate() {
        return dateFormat.format(new Date());
    }
}
