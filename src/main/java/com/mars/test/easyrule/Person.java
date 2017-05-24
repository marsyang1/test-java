package com.mars.test.easyrule;

import lombok.Data;

/**
 * Created by USER on 2017/5/24.
 */
@Data
public class Person {

    private String name;
    private int age;
    private boolean adult;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //getters and setters omitted

}
