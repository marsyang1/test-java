package com.mars.test.jodatime;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by USER on 2017/6/28.
 */
@Slf4j
public class DateTimeFormaterTest {


    public void test1(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    }


}
