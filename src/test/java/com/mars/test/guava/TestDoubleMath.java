package com.mars.test.guava;

import com.google.common.math.DoubleMath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by USER on 2017/2/17.
 */
@Slf4j
public class TestDoubleMath {

    @Test
    public void test1(){
        Double test1 = 1.0;
        Double test2 = 1.1;
        Double test3 = 2.0;
        Double test4 = 3333333333.33;
        Double test5 = 0.0;
        Double test6 = 10.0;
        log.info("DoubleMath.isMathematicalInteger(testMd5) = " + DoubleMath.isMathematicalInteger(test1));
        log.info("DoubleMath.isMathematicalInteger(test2) = " + DoubleMath.isMathematicalInteger(test2));
        log.info("DoubleMath.isMathematicalInteger(test3) = " + DoubleMath.isMathematicalInteger(test3));
        log.info("DoubleMath.isMathematicalInteger(test4) = " + DoubleMath.isMathematicalInteger(test4));
        log.info("DoubleMath.isMathematicalInteger(test5) = " + DoubleMath.isMathematicalInteger(test5));
        log.info("DoubleMath.isMathematicalInteger(test6) = " + DoubleMath.isMathematicalInteger(test6));

    }

}
