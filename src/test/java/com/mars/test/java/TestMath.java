package com.mars.test.java;


import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestMath {


    static final int startNum = 1000000000;


    @Test
    public void test1() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long f1 = f1(startNum);
        log.info("stopwatch = " + stopwatch + ",f1=" + f1);
    }

    public static long f1(int n) {
        if (n <= 1) return n;
        return f1(n - 1) + f1(n - 2);
    }


    @Test
    public void test2() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        long f2 = f2(startNum);
        log.info("stopwatch = " + stopwatch + ", f2=" + f2);
    }

    public static long f2(int n) {
        long n0 = 0, n1 = 1;
        for (int i = 0; i < n; i++) {
            long temp = n1;
            n1 = n1 + n0;
            n0 = temp;
        }
        return n0;
    }


    @Test
    public void test3() {
        Stopwatch stopwatch = Stopwatch.createStarted();


        log.info("stopwatch = " + stopwatch);
    }

}
