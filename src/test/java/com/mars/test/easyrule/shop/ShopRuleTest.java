package com.mars.test.easyrule.shop;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.BasicRule;
import org.jeasy.rules.core.RulesEngineBuilder;
import org.junit.Test;

import java.util.List;

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
        rules.register(new AdultAlcoholRule());

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSilentMode(true)
                .build();

        System.out.println("Tom: Hi! can I have some Vodka please?");
        rulesEngine.fire(rules, facts);

        Person bob = new Person("Bob", 20);
        facts = new Facts();
        facts.put("person", bob);
        facts.put("wine","Vodka");

        System.out.println("Tom: Hi! can I have some Vodka please?");
        rulesEngine.fire(rules, facts);

    }

}