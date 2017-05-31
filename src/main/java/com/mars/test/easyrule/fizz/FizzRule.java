package com.mars.test.easyrule.fizz;


import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule
public class FizzRule {

    private int input;

    @Condition
    public boolean isFizz() {
        return input % 5 == 0;
    }

    @Action
    public void printFizz() {
        System.out.print("fizz");
    }

    public void setInput(int input) {
        this.input = input;
    }

    @Priority
    public int getPriority() {
        return 1;
    }
}
