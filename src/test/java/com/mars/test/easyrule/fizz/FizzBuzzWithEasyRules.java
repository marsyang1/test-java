package com.mars.test.easyrule.fizz;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by USER on 2017/5/31.
 */
@Slf4j
public class FizzBuzzWithEasyRules {

    @Test
    public void test1(){
        RulesEngine fizzBuzzEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build();

        // create rules
        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new FizzBuzzRule(new FizzRule(), new BuzzRule()));
        rules.register(new NonFizzBuzzRule());

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }

    @Test
    public void test2(){
        RulesEngine fizzBuzzEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build();

        // create rules
        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new FizzBuzzRule(new FizzRule(), new BuzzRule()));
        rules.register(new NonFizzBuzzRule());

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 21; i++) {
            facts.put("number", i);
            Map<Rule, Boolean> check = fizzBuzzEngine.check(rules, facts);
            check.forEach((k,v)-> {
                log.info("rule = " + k.toString());
                log.info("value = "+ v.toString());
            });
            System.out.println();
        }
    }

}
