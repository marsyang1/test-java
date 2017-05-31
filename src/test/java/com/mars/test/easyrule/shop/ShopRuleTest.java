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
    public void test1() {
        Person tom = new Person("Tom", 14);
        Facts facts = new Facts();
        facts.put("person", tom);
        String wine = "Vodka";
        facts.put("wine", wine);

        // create a rules set
        Rules rules = new Rules();
        rules.register(new AgeRule());
        rules.register(new AlcoholRule());
        rules.register(new AdultAlcoholRule());

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSilentMode(true)
                .build();

        System.out.println(tom.getName() + ": Hi! can I have some " + wine + " please?");
        rulesEngine.fire(rules, facts);

        Person bob = new Person("Bob", 20);
        facts.put("person", bob);
        wine = "Whisky";
        facts.put("wine", wine);

        System.out.println(bob.getName() + ": Hi! can I have some " + wine + " please?");
        rulesEngine.fire(rules, facts);

    }

}