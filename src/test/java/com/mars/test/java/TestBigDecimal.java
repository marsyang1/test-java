package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by USER on 2017/3/6.
 */
@Slf4j
public class TestBigDecimal {


    @Test
    public void test1(){
        BigDecimal decimal = BigDecimal.valueOf(8999990752.57);
        log.info("decimal = " + decimal);
    }


}
