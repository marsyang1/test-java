package com.mars.test.java.concurrency;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * Created by yangyuchi on 23/02/2017.
 */
@Slf4j
public class SyncCounterTest {

//    @Test
    public void addCount() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final Counter counter = new SyncCounter();
        IntStream.range(0,100000).parallel()
                .forEach( i -> counter.addCount());
        log.info("counter = " + counter.getCount());
        log.info("stopwatch = " + stopwatch);
    }

}