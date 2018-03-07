package com.mars.test.apache;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

@Slf4j
public class TestRandomString {

    @Test
    public void testRandom(){
        log.info("RandomStringUtils.random(20):"+ RandomStringUtils.random(20));
        log.info("RandomStringUtils.randomAlphabetic(20):"+ RandomStringUtils.randomAlphabetic(20));
        log.info("RandomStringUtils.randomAlphanumeric(20):"+ RandomStringUtils.randomAlphanumeric(20));
        log.info("RandomStringUtils.randomAscii(20):"+ RandomStringUtils.randomAscii(20));
        log.info("RandomStringUtils.randomNumeric(20):"+ RandomStringUtils.randomNumeric(20));
    }
}
