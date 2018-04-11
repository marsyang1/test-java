package com.mars.test.design;

import com.google.common.base.Stopwatch;
import com.mars.test.java.concurrency.Counter;
import com.mars.test.java.concurrency.LockCounter;
import com.mars.test.java.concurrency.SyncCounter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * Created by yangyuchi on 23/02/2017.
 */
@Slf4j
public class LockMapCounterTest {

//    @Test
    public void addCount() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final Counter counter = new LockCounter();
        IntStream.range(0,1000000000).parallel()
                .forEach( i -> counter.addCount());
        log.info("LockCounter = " + counter.getCount());
        log.info("stopwatch = " + stopwatch);
    }

//    @Test
    public void syncCounter() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final Counter counter = new SyncCounter();
        IntStream.range(0,1000000000).parallel()
                .forEach( i -> counter.addCount());
        log.info("SyncCounter = " + counter.getCount());
        log.info("stopwatch = " + stopwatch);
    }

}