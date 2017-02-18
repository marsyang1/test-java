package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by USER on 2017/2/18.
 * Reference : http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
 */
@Slf4j
public class CounterTest {

    @Test
    public void increment() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Counter counter  = new Counter();
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(() -> counter.increment()));

        executor.shutdown();
        log.info("count =" + counter.getCount());
    }

    @Test
    public void incrementSync() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Counter counter  = new Counter();
        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(() -> counter.incrementSync()));

        executor.shutdown();
        log.info("count =" + counter.getCount());
    }

}