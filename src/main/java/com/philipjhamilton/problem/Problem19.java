package com.philipjhamilton.problem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Problem19 implements Problem<Integer>{
    @Override
    public Integer solve() {

        int total = 0;

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(1901, 1, 1);

        Date start = new Date(gc.getTimeInMillis());
        System.out.println(start.toString());
        for(int i= 1901; i < 2001; i++){
            for(int m=0; m < 12; m++){
                gc.set(Calendar.MONTH, m);
                gc.set(Calendar.YEAR, i);
                gc.set(Calendar.DAY_OF_MONTH, 1);
                if(gc.get(Calendar.DAY_OF_MONTH) == 1 && gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    System.out.println(new Date(gc.getTimeInMillis()));
                    total += 1;
                }
            }
        }

        return total;
    }
}
