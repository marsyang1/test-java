package com.mars.test.easyrule;

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

    public AgeRule(Person person) {
        super("AgeRule",
                "Check if person's age is > 18 and marks the person as adult", 1);
        this.person = person;
    }

    public boolean evaluate() {
        return person.getAge() > ADULT_AGE;

    }

    public void execute() {
        person.setAdult(true);
        log.info("Person "+person.getName()+" has been marked as adult");
    }

    @Override
    public boolean evaluate(Facts facts) {
        return person.getAge() > ADULT_AGE;
    }

    @Override
    public void execute(Facts facts) throws Exception {
        super.execute(facts);
        person.setAdult(true);
        log.info("Person "+person.getName()+" has been marked as adult");
    }
}
