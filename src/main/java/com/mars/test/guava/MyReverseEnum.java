package com.mars.test.guava;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by USER on 2017/1/13.
 * http://stackoverflow.com/questions/5316311/java-enum-reverse-look-up-best-practice
 * http://www.leveluplunch.com/java/examples/guava-maps-utility-example/
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

    public static MyReverseEnum fromStatus(int status) {
        return LOOKUP.get(status);
    }


}
