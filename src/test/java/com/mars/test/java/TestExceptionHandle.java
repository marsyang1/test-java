package com.mars.test.java;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by USER on 2017/2/15.
 */
@Slf4j
public class TestExceptionHandle {


    @Test()
    public void test1(){
        try {
            Assert.assertEquals(0,getAAA());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("发生错误"+e.getMessage());
        }
    }

    private int getAAA() throws IOException{
        int aaa = 0;
        try{
            aaa=1;
            if(aaa!=0){
                throw new IOException("E0001");
            }
            return aaa;
        }catch (IOException e) {
            log.info("enter exception handle");
            throw e;
        }
    }
}
