package com.mars.test.easyrule.shop;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;
import org.junit.Test;

/**
 * Created by USER on 2017/5/31.
 */
@Slf4j
public class ShopRuleTest {

    @Test
    public void test1(){
        Person tom = new Person("Tom", 14);
        Facts facts = new Facts();
        facts.put("person", tom);

        // create a rules set
        Rules rules = new Rules();
        rules.register(new AgeRule());
        rules.register(new AlcoholRule());

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .build();

        System.out.println("Tom: Hi! can I have some Vodka please?");
        rulesEngine.fire(rules, facts);

    }

}