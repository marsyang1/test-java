package com.mars.test.easyrule;

import lombok.extern.slf4j.Slf4j;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by USER on 2017/5/24.
 */
@Slf4j
public class AlcoholRuleTest {
    @Test
    public void execute() throws Exception {

        //create a person instance
        Person tom = new Person("Tom", 14);
        log.info("Tom: Hi! can I have some Vodka please?");

        //create a rules engine
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .named("shop rules engine")
                .build();

        //register rules
        rulesEngine.registerRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();
    }

    @Test
    public void execute2() throws Exception {

        //create a person instance
        Person tom = new Person("Tom", 19);
        log.info("Tom: Hi! can I have some Vodka please?");

        //create a rules engine
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .named("shop rules engine")
                .build();

        //register rules
        rulesEngine.registerRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();
    }


}