package com.mars.test.easyrule.fizz;


import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule
public class FizzRule {

    @Condition
    public boolean isFizz(@Fact("number") Integer number) {
        return number % 5 == 0;
    }

    @Action
    public void printFizz() {
        System.out.print("fizz");
    }

    @Priority
    public int getPriority() {
        return 1;
    }
}
