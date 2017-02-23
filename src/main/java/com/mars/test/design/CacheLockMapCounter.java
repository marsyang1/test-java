package com.mars.test.design;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mars.test.java.concurrency.Counter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuchi on 22/02/2017.
 */
@Slf4j
public class CacheLockMapCounter implements LockMapCounter {

    private static final LoadingCache<String, ReentrantLock> LockMap = CacheBuilder.newBuilder()
            .build(
                    new CacheLoader<String, ReentrantLock>() {
                        @Override
                        public ReentrantLock load(String key) throws Exception {
                            return new ReentrantLock();
                        }
                    });

    private AtomicInteger count = new AtomicInteger();

    public void addCount(String key) {
        ReentrantLock lock = null;
        for (int i = 0; i < 10; i++) {
            try {
                lock = LockMap.get(key);
                lock.tryLock(10, TimeUnit.SECONDS);
                count.addAndGet(1);
                return;
            } catch (InterruptedException e) {
                continue;
            } catch (ExecutionException e) {
                e.printStackTrace();
                continue;
            }finally {
                if(lock != null){
                    lock.unlock();
                }
            }
        }
    }

    @Override
    public int getCount() {
        return count.get();
    }


}
