package com.mars.test.java;

        import lombok.extern.slf4j.Slf4j;
        import org.junit.Test;

        import java.io.UnsupportedEncodingException;
        import java.net.URLDecoder;
        import java.net.URLEncoder;

/**
 * Created by USER on 2017/1/9.
 */
@Slf4j
public class TestUriDecoder {

    @Test
    public void test1() throws UnsupportedEncodingException {
        String url = "http://localhost:8080/test.do?param=1&key=2";
        log.info("url = " + url);
        String encode = URLEncoder.encode(url, "UTF-8");
        log.info("encode =  " + encode);
        String decode = URLDecoder.decode(encode, "UTF-8");
        log.info("decode" + decode);
    }

}
