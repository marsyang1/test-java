package com.mars.test.java;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by USER on 2017/5/31.
 */
@Slf4j
public class TestGetObjectMemorySize {

    @Test
    public void test1(){
        String word1 = "!askfhj;laksjdflkakjsdlfjal";
        log.info("word1 memory size = " + ObjectSizeCalculator.getObjectSize(word1) + " bytes");
    }
}
