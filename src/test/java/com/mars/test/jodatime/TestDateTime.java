package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
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

    @Test(expected = IllegalArgumentException.class)
    public void testParse(){
        DateTime actual = DateTime.parse(source);
        log.info("actual = " + actual);
    }

    @Test
    public void testParse2(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt = formatter.parseDateTime(source);
        log.info("dt = "  + dt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseError1(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dt = formatter.parseDateTime(errorSource);
    }


}
