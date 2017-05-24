package com.mars.test.easyrule.fizz;

import lombok.extern.slf4j.Slf4j;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.junit.Test;

/**
 * Created by USER on 2017/5/24.
 */
@Slf4j
public class FizzRuleTest {

    @Test
    public void test() throws Exception {
        // create rules engine
        RulesEngine fizzBuzzEngine =
                RulesEngineBuilder.aNewRulesEngine()
                        .withSkipOnFirstAppliedRule(true)
                        .withSilentMode(true)
                        .build();

        // create rules
        FizzRule fizzRule = new FizzRule();
        BuzzRule buzzRule = new BuzzRule();
        FizzBuzzRule fizzBuzzRule
                = new FizzBuzzRule(fizzRule, buzzRule);
        NonFizzBuzzRule nonFizzBuzzRule = new NonFizzBuzzRule();

        // register rules
        fizzBuzzEngine.registerRule(fizzRule);
        fizzBuzzEngine.registerRule(buzzRule);
        fizzBuzzEngine.registerRule(fizzBuzzRule);
        fizzBuzzEngine.registerRule(nonFizzBuzzRule);

        // fire rules
        for (int i = 1; i <= 100; i++) {
            fizzRule.setInput(i);
            buzzRule.setInput(i);
            nonFizzBuzzRule.setInput(i);
            fizzBuzzEngine.fireRules();
            System.out.println();
        }

    }

}