package com.mars.test.design;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangyuchi on 22/02/2017.
 */
@Slf4j
public class SyncCounter implements Counter{

    @Getter
    private int count=0;

    public synchronized void addCount(){
        count++;
    }

}
