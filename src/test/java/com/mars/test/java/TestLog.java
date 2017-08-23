package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by USER on 2017/8/23.
 */
@Slf4j
public class TestLog {

    @Test
    public void testGetCurrentMethod(){
        log.info(" 进入执行 " + (Thread.currentThread().getStackTrace().length > 0 ? Thread.currentThread().getStackTrace()[1].getMethodName() : this.getClass().getName()) + " method");
    }
}
