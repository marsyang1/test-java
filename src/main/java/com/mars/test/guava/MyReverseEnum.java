package com.mars.test.guava;

import com.google.common.collect.Maps;
import com.sun.istack.internal.Nullable;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by USER on 2017/1/13.
 */
public enum MyReverseEnum {
    A(0), B(1), C(2);
    private static final Map<Integer, MyReverseEnum> LOOKUP = Maps.uniqueIndex(
            Arrays.asList(MyReverseEnum.values()),
            MyReverseEnum::getStatus
    );

    private final int status;

    MyReverseEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    @Nullable
    public static MyReverseEnum fromStatus(int status) {
        return LOOKUP.get(status);
    }
}
