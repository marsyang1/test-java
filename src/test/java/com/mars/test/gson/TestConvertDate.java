package com.mars.test.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * Created by USER on 2017/4/6.
 */
@Slf4j
public class TestConvertDate {

    @Test
    public void test1(){
        String json = new Gson().toJson(new Date());
        log.info("Date to json by default json =" + json);
    }

    @Test
    public void testSetDateTimeFormat(){
        String json = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(new Date());
        log.info("Date to json with format =" + json);
    }


}
