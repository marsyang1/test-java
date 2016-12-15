package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by USER on 2016/12/13.
 */
@Slf4j
public class TestString {

    @Test
    public void testRegexp() {
        String test1 = "123412";
        String test2 = "asdgfjsadfjla";
        String test3 = "asdgfjs2342342";
        String test4 = "asdgfjs2342342:";

        log.info("test1.match = " + test1.matches("\\w+"));
        log.info("test2.match = " + test2.matches("\\w+"));
        log.info("test3.match = " + test3.matches("\\w+"));
        log.info("test4.match = " + test4.matches("\\w+"));

        String test5 = "123";
        String test6 = "123123412";
        String test7 = "asd12";
        String test8 = "asd;[;";
        String test9 = "asdgfj_-342342";
        String test10 = "as-_";

        log.info("test5.match = " + test5.matches("\\w{2,6}"));
        log.info("test6.match = " + test6.matches("\\w{2,6}"));
        log.info("test7.match = " + test7.matches("\\w{2,6}"));
        log.info("test8.match = " + test8.matches("\\w{2,6}"));
        log.info("test9.match = " + test9.matches("\\w{2,6}"));
        log.info("test10.match = " + test10.matches("\\w{2,6}"));
        Assert.assertTrue(test5.matches("\\w{2,6}"));
        Assert.assertFalse(test6.matches("\\w{2,6}"));
        Assert.assertTrue(test7.matches("\\w{2,6}"));
        Assert.assertFalse(test8.matches("\\w{2,6}"));
        Assert.assertFalse(test10.matches("\\w{2,6}"));
    }


}
