package com.mars.test.java8;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuchi on 10/13/16.
 */
@Slf4j
public class TestCollection {


    @Test
    public void test1() throws Exception {
        List<Integer> a = Lists.newArrayList(1, 2, 3);
        List<Integer> b = Lists.newArrayList(4);
        List<Integer> c = Lists.newArrayList(2);
        List<Integer> d = Lists.newArrayList(0,2);
        log.info("Collections.disjoint(a, b) = " + Collections.disjoint(a, b));
        log.info("Collections.disjoint(a, c) = " + Collections.disjoint(a, c));
        log.info("Collections.disjoint(a, d) = " + Collections.disjoint(a, d));
    }

    @Test
    public void test2() throws Exception {
        final String email = "test1234124@mgial.com";
        final String name = "个人中心";
        log.info("email length =  "  + email.length());
        String markedEmail = markString(email,3);
        log.info("markedEmail = " + markedEmail);

        log.info("name length =  "  + name.length());
        String markedName = markString(name,1);
        log.info("markedName = " + markedName);
    }

    private String markString(final String source,int displayLength){
        String displayString = source.substring(0,displayLength);
        String footer = source.replaceAll("(?s).", "*").substring(displayLength);
        log.info("footer length =  " + footer.length());
        return displayString+footer;
    }

}
