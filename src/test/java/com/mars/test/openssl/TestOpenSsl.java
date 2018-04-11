package com.mars.test.openssl;

import com.github.davidmoten.security.PPK;
import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

@Slf4j
public class TestOpenSsl {

    File publicKey;
    File privateKey;

    public TestOpenSsl() {
        ClassLoader classLoader = getClass().getClassLoader();
        publicKey = new File(classLoader.getResource("key/public.der").getFile());
        privateKey = new File(classLoader.getResource("key/private.der").getFile());
        log.info("public key is exists :" + publicKey.exists());
    }

    @Test
    public void test1() {
        log.info("TEst");
        String content = "Hello World";
        byte[] encrypted =
                PPK.publicKey(publicKey)
                        .encrypt(content, Charsets.UTF_8);

        String decrypt = PPK
                .privateKey(privateKey)
                .decrypt(encrypted, Charsets.UTF_8);
        log.info("decrypt:" + decrypt);
    }


    public void test2() {
        PPK.privateKey("key/private.dar");
    }
}
