package com.mars.test.easyrule.fizz;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Priority;
import org.easyrules.annotation.Rule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule
public class NonFizzBuzzRule {

    private int input;

    @Condition
    public boolean isNotFizzNorBuzz() {
        // can return true here
        return input % 5 != 0 || input % 7 != 0;
    }

    @Action
    public void printInput() {
        System.out.print(input);
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority
    public int getPriority() {
        return 3;
    }
}