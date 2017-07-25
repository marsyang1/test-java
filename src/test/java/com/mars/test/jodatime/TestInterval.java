package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by USER on 2016/12/8.
 */
@Slf4j
public class TestInterval {

    final String TIME_PATTERN="yyyy-MM-dd HH:mm:ss";

    @Test
    public void test1(){
        DateTime rangestart = DateTime.parse("2016-08-01");
        DateTime rangeend = DateTime.parse("2016-08-30");
        Interval interval = new Interval(rangestart,rangeend);

        DateTime rangeAstart = DateTime.parse("2016-07-01");
        DateTime rangeAend = DateTime.parse("2016-07-30");
        Interval intervalA = new Interval(rangeAstart,rangeAend);

        DateTime rangeBstart = DateTime.parse("2016-07-30");
        DateTime rangeBend = DateTime.parse("2016-08-02");
        Interval intervalB = new Interval(rangeBstart,rangeBend);

        DateTime rangeCstart = DateTime.parse("2016-08-15");
        DateTime rangeCend = DateTime.parse("2016-08-16");
        Interval intervalC = new Interval(rangeCstart,rangeCend);

        DateTime rangeDstart = DateTime.parse("2016-08-25");
        DateTime rangeDend = DateTime.parse("2016-09-05");
        Interval intervalD = new Interval(rangeDstart,rangeDend);

        DateTime rangeEstart = DateTime.parse("2016-09-01");
        DateTime rangeEend = DateTime.parse("2016-09-30");
        Interval intervalE = new Interval(rangeEstart,rangeEend);

        DateTime rangeFstart = DateTime.parse("2016-07-01");
        DateTime rangeFend = DateTime.parse("2016-08-01");
        Interval intervalF = new Interval(rangeFstart,rangeFend);

        DateTime rangeGstart = DateTime.parse("2016-08-30");
        DateTime rangeGend = DateTime.parse("2016-09-30");
        Interval intervalG = new Interval(rangeGstart,rangeGend);

        log.info("interval = " + interval);
        log.info("interval A = " + intervalA);
        log.info("interval B = " + intervalB);
        log.info("interval C = " + intervalC);
        log.info("interval D = " + intervalD);
        log.info("interval E = " + intervalE);
        log.info("interval F = " + intervalF);
        log.info("interval G = " + intervalG);
        log.info("----------------------------------------------------------------");
        log.info("interval.abuts(intervalA) = " + interval.abuts(intervalA));
        log.info("interval.abuts(intervalB) = " + interval.abuts(intervalB));
        log.info("interval.abuts(intervalC) = " + interval.abuts(intervalC));
        log.info("interval.abuts(intervalD) = " + interval.abuts(intervalD));
        log.info("interval.abuts(intervalE) = " + interval.abuts(intervalE));
        log.info("interval.abuts(intervalF) = " + interval.abuts(intervalF));
        log.info("interval.abuts(intervalG) = " + interval.abuts(intervalG));
        Assert.assertTrue(interval.abuts(intervalF));
        Assert.assertTrue(interval.abuts(intervalG));
        log.info("----------------------------------------------------------------");
        log.info("interval.contains(intervalA) = " + interval.contains(intervalA));
        log.info("interval.contains(intervalB) = " + interval.contains(intervalB));
        log.info("interval.contains(intervalC) = " + interval.contains(intervalC));
        log.info("interval.contains(intervalD) = " + interval.contains(intervalD));
        log.info("interval.contains(intervalE) = " + interval.contains(intervalE));
        log.info("interval.contains(intervalF) = " + interval.contains(intervalF));
        log.info("interval.contains(intervalG) = " + interval.contains(intervalG));
        Assert.assertTrue(interval.contains(intervalC));
        log.info("----------------------------------------------------------------");
        log.info("interval.overlaps(intervalA) = " + interval.overlaps(intervalA));
        log.info("interval.overlaps(intervalB) = " + interval.overlaps(intervalB));
        log.info("interval.overlaps(intervalC) = " + interval.overlaps(intervalC));
        log.info("interval.overlaps(intervalD) = " + interval.overlaps(intervalD));
        log.info("interval.overlaps(intervalE) = " + interval.overlaps(intervalE));
        log.info("interval.overlaps(intervalF) = " + interval.overlaps(intervalF));
        log.info("interval.overlaps(intervalG) = " + interval.overlaps(intervalG));
        Assert.assertTrue(interval.overlaps(intervalB));
        Assert.assertTrue(interval.overlaps(intervalC));
        Assert.assertTrue(interval.overlaps(intervalD));

    }


    @Test
    public void testDateTimeInterval(){
        DateTime rangestart = DateTime.now().withTimeAtStartOfDay().minusHours(1);
        DateTime rangeend = DateTime.now().withTimeAtStartOfDay().plusHours(1);
        Interval interval = new Interval(rangestart,rangeend);
        log.info("rangestart = " + rangestart.toString(TIME_PATTERN));
        log.info("rangeend = " + rangeend.toString(TIME_PATTERN));
        log.info("interval = " + interval);

        log.info("interval.contains( now() ) = "+interval.contains(DateTime.now()));
        log.info("interval.contains( startOfDay() ) = "+interval.contains(DateTime.now().withTimeAtStartOfDay()));
    }

    @Test
    public void testDateTimeIntervalUTC(){
        DateTime rangestart = DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay().withZone(DateTimeZone.getDefault()).minusHours(1);
        DateTime rangeend = DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay().withZone(DateTimeZone.getDefault()).plusHours(1);
        Interval interval = new Interval(rangestart,rangeend);
        log.info("rangestart = " + rangestart.toString(TIME_PATTERN));
        log.info("rangeend = " + rangeend.toString(TIME_PATTERN));
        log.info("interval = " + interval);
        log.info("interval.contains( now() ) = "+interval.contains(DateTime.now()));
        log.info("interval.contains( startOfDay() ) = "+interval.contains(DateTime.now().withTimeAtStartOfDay()));
    }
}
