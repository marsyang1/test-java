package com.mars.test.java;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.concurrent.*;

@Slf4j
public class TestSchedulerExecutor {

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        try {
            Callable callable = () -> {
                System.out.println("Executed!");
                return "Called!";
            };
            Stopwatch stopwatch = Stopwatch.createStarted();
            log.info("submit callable task :" + stopwatch);
            ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(callable, 5, TimeUnit.SECONDS);
            log.info("scheduledFuture:" + scheduledFuture.get() + ",time:" + stopwatch.stop());
        } finally {
            scheduledExecutorService.shutdown();
        }
    }


    @Test
    public void test2() throws ExecutionException, InterruptedException {
        try {
            Runnable task = () -> log.info("Hello , time is :" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
            Stopwatch stopwatch = Stopwatch.createStarted();
            log.info("submit callable task :" + stopwatch);
            scheduledExecutorService.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);

            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
            }
        } finally {
            scheduledExecutorService.shutdown();
        }

    }


}
