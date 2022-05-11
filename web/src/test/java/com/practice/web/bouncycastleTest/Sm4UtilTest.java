package com.practice.web.bouncycastleTest;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author Mark Wang
 * @date 2022/5/11 13:22
 */
@Slf4j
public class Sm4UtilTest {

    @Test
    public void ecbPkcs5Padding() throws Exception {
        String txt = "sm4对称加密<pkcs5>演示←←";
//        String key = "FA171555405706F73D7B973DB89F0B47";
        String key = "FA171555405706F7";
        byte[] output = Sm4Util.encryptEcbPkcs5Padding(txt.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
        String hex = Hex.toHexString(output);
        log.info("SM4-ECB-PKCS5Padding，加密输出HEX = {}", hex);
        // 解密
        byte[] input = Hex.decode(hex);
        output = Sm4Util.decryptEcbPkcs5Padding(input, key.getBytes(StandardCharsets.UTF_8));
        String s = new String(output, StandardCharsets.UTF_8);
        log.info("SM4-ECB-PKCS5Padding，解密输出 = {}", s);
        log.info("SM4-ECB-PKCS5Padding，key = {}", Hex.toHexString(key.getBytes(StandardCharsets.UTF_8)));
        Assert.assertEquals(txt, s);
    }
}
