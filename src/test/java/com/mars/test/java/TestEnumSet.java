package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.EnumSet;

@Slf4j
public class TestEnumSet {


    enum Gfg {
        CODE, LEARN, CONTRIBUTE, QUIZ, MCQ
    }

    @Test
    public void test1() {
        // create a set
        EnumSet<Gfg> set1, set2, set3, set4;
        // add elements
        set1 = EnumSet.of(Gfg.QUIZ, Gfg.CONTRIBUTE, Gfg.LEARN, Gfg.CODE);
        set2 = EnumSet.complementOf(set1);
        set3 = EnumSet.allOf(Gfg.class);
        set4 = EnumSet.range(Gfg.CODE, Gfg.CONTRIBUTE);
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);
        System.out.println("Set 4: " + set4);
    }


}
