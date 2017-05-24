package com.mars.test.easyrule.fizz;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule
public class BuzzRule {

    private int input;

    @Condition
    public boolean isBuzz() {
        return input % 7 == 0;
    }

    @Action
    public void printBuzz() {
        System.out.print("buzz");
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority
    public int getPriority() {
        return 2;
    }
}