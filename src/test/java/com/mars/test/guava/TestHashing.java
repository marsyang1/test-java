package com.mars.test.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by USER on 2016/12/22.
 */
@Slf4j
public class TestHashing {

    @Test
    public void test1(){
        final String content = "1234";
        String hashingText = Hashing.md5().hashString(content, Charsets.UTF_8).toString();
        log.info("hashing Text = " + hashingText);
        Assert.assertEquals("81dc9bdb52d04dc20036dbd8313ed055",hashingText);
    }

}
