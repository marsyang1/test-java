package com.mars.test.easyrule.shop;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.RuleListener;

/**
 * Created by USER on 2017/5/31.
 */
@Slf4j
public class ShopRuleFailureListener implements RuleListener {

    @Getter
    private boolean success = true;
    @Getter
    private String failureMessage="";

    @Override
    public boolean beforeEvaluate(Rule rule, Facts facts) {
        return true;
    }

    @Override
    public void afterEvaluate(Rule rule, Facts facts, boolean evaluationResult) {
        return;
    }

    @Override
    public void beforeExecute(Rule rule, Facts facts) {
        return;
    }

    @Override
    public void onSuccess(Rule rule, Facts facts) {
        return;
    }

    @Override
    public void onFailure(Rule rule, Facts facts, Exception exception) {
        log.debug("rule = " + rule);
        log.debug("facts = " + facts);
        log.debug("exception = " + exception.getMessage());
        success = false;
        failureMessage = exception.getMessage();
    }

}
