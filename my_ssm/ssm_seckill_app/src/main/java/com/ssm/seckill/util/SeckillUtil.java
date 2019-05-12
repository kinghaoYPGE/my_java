package com.ssm.seckill.util;

import org.springframework.util.DigestUtils;

public class SeckillUtil {
    /**
     * 默认加盐md5
     * @param seckillId
     * @return
     */
    public static String generateMD5(long seckillId) {
        String salt = "asdnfcgdp234029@#$df@#$";
        return DigestUtils.md5DigestAsHex((salt +"/"+ seckillId).getBytes());
    }

    /**
     * 指定加盐md5
     * @param seckillId
     * @param salt
     * @return
     */
    public static String generateMD5(long seckillId, String salt) {
        return DigestUtils.md5DigestAsHex((salt +"/"+ seckillId).getBytes());
    }
}
