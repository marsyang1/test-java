package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


/**
 * Created by USER on 2017/1/20.
 */
@Slf4j
public class TestLockObject {

    @Test
    public void test1() {
        final SafeLock.Friend alphonse =
                new SafeLock.Friend("Alphonse");
        final SafeLock.Friend gaston =
                new SafeLock.Friend("Gaston");
        new Thread(new SafeLock.BowLoop(alphonse, gaston)).start();
        new Thread(new SafeLock.BowLoop(gaston, alphonse)).start();
    }

}
