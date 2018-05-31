package com.mars.test.java.rsa;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * https://github.com/davidmoten/ppk
 */
@Slf4j
public class TestRsaEncryptTest {


    @Test
    public void test2048() throws Exception {
        final String targetEncryptText = "This is secret word.";

        String publicKeyContent = Files.toString(new File(Thread.currentThread().getContextClassLoader().getResource("publickey.pem").getFile()), Charsets.UTF_8);
        publicKeyContent = publicKeyContent.replaceAll("\\n", "")
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
        ;

        log.info("RSA public key lenght=" + publicKeyContent.length());

        File publicKeyFile = new File(Thread.currentThread().getContextClassLoader().getResource("publickey.pem").getFile());
        File privateKeyFile = new File(Thread.currentThread().getContextClassLoader().getResource("privatekey.pem").getFile());

        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        PEMKeyPair keyPair = (PEMKeyPair) pemParser.readObject();
        PrivateKeyInfo info = keyPair.getPrivateKeyInfo();
        JcaPEMKeyConverter CONVERTER = new JcaPEMKeyConverter();
        PrivateKey privateKey = CONVERTER.getPrivateKey(info);

        pemParser = new PEMParser(new FileReader(publicKeyFile));
        SubjectPublicKeyInfo publicKeyInfo = (SubjectPublicKeyInfo) pemParser.readObject();
        PublicKey publicKey = CONVERTER.getPublicKey(publicKeyInfo);

        log.info(publicKey.toString());

        String base64publicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        log.info("Public key:" + base64publicKey);
        log.info("Public key length :" + base64publicKey.length());


        // encrypt the message
        byte[] encrypted = encrypt(publicKey, targetEncryptText);
        log.info(new String(encrypted));  // <<encrypted message>>

        String encryptBase64String = Base64.getEncoder().encodeToString(encrypted);
        log.info("encryptBase64String :" + encryptBase64String);

        // decrypt the message
        byte[] decryptBase64bytes = Base64.getDecoder().decode(encryptBase64String);
        byte[] secret = decrypt(privateKey, decryptBase64bytes);
        log.info(new String(secret));     // This is a secret message
        Assert.assertEquals(targetEncryptText, new String(secret));

    }


    @Test
    public void testEncryptWithPpkLibrary() throws IOException {
        String content = "Hello World";

        File publicKeyFile = new File(Thread.currentThread().getContextClassLoader().getResource("publickey.pem").getFile());
        File privateKeyFile = new File(Thread.currentThread().getContextClassLoader().getResource("privatekey.pem").getFile());

        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        PEMKeyPair keyPair = (PEMKeyPair) pemParser.readObject();
        PrivateKeyInfo info = keyPair.getPrivateKeyInfo();
        JcaPEMKeyConverter CONVERTER = new JcaPEMKeyConverter();
        PrivateKey privateKey = CONVERTER.getPrivateKey(info);

        pemParser = new PEMParser(new FileReader(publicKeyFile));
        SubjectPublicKeyInfo publicKeyInfo = (SubjectPublicKeyInfo) pemParser.readObject();
        PublicKey publicKey = CONVERTER.getPublicKey(publicKeyInfo);

//        String base64 =
//                PPK.publicKey(publicKey)
//                        .encryptAsBase64("mypassword");
//        System.out.println(base64);

    }

    public static byte[] decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encrypted);
    }

    public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(message.getBytes());
    }
}