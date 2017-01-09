package com.mars.test.java;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by USER on 2016/12/1.
 * http://stackoverflow.com/questions/782178/how-do-i-convert-a-string-to-an-inputstream-in-java
 */
@Slf4j
public class TestInputStream {


    @Test
    public void testStringToInputStream() throws IOException {
        String sampleString = "asdkfjsadkjflasj";
        InputStream stream = new ByteArrayInputStream(sampleString.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testInputStreamToString() throws IOException {
        String expect = "These word form input stream";
        InputStream stream = new ByteArrayInputStream(expect.getBytes(StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuffer stringBuffer = new StringBuffer();
        String str = "";
        while ((str = reader.readLine()) != null) {
            stringBuffer.append(str);
        }
        String actual = stringBuffer.toString();
        log.info("actual = " + actual);
    }

}
