package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by USER on 2016/12/1.
 */
@Slf4j
public class TestJava {


    @Test
    public void test1(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        log.info("generatedString"+generatedString);
    }

    private SecureRandom random = new SecureRandom();

    @Test
    public void test2(){
        String rndString = new BigInteger(130, random).toString(32);
        String newString = rndString.substring(0,16);
        log.info("random String = "+ rndString);
        log.info("random String length = "+ rndString.length());

        log.info("random newString = "+ newString);
        log.info("random newString length = "+ newString.length());
    }

    @Test
    public void test3(){
        int length = 16;
        Random rng = new Random();
        char[] str = new char[length];
        for(int i = 0; i < length; i ++)
            str[i] = (char) ('0' + rng.nextInt(10));
        log.info("String = " + new String(str));
    }

    @Test
    public void test4(){
        for(int i=0;i<20;i++){
            String str = RandomStringUtils.randomAlphanumeric(16);
            log.info("String = " + str);
        }
    }
}
