package com.mars.test.design;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuchi on 22/02/2017.
 */
@Slf4j
public class LockCounter implements Counter{

    final ReentrantLock lock = new ReentrantLock();

    @Getter
    private int count = 0;

    public void addCount() {
        for (int i = 0; i < 10; i++) {
            try {
                lock.tryLock(10, TimeUnit.SECONDS);
                count++;
                return;
            } catch (InterruptedException e) {
                continue;
            } finally {
                lock.unlock();
            }
        }
    }


}
