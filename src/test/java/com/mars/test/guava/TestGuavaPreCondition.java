package com.mars.test.guava;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by mars on 2016/5/31.
 */
@Slf4j
public class TestGuavaPreCondition {



    @Test(expected = NullPointerException.class)
    public void testNullPointerException() {
        Preconditions.checkNotNull(null, "Provided parameter is unacceptably null.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisorNotZeroException() {
        Preconditions.checkArgument(0 != 0, "Zero divisor not allowed.");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArrayElement() {
        Preconditions.checkElementIndex(3, new String[]{"Dustin", "Java"}.length, "String array index number");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckPositionIndex() {
        Preconditions.checkPositionIndex(3, new String[]{"Dustin", "Java"}.length, "String array index number");
    }

    @Test(expected = IllegalStateException.class)
    public void testCheckState() {
        Preconditions.checkState(isActive(), "Cannot perform action because not initialized.");
    }


    @Test
    public void testPrecondition() throws IllegalStateException {
        try{
            Preconditions.checkState(false,"测试错误Msg");
        } catch (IllegalStateException ise){
            log.info("errorMsg = " + ise.getMessage());
        }
    }


    public boolean isActive() {
        return false;
    }
}
