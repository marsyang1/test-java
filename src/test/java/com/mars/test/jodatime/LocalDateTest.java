package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Date;

/**
 * Created by mars on 2016/5/31.
 */
@Slf4j
public class LocalDateTest {


    @Test
    public void test1() {
        LocalDate date1 = LocalDate.parse("2014-01-03");
        log.info("date1 =  " + date1);
        date1 = LocalDateTime.parse("2014-01-03 00:10:10").toLocalDate();
        log.info("date1 =  " + date1);
    }

}
