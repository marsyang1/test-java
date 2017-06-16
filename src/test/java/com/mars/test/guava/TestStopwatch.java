package com.mars.test.guava;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by USER on 2017/6/16.
 */
@Slf4j
public class TestStopwatch {


    @Test
    public void test1() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(3);
        log.info("timer =" + stopwatch.toString());
    }


}
