package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * Created by USER on 2017/1/22.
 */
@Slf4j
public class TestDateTime {

    final String source = "1982-08-30 00:00:00";
    final String errorSource = "19821238y749812";
    static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    @Test(expected = IllegalArgumentException.class)
    public void testParse(){
        DateTime actual = DateTime.parse(source);
        log.info("actual = " + actual);
    }

    @Test
    public void testParse2(){
        final String source = "2017-10-07 00:00:00";
        DateTime dt = formatter.parseDateTime(source);
        log.info("dt = "  + dt+",zone="+dt.getZone());
        dt = dt.withZone(DateTimeZone.UTC);
        log.info("dt = "  + dt+",zone="+dt.getZone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseError1(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt = formatter.parseDateTime(errorSource);
    }


}
