package com.mars.test.easyrule;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.core.BasicRule;

/**
 * Created by USER on 2017/5/24.
 */
@Slf4j
public class AlcoholRule extends BasicRule {

    private Person person;

    public AlcoholRule(Person person) {
        super("AlcoholRule",
                "Children are not allowed to buy alcohol",
                2);
        this.person = person;
    }

    @Condition
    public boolean evaluate() {
        return !person.isAdult();
    }

    @Action
    public void execute(){
        log.info("Shop: Sorry " + person.getName()+ ", you are not allowed to buy alcohol");
    }

}