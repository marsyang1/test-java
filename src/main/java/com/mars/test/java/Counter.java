package com.mars.test.java;

/**
 * Created by USER on 2017/2/18.
 */
public class Counter {

    private int count = 0;

    public void increment() {
        count = count + 1;
    }

    public synchronized void incrementSync() {
        count = count + 1;
    }

    public int getCount() {
        return count;
    }
}
