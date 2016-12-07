package com.mars.test.encoding;

import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * Created by USER on 2016/12/1.
 */
@Slf4j
public class TestMd5 {

    @Test
    public void testMd5() throws Exception {
        final String mail = "qwer1234";
        String encode = Hashing.md5().hashString(mail, Charset.defaultCharset()).toString();
        log.info("encode = " + encode);

    }

}
