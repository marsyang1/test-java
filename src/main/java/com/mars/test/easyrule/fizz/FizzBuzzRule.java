package com.mars.test.easyrule.fizz;

import org.jeasy.rules.core.CompositeRule;

/**
 * Created by USER on 2017/5/24.
 */
public class FizzBuzzRule extends CompositeRule {

    public FizzBuzzRule(Object... rules) {
        for (Object rule : rules) {
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
