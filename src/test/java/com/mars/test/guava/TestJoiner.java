package com.mars.test.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by yangyuchi on 28/01/2017.
 */
@Slf4j
public class TestJoiner {


    @Test
    public void test1(){
        final String expect = "title_mars";
        List<String> strings = ImmutableList.of("title","mars");
        String actual = Joiner.on("_").join(strings);
        log.info("join string =" + actual);
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void test2(){
        final String expect = "mars";
        List<String> strings = Lists.newArrayList();
        strings.add(null);
        strings.add(expect);
        String joinString = Joiner.on("_").skipNulls().join(strings);
        log.info("join string =" + joinString);
        String actual = Splitter.on("_").splitToList(joinString).get(0);
        Assert.assertEquals(expect,actual);
    }


}
