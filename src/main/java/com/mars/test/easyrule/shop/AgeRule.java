package com.mars.test.easyrule.shop;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule
@Slf4j
public class AgeRule extends BasicRule {

    private static final int ADULT_AGE = 18;

    private Person person;

    public AgeRule() {
        super("AgeRule", "Check if person's age is > 18 and marks the person as adult", 1);
    }

    @Override
    public boolean evaluate(Facts facts) {
        Person person = (Person) facts.get("person");
        return person.getAge() > ADULT_AGE;
    }

    @Override
    public void execute(Facts facts) throws Exception {
        Person person = (Person) facts.get("person");
        person.setAdult(true);
        log.info("Person "+person.getName()+" has been marked as adult");
        System.out.println();
    }
}
