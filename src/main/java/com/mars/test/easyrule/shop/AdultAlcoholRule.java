package com.mars.test.easyrule.shop;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

/**
 * Created by USER on 2017/5/24.
 */
@Slf4j
public class AdultAlcoholRule extends BasicRule {

    private Person person;

    public AdultAlcoholRule() {
        super("AlcoholRule", "Children are not allowed to buy alcohol", 3);
    }

    @Condition
    public boolean evaluate(Facts facts) {
        Person person = (Person) facts.get("person");
        return person.isAdult();
    }

    @Action
    public void execute(Facts facts){
        String wine = (String) facts.get("wine");
        log.info("Shop: Here is your " + wine);
        System.out.println();
    }

}