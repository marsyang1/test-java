package com.mars.test.easyrule.weather;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by USER on 2017/5/31.
 */
public class WeatherRuleTest {


    @Test
    public void itRains() throws Exception {

        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);

        // define rules
        Rules rules = new Rules(new WeatherRule());

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

    }

}