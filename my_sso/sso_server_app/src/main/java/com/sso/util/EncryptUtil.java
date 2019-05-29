package com.sso.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class EncryptUtil {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "admin";
    public static final String SALT = "1io10fdgadfjvower389fhday29834aguourfwpg0w82dllfkfadf";
    public static final String AES_SALT = "g^&*g%^F766R&PIpGY&%yg%yt$^RyfU&UT*ugyTR^R^uf&&";

    /**
     * AES加密
     * @param content
     * @return
     */
    public static String AESEncode(String content) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(128, new SecureRandom(AES_SALT.getBytes()));
            SecretKey secretKey = keygen.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encode_bytes = content.getBytes("utf-8");
            byte[] aes_bytes = cipher.doFinal(encode_bytes);
            return new BASE64Encoder().encode(aes_bytes);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * AES解密
     * @param content
     * @return
     */
    public static String AESDecode(String content) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(128, new SecureRandom(AES_SALT.getBytes()));
            SecretKey original_key = keygen.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] byte_content = new BASE64Decoder().decodeBuffer(content);

            byte[] byte_decode = cipher.doFinal(byte_content);
            return new String(byte_decode, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
