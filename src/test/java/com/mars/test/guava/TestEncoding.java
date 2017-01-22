package com.mars.test.guava;

import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by USER on 2016/12/1.
 */
@Slf4j
public class TestEncoding {

    @Test
    public void testMd5() throws Exception {
        final String mail = "qwer1234";
        String encode = Hashing.md5().hashString(mail, Charset.defaultCharset()).toString();
        log.info("qwer1234 md5 encode = " + encode);

    }

    @Test
    public void testBase32() throws Exception {
        final String mail = "qwer1234";
        String encode = BaseEncoding.base32().encode(mail.getBytes()).toString();
        log.info("qwer1234 base32 encode = " + encode);

    }

    @Test
    public void testBase64() throws Exception {
        final String mail = "qwer1234";
        String encode = BaseEncoding.base64().encode(mail.getBytes()).toString();
        log.info("qwer1234 base64  encode = " + encode);

    }

}
