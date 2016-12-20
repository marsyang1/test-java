package com.mars.test.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

/**
 * Created by USER on 2016/12/20.
 */
@Slf4j
public class TestTable {

    @Test
    public void test1(){
        Table<String, String, String> employeeTable = HashBasedTable.create();
        employeeTable.put("IBM", "101","Mahesh");
        employeeTable.put("IBM", "102","Ramesh");
        employeeTable.put("IBM", "103","Suresh");

        employeeTable.put("Microsoft", "111","Sohan");
        employeeTable.put("Microsoft", "112","Mohan");
        employeeTable.put("Microsoft", "113","Rohan");

        employeeTable.put("TCS", "121","Ram");
        employeeTable.put("TCS", "122","Shyam");
        employeeTable.put("TCS", "123","Sunil");

        String employeeA = employeeTable.get("TCS","123");
        log.info("employeeA = " + employeeA);

        Map<String, String> employeeMs = employeeTable.row("Microsoft");
        log.info("employeeMs");
        for(String key : employeeMs.keySet()){
            log.info("employeeMs " + key + ", name =" + employeeMs.get(key));
        }

    }

}