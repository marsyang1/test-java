package com.mars.test.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by USER on 2017/7/11.
 * reference : https://stackoverflow.com/questions/2779251/how-can-i-convert-json-to-a-hashmap-using-gson
 *
 */
@Slf4j
public class TestConvertMap {

    final Gson gson = new GsonBuilder().create();

    @Test
    public void testConvertMap(){
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> myMap = gson.fromJson("{'k1':'apple','k2':'orange'}", type);
        log.info("test convert = " + myMap);
    }
}
