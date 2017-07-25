package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by USER on 2017/7/13.
 */
@Slf4j
public class TestCalendar {

    @Test
    public void testGregorianCalendar(){
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        Calendar currentDateTwo = new GregorianCalendar();
        currentDateTwo.set(Calendar.HOUR_OF_DAY, 23);
        currentDateTwo.set(Calendar.MINUTE, 59);
        currentDateTwo.set(Calendar.SECOND, 59);
        log.info("currentDate = " + currentDate.getTime() + "zone = " + currentDate.getTimeZone());
        log.info("currentDate = " + currentDateTwo.getTime() + "zone = " + currentDateTwo.getTimeZone());
    }


}
