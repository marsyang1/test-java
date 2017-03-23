package com.mars.test.java.concurrency;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangyuchi on 22/02/2017.
 */
@Slf4j
public class SyncMultiCounter implements MultiCounter {

    @Getter
    private int count = 0;

    @Getter
    private int count2 = 0;

    public synchronized void addCount() {
        count++;
        log.info("add count1");
        log.info("enter sleep");
        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(5000);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info("add count1 end");
    }

    private Object object = new Object();
    public void addCount2() {
        log.info("add count2");
        synchronized (object) {
            count2++;
        }
        log.info("add count2 end");
    }

}
