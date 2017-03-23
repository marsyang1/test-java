package com.mars.test.java.concurrency;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by yangyuchi on 23/02/2017.
 */
@Slf4j
public class SyncMultiCounterTest {

    @Test
    public void addCount() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        final MultiCounter counter = new SyncMultiCounter();
        IntStream.range(0,100).parallel()
                .forEach( i -> {
                    if(i % 2 == 1){
                        counter.addCount();
                    }else{
                        counter.addCount2();
                    }
                });
        log.info("counter = " + counter.getCount());
        log.info("counter2 = " + counter.getCount2());
        log.info("stopwatch = " + stopwatch);
    }

}