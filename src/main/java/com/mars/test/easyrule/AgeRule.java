package com.mars.test.easyrule;

import lombok.extern.slf4j.Slf4j;
import org.easyrules.annotation.Rule;
import org.easyrules.core.BasicRule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule
@Slf4j
public class AgeRule extends BasicRule {

    private static final int ADULT_AGE = 18;

    private Person person;

    public AgeRule(Person person) {
        super("AgeRule",
                "Check if person's age is > 18 and marks the person as adult", 1);
        this.person = person;
    }

    @Override
    public boolean evaluate() {
        return person.getAge() > ADULT_AGE;
    }

    @Override
    public void execute() {
        person.setAdult(true);
        log.info("Person "+person.getName()+" has been marked as adult");
    }


}
