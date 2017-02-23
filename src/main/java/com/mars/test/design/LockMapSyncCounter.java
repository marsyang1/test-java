package com.mars.test.design;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created by yangyuchi on 22/02/2017.
 */
@Slf4j
public class LockMapSyncCounter {

    private static final Map<String , Object> LOCK_MAP = Maps.newLinkedHashMap();

    @Getter
    private int count=0;

    public synchronized void addCount(String key){
        Object keyObject = LOCK_MAP.get(key);
        if(keyObject == null){
            LOCK_MAP.put(key,key);
            keyObject = key;
        }
//        return keyObject;
        count++;
    }

    private synchronized Object getKeyObject(String key){
        Object keyObject = LOCK_MAP.get(key);
        if(keyObject == null){
            LOCK_MAP.put(key,key);
            keyObject = key;
        }
        return keyObject;
    }

}
