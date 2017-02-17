package com.mars.test.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.google.common.math.DoubleMath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by mars on 2016/8/31.
 */
@Slf4j
public class TestGuavaCache {

    int INTERVAL_MINUTE = 1;

    final Cache<String, Long> normalCache = CacheBuilder.newBuilder()
            .expireAfterWrite(INTERVAL_MINUTE, TimeUnit.SECONDS)
            .build();

    @Test
    public void testCache() throws ExecutionException {
        normalCache.put("pt111",System.currentTimeMillis());
        normalCache.put("mg112",System.currentTimeMillis());
        normalCache.put("qt113",System.currentTimeMillis());
        ConcurrentMap<String, Long> map = normalCache.asMap();
        for(String key : map.keySet()){
            log.info("map key = " + key +" , value = " + map.get(key));
        }
        try {
            Thread.sleep(2000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        map = normalCache.asMap();
        for(String key : map.keySet()){
            log.info("map key = " + key +" , value = " + map.get(key));
        }
        log.info("map size = " + map.size());
        log.info("map get pt111 " + normalCache.asMap().get("pt111"));
        log.info("done");
    }


    final Map<String,Long> mockDao = Maps.newConcurrentMap();
    final LoadingCache<String, Long> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .build(
                    new CacheLoader<String, Long>() {
                        @Override
                        public Long load(String key) throws Exception {
                            return mockDao.get(key);
                        }
                    });

    @Test
    public void testLoadingCache() throws ExecutionException, InterruptedException {
        long timeStamp = System.currentTimeMillis();
        mockDao.put("pt111",timeStamp);
        // update pt111 value
        Thread.sleep(500);                 //1000 milliseconds is one second.
        long newTimeStamp = System.currentTimeMillis();
        mockDao.put("pt111",newTimeStamp);
        long cachedTimeStamp = loadingCache.get("pt111");
        Thread.sleep(2000);                 //1000 milliseconds is one second.
        cachedTimeStamp = loadingCache.get("pt111");
        log.info("done");
    }


}