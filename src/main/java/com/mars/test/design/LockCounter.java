package com.mars.test.design;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyuchi on 22/02/2017.
 */
@Slf4j
public class LockCounter implements Counter{

    private static final LoadingCache<String, ReentrantLock> LockMap = CacheBuilder.newBuilder()
            .build(
                    new CacheLoader<String, ReentrantLock>() {
                        @Override
                        public ReentrantLock load(String key) throws Exception {
                            return new ReentrantLock();
                        }
                    });

    @Getter
    private int count = 0;

    public void addCount() {
        ReentrantLock lock = null;
        for (int i = 0; i < 10; i++) {
            try {
                lock = LockMap.get("");
                lock.tryLock(10, TimeUnit.SECONDS);
                count++;
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


}
