package com.mars.test.guava;

import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yangyuchi on 28/01/2017.
 */
@Slf4j
public class TestSplitter {

    @Test
    public void test1(){
        String expect = "mars";
        String text1 = "name_mars";
        String actual = Splitter.on("_").splitToList(text1).get(1);
        log.info("split name = " + actual);
        Assert.assertEquals(expect,actual);
        String text2 = "mars";
        actual = Splitter.on("_").splitToList(text2).get(0);
        Assert.assertEquals(expect,actual);
    }


}
