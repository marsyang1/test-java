package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by USER on 2017/3/27.
 */
@Slf4j
public class TestLong {

    @Test
    public void test1(){
        log.info("Max Long =" + Long.MIN_VALUE);
        log.info("Max Long length =" + String.valueOf(Long.MIN_VALUE).length());
    }

}
