package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Date;

/**
 * Created by mars on 2016/8/31.
 */
@Slf4j
public class TestJodaTime {


    @Test
    public void test1() {
        DateTime time = new DateTime().withTimeAtStartOfDay();
        DateTime testDate = new DateTime().withTimeAtStartOfDay();
        log.info(" testDate.isAfter(time) = " + testDate.isAfter(time));
        log.info("System.currentTimeMillis() = " + System.currentTimeMillis());


        LocalDateTime tokenNow = LocalDateTime.fromDateFields(new Date());
        LocalDateTime tokenBefore = LocalDateTime.fromDateFields(new Date()).minusDays(1);
        LocalDateTime tokenBefore5 = LocalDateTime.fromDateFields(new Date()).minusDays(6);
        LocalDateTime limit = LocalDateTime.fromDateFields(new Date()).minusDays(5);

        log.info(" tokenNow.isVaild = " + tokenNow.isBefore(limit));
        log.info(" tokenBefore.isVaild = " + tokenBefore.isBefore(limit));
        log.info(" tokenBefore5.isVaild = " + tokenBefore5.isBefore(limit));


        DateTime start = DateTime.now().withTimeAtStartOfDay().plusHours(0);
        DateTime end = DateTime.now().withTimeAtStartOfDay().plusHours(1);

        Interval interval = new Interval(start, end);
        log.info(interval.toString());
        log.info("interval.contains(start)" + interval.contains(start));
        log.info("interval.contains(start+1)" + interval.contains(start.plusSeconds(1)));
        log.info("interval.contains(start-1)" + interval.contains(start.minusSeconds(1)));
        log.info("interval.contains(end)" + interval.contains(end));
        log.info("interval.contains(end+1)" + interval.contains(end.plusSeconds(1)));
        log.info("interval.contains(end-1)" + interval.contains(end.minusSeconds(1)));
        Hours hours = Hours.hoursBetween(start, end);
        log.info("Hours = " + hours);
    }

    @Test
    public void testDateFormat() {
        try {
            String inputDate = "2012-03-0822 23:59:59";
            DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            DateTime dt = formatter.parseDateTime(inputDate);
            log.info("Test Date format = " + dt);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            log.error("Illegal Data Argument");
        }
    }

    @Test
    public void testIsXimaOpen() {
        final String toStringPattern = "yyyy-MM-dd HH:mm:ss";
        int disableStartHour = 23;
        int disableEndHour = 1;
        DateTime sourceDate = new DateTime().withTimeAtStartOfDay().minusHours(1);
        DateTime sourceDate1 = sourceDate.minusSeconds(1);
        DateTime sourceDate2 = sourceDate.plusHours(2).minusMinutes(30);
        DateTime sourceDate3 = sourceDate.plusHours(2).minusSeconds(1);
        DateTime sourceDate4 = sourceDate.plusHours(2);
        DateTime sourceDate5 = sourceDate.plusHours(2).plusSeconds(1);
        log.info("isXimaOpen at " + sourceDate1.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate1));
        log.info("isXimaOpen at " + sourceDate.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate));
        log.info("isXimaOpen at " + sourceDate2.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate2));
        log.info("isXimaOpen at " + sourceDate3.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate3));
        log.info("isXimaOpen at " + sourceDate4.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate4));
        log.info("isXimaOpen at " + sourceDate5.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate5));

        log.info("===========================================================");

        disableStartHour = 0;
        disableEndHour = 3;
        sourceDate = new DateTime().withTimeAtStartOfDay();
        sourceDate1 = sourceDate.minusSeconds(1);
        sourceDate2 = sourceDate.plusHours(3).minusMinutes(30);
        sourceDate3 = sourceDate.plusHours(3).minusSeconds(1);
        sourceDate4 = sourceDate.plusHours(3);
        sourceDate5 = sourceDate.plusHours(3).plusSeconds(1);
        log.info("isXimaOpen at " + sourceDate1.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate1));
        log.info("isXimaOpen at " + sourceDate.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate));
        log.info("isXimaOpen at " + sourceDate2.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate2));
        log.info("isXimaOpen at " + sourceDate3.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate3));
        log.info("isXimaOpen at " + sourceDate4.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate4));
        log.info("isXimaOpen at " + sourceDate5.toString(toStringPattern) + " = " + isXimaOpen(disableStartHour, disableEndHour, sourceDate5));
    }


    private boolean isXimaOpen(int disableStartHour, int disableEndHour) {
        DateTime start = DateTime.now().withTimeAtStartOfDay().plusHours(disableStartHour);
        DateTime end = DateTime.now().withTimeAtStartOfDay().plusHours(disableEndHour);
        Interval interval = new Interval(start, end);
        return !interval.containsNow();
    }

    private boolean isXimaOpen(int disableStartHour, int disableEndHour, DateTime sourceDate) {
        DateTime start;
        if (disableStartHour > disableEndHour) {
            start = DateTime.now().withTimeAtStartOfDay().minusHours(24 - disableStartHour);
        } else {
            start = DateTime.now().withTimeAtStartOfDay().minusHours(disableStartHour);
        }
        DateTime end = DateTime.now().withTimeAtStartOfDay().plusHours(disableEndHour);
        Interval interval = new Interval(start, end);
        return !interval.contains(sourceDate);
    }


}
