package com.mars.test.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.util.Date;

/**
 * Created by USER on 2017/4/6.
 */
@Slf4j
public class TestConvertDate {

    final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    @Test
    public void test1() {
        String json = new Gson().toJson(new Date());
        log.info("Date to json by default json =" + json);
    }

    @Test
    public void testSetDateTimeFormat() {
        String json = gson.toJson(new Date());
        log.info("Date to json with format =" + json);
    }

    @Test
    public void testDateTimeFormat() {
        TestData data = new TestData("1234"
                , DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2017-01-24 00:00:00").toDate());
        String json = gson.toJson(data);
        log.info("Date to json with format =" + json);
        data = gson.fromJson(json,TestData.class);
        log.info("data = " + data.toString());
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class TestData {
        private String name;
        private Date date;
    }


}
