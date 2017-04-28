package com.mars.test.guava;

import com.google.common.base.MoreObjects;
import com.mars.test.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by USER on 2017/4/25.
 */
@Slf4j
public class TestMoreObject {


    @Test
    public void testMoreObject(){
        UserVo vo = new UserVo();
        vo.setName("Test1");
        vo.setAge(20);
        vo.setHeight(166);
        vo.setWeight(30);

        String param = MoreObjects.toStringHelper(vo)
                .add("name", vo.getName())
                .add("age", vo.getAge())
                .add("Height", vo.getHeight())
                .toString();

        log.info("MoreObject.toString = " + param);

    }



}
