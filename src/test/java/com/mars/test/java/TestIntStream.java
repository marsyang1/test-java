package com.mars.test.java;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by USER on 2017/2/18.
 */
@Slf4j
public class TestIntStream {


    @Test
    public void testRange() {
        IntStream.range(0, 99).forEach(count -> {
            Stopwatch watch = Stopwatch.createStarted();
            OptionalInt first = IntStream.range(0, 10000)
                    .filter(i -> i == 9999)
                    .findFirst();
            if (first.isPresent()) {
                log.info("i=" + first.getAsInt());
            }
            log.info("time = " + watch);
            watch.stop();
        });
    }

    @Test(expected = NoSuchElementException.class)
    public void testRange2() {
        int first = IntStream.range(0, 10000)
                .filter(i -> i == 10000)
                .findFirst().getAsInt();
        log.info("i=" + first);
    }


}
