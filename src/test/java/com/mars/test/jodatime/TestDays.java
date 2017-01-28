package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;

/**
 * Created by yangyuchi on 28/01/2017.
 */
@Slf4j
public class TestDays {

    @Test
    public void test1(){
        log.info("test1");
        LocalDate date1 = LocalDate.parse("2017-08-31");
        log.info("date1 = " + date1);
        LocalDate date2 = LocalDate.parse("2017-01-01");
        log.info("date2 = " + date1);

        log.info("count days between day1 and day2 = " + Days.daysBetween(date1,date2).getDays());
        log.info("count days between day1 and day2 with Math.abs = " + Math.abs(Days.daysBetween(date1,date2).getDays()));


    }

}
