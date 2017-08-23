package com.mars.test.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 2017/8/23.
 */
@Slf4j
public class TestClassifyByMultiMap {

    @Test
    public void test1() {
        List<IpConfig> ipconfigList = getList();
        Multimap<IpConfig.Type, String> multimap = ArrayListMultimap.create();
        for (IpConfig config : ipconfigList) {
            multimap.put(config.getType(), config.getIp().trim());
        }
        final List<String> allowList = ImmutableList.copyOf(multimap.get(IpConfig.Type.A));
        final List<String> denyList = ImmutableList.copyOf(multimap.get(IpConfig.Type.D));
        log.info("allowList =" + Arrays.toString(allowList.toArray()));
        log.info("denyList =" +  Arrays.toString(denyList.toArray()));
    }

    public List<IpConfig> getList() {
        return Lists.newArrayList();
    }

}
