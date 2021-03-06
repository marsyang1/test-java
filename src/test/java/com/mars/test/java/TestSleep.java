package com.mars.test.java;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 2017/6/16.
 */
@Slf4j
public class TestSleep {

    @Test
    public void tesSleep() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(3);
        log.info("timer =" + stopwatch.toString());
    }

    @Test
    public void testSleep2() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(3 * 1000);
        log.info("timer =" + stopwatch.toString());
    }

    @Test
    public void tempTest(){
        String text = "COUPON_SELF_PT_FIRST";
        String[] strings = text.split("_");
        log.info(" text = " + strings[2]);
    }

}
