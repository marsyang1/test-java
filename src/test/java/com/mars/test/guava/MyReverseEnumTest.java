package com.mars.test.guava;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by USER on 2017/1/13.
 */
@Slf4j
public class MyReverseEnumTest {

    @Test
    public void getStatus() throws Exception {
        MyReverseEnum myReverseEnum = MyReverseEnum.fromStatus(1);
        Assert.assertEquals(myReverseEnum,MyReverseEnum.B);
        myReverseEnum = MyReverseEnum.fromStatus(2);
        Assert.assertEquals(myReverseEnum,MyReverseEnum.C);
        myReverseEnum = MyReverseEnum.fromStatus(0);
        Assert.assertEquals(myReverseEnum,MyReverseEnum.A);
    }

}