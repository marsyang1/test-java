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
        // create a rules set
        Rules rules = new Rules();
        rules.register(new AgeRule());
        rules.register(new AlcoholRule());
        rules.register(new AdultAlcoholRule());

        // create a Listener
        ShopRuleFailureListener listener = new ShopRuleFailureListener();

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSilentMode(true)
                .withSkipOnFirstFailedRule(true)
                .withRuleListener(listener)
                .build();

        Person tom = new Person("Tom", 14);
        Facts facts = new Facts();
        facts.put("person", tom);
        String wine = "Vodka";
        facts.put("wine", wine);
        System.out.println(tom.getName() + ": Hi! can I have some " + wine + " please?");

        rulesEngine.fire(rules, facts);
        if(!listener.isSuccess()){
            log.warn(listener.getFailureMessage());
        }

        Person bob = new Person("Bob", 20);
        facts.put("person", bob);
        wine = "Whisky";
        facts.put("wine", wine);

        System.out.println(bob.getName() + ": Hi! can I have some " + wine + " please?");
        rulesEngine.fire(rules, facts);

    }

    @Test
    public void testEvaluateWithException() {
        // create a rules set
        Rules rules = new Rules();
        rules.register(new AgeRule());
        rules.register(new AlcoholRule());
        rules.register(new AdultAlcoholRule());

        // create a Listener
        ShopRuleFailureListener listener = new ShopRuleFailureListener();

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSilentMode(true)
                .withSkipOnFirstFailedRule(true)
                .withRuleListener(listener)
                .build();

        Facts facts = new Facts();
        try {
            rulesEngine.fire(rules, facts);
            if (!listener.isSuccess()) {
                log.warn(listener.getFailureMessage());
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }



    @Test
    public void testEngineCheck() {
        // create a rules set
        Rules rules = new Rules();
        rules.register(new AgeRule());
        rules.register(new AlcoholRule());
        rules.register(new AdultAlcoholRule());

        // create a Listener
        ShopRuleFailureListener listener = new ShopRuleFailureListener();

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSilentMode(true)
                .withSkipOnFirstFailedRule(true)
                .withRuleListener(listener)
                .build();

        Person tom = new Person("Tom", 14);
        Facts facts = new Facts();
        facts.put("person", tom);
        String wine = "Vodka";
        facts.put("wine", wine);

        try {
            // Check rules without firing them.
            rulesEngine.check(rules, facts);
            if (!listener.isSuccess()) {
                log.warn(listener.getFailureMessage());
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }


    @Test
    public void testEngineCheck2() {
        // create a rules set
        Rules rules = new Rules();
        rules.register(new AgeRule());
        rules.register(new AlcoholRule());
        rules.register(new AdultAlcoholRule());

        // create a Listener
        ShopRuleFailureListener listener = new ShopRuleFailureListener();

        //create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .withSilentMode(true)
                .withSkipOnFirstFailedRule(true)
                .withRuleListener(listener)
                .build();

        Facts facts = new Facts();
        try {
            // Check rules without firing them.
            rulesEngine.check(rules, facts);
            if (!listener.isSuccess()) {
                log.warn(listener.getFailureMessage());
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

}