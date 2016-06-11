package com.rong.flora.coupon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rongwf1 on 2016/6/11.
 */
public class DateUtil {

    public static Date getDateFromString(String dateStr, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
