package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 2017/8/24.
 */
@Slf4j
public class TestRegexp {


    @Test
    public void testFindDigit() {
        String s = "距离你的生日还有356天!";
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            log.info("match = " + matcher.group());
        }
    }

}
