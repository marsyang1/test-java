package com.mars.test.java;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Created by USER on 2017/2/21.
 */
@Slf4j
public class TestConcurrent {

    private static final LoadingCache<String, ReentrantLock> LockMap = CacheBuilder.newBuilder()
            .build(
                    new CacheLoader<String, ReentrantLock>() {
                        @Override
                        public ReentrantLock load(String key) throws Exception {
                            return new ReentrantLock();
                        }
                    });

    int count = 0;

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        List<Callable<String>> task = Lists.newArrayList();
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());
        task.add(getTask());

        executor.invokeAny(task);
        log.info("waiting task");
        sleep(3000);
        log.info("shutdown ");
        executor.shutdown();
        log.info("count =" + count);
    }

    public Callable<String> getTask() {
        return new Callable<String>() {
            ReentrantLock lock = null;

            @Override
            public String call() throws Exception {
                try {
                    lock = LockMap.get("aaa");
                    log.info("Locked: " + lock.isLocked());
                    log.info("Held by me: " + lock.isHeldByCurrentThread());
                    boolean acquired = lock.tryLock(100, TimeUnit.MINUTES);
                    log.info("Lock acquired: " + acquired);
                    count++;
                } catch (InterruptedException e) {
                    //可能发生要上锁时被锁了
                    log.error("Locked: " + lock.isLocked());
                    log.error("Held by me: " + lock.isHeldByCurrentThread());
                    log.info("Lock again !!!");
                    boolean acquired = lock.tryLock(100, TimeUnit.MINUTES);
                    log.info("Lock acquired: " + acquired);
                    count++;
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                    log.info("unlock success");
                }
                return null;
            }
        };
    }


}
