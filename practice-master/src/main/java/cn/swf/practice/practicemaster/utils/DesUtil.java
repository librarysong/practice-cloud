package cn.swf.practice.practicemaster.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * Created by 宋维飞
 * 2019/8/9 22:00
 */
@Slf4j
public class DesUtil {

    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final String DES = "DES";
    public static final String DEFAULT_KEY = "ClockOSMk";
    public static final String ALGORITHM = "DES";

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception 异常
     */
    public static String decode(String key, String data) {
        if (data == null) {
            return null;
        }
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return new String(cipher.doFinal(hex2byte(data.getBytes())));
        } catch (Exception e) {
            log.error(String.format("decode 解密失败key=%s,data=%s", key, data), e);
            return null;
        }
    }

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     * @throws Exception 异常
     */
    public static String decode(String key, String data, String ivp) {
        if (data == null) {
            return null;
        }
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(ivp.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return new String(cipher.doFinal(hex2byte(data.getBytes())));
        } catch (Exception e) {
            log.error(String.format("decode 解密失败key=%s,data=%s", key, data), e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Key k = toKey(key.getBytes());

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * DES算法，解密
     * ip使用DEFAULT_KEY
     *
     * @param key
     * @param data
     * @return
     */
    public static String defaultIvpDecode(String key, String data){
        return decode(key, data, DEFAULT_KEY);
    }

    /**
     * DES算法，加密
     * ip使用默认DEFAULT_KEY 8位
     *
     */
    public static String defaultIvpEncode(String key, String data) {
        return encode(key, data, DEFAULT_KEY);
    }

    /**
     * 使用默认key进行解密
     * 解密失败则返回原字符串
     * @param context
     * @param fail 解密失败的返回值
     * @return
     */
    public static String defaultKeyDecrypt(String context, String fail) {
        try {
            byte[] inputData = hex2byte(context.getBytes());
            inputData = decrypt(inputData, DEFAULT_KEY);
            return new String(inputData);
        } catch (Exception e) {
            return fail;
        }
    }

    /**
     * 使用默认key进行加密，并返回base64过的字符串
     * 加密失败则返回原字符串
     * @param context
     * @param fail 加密失败的返回值
     * @return
     */
    public static String defaultKeyEncrypt(String context, String fail) {
        try {
            byte[] inputData = context.getBytes();
            inputData = encrypt(inputData, DEFAULT_KEY);
            return byte2hex(inputData);
        } catch (Exception e) {
            return fail;
        }
    }

    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws InvalidAlgorithmParameterException
     * @throws Exception
     */
    public static String encode(String key, String data) {
        if (data == null) {
            return null;
        }
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data.getBytes());
            return byte2hex(bytes);
        } catch (Exception e) {
            log.error(String.format("encode 加密失败key=%s,data=%s", key, data), e);
            return null;
        }
    }

    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws InvalidAlgorithmParameterException
     * @throws Exception
     */
    public static String encode(String key, String data, String ivp) {
        if (data == null) {
            return null;
        }
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec(ivp.getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data.getBytes());
            return byte2hex(bytes);
        } catch (Exception e) {
            log.error(String.format("encode 加密失败key=%s,data=%s", key, data), e);
            return null;
        }
    }

    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Key k = toKey(key.getBytes());
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 使用key进行解密
     * 简单des加密的密文
     * @param key
     * @param context
     * @param fail 异常时返回的内容
     * @return
     */
    public static String simpleKeyDecrypt(String key,String context, String fail) {
        try {
            byte[] inputData = hex2byte(context.getBytes());
            inputData = decrypt(inputData, key);
            return new String(inputData);
        } catch (Exception e) {
            return fail;
        }
    }

    /**
     * 使用key进行des加密
     * 简单加密-无添加iv等参数
     * @param key
     * @param context
     * @param fail 异常时返回的内容
     * @return
     */
    public static String simpleKeyEncrypt(String key,String context, String fail) {
        try {
            byte[] inputData = context.getBytes();
            inputData = encrypt(inputData, key);
            return byte2hex(inputData);
        } catch (Exception e) {
            return fail;
        }
    }

    /**
     * 二行制转字符串
     *
     * @param b
     * @return
     */
    private static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    private static byte[] hex2byte(byte[] b) {
        int two = 2;
        if ((b.length % two) != 0) {
            throw new IllegalArgumentException();
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += two) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    /**
     * 转换密钥<br>
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

    public static void main(String[] args) {
        System.out.println(1111);
    }
}
