package cn.datai.puer.promotion.website.utils.sms;

import com.alibaba.druid.util.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @description 加解密工具集
 * @author WC
 */
public final class SecurityUtils {
    /** 默认的字符串编码方式 */
    public static String DEFAULT_ENCODING = "utf-8";

    private static final byte[] kv               = "hxac91o96t2q2p0p".getBytes();

    /** 日志对象 */
    private static final Logger logger           = LoggerFactory.getLogger(SecurityUtils.class);

    /**
     * 将指定的字符串转换成Base64编码
     * @param value
     * @return
     */
    public static final String encryptBase64ToString(String value) {
        String result = null;
        if (value != null) {
            try {
                result = Base64.byteArrayToBase64(value.getBytes(DEFAULT_ENCODING));
            }
            catch (Exception e) {
                logger.error("Base64编码字符串:{}失败", value);
            }
        }
        return result;
    }

    /**
     * 将指定的Base64编码字符串转换成byte数组
     * @param value
     * @return
     */
    public static final byte[] decryptStringToBase64(String value) {
        byte[] result = null;
        if (value != null) {
            try {
                result = Base64.base64ToByteArray(value);
            }
            catch (Exception e) {
                logger.error("Base64解码字符串:{}失败", value);
            }
        }
        return result;
    }

    /**
     * RSA加密
     * @param value 需要加密的数据
     * @param encode 加密密钥
     * @return 返回null说明加密失败
     */
    public static final byte[] encryptRSA(byte[] value, byte[] encode) {
        byte[] result = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keyspec = new X509EncodedKeySpec(encode);
            PublicKey key = keyFactory.generatePublic(keyspec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            result = cipher.doFinal(value);
        }
        catch (Exception ex) {
            logger.error("RSA编码:{}失败,KEY:{}", Strings.parse16(value), Strings.parse16(encode));
        }

        return result;
    }

    /**
     * RSA解密
     * @param value 需要解密的数据
     * @param encode 解密密钥
     * @return 返回null说明解密失败
     */
    public static final byte[] decryptRSA(byte[] value, byte[] encode) {
        byte[] result = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keyspec = new PKCS8EncodedKeySpec(encode);
            PrivateKey key = keyFactory.generatePrivate(keyspec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(value);
        }
        catch (Exception ex) {
            logger.error("RSA解码:{}失败,KEY:{}", Strings.parse16(value), Strings.parse16(encode));
        }

        return result;
    }

    /**
     * DES加密
     * @param value 需要加密的byte数组
     * @return encode 加密密钥
     * @return 返回null说明加密失败
     */
    public static final byte[] encryptDES(byte[] value, byte[] encode) {
        byte[] result = null;
        try {
            DESKeySpec keyspec = new DESKeySpec(encode);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = secretKeyFactory.generateSecret(keyspec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            result = cipher.doFinal(value);
        }
        catch (Exception e) {
            logger.error("DES编码:{}失败,KEY:{}", Strings.parse16(value), Strings.parse16(encode));
        }
        return result;

    }

    public static final String encryptDES(String value) {
        if (StringUtils.isNotBlank(value)) {
            byte[] bs;
            try {
                bs = encryptDES(value.getBytes("UTF-8"), kv);
                return Strings.parse16(bs);
            }
            catch (UnsupportedEncodingException e) {
                logger.error("不支持的字符集: UTF-8");
            }
        }
        return value;
    }

    /**
     * DES解密
     * @param value 需要解密的byte数组
     * @param encode 解密密钥
     * @return 返回null说明解密失败
     */
    public static final byte[] decryptDES(byte[] value, byte[] encode) {
        byte[] result = null;
        try {
            DESKeySpec keyspec = new DESKeySpec(encode);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(keyspec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            result = cipher.doFinal(value);
        }
        catch (Exception e) {
            logger.error("DES解码:{}失败,KEY:{}", Strings.parse16(value), Strings.parse16(encode));
        }
        return result;
    }

    public static final String decryptDES(String value) {
        try {
            if (StringUtils.isNotBlank(value)) {
                byte[] bs = ByteUtils.parse16(value);
                byte[] rs = decryptDES(bs, kv);
                return new String(rs, "utf-8");
            }
        }
        catch (Exception ex) {
            logger.error("DES解码:{}失败", value);
        }

        return value;
    }

    /**
     * 根据MD5加密算法加密自己数组
     * @param value 需要加密的数据
     * @return 返回null说明加密失败
     */
    public static final byte[] encryptMD5(byte[] value) {
        byte[] result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            result = messageDigest.digest(value);
        }
        catch (Exception ex) {
            logger.error("MD5编码:{}失败", Strings.parse16(value));
        }
        return result;
    }

    /**
     * 根据SHA-256加密算法加密字节数组
     * @param value
     * @return
     */
    public static final byte[] encryptSHA256(byte[] value) {
        byte[] result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            result = messageDigest.digest(value);
        }
        catch (Exception ex) {
            logger.error("MD5编码:{}失败", Strings.parse16(value));
        }
        return result;
    }

    /**
     * 获取RSA的KeyPair，其中包含了一对公钥/密钥
     * @return
     * @throws Exception
     */
    public static final KeyPair getKeyPair(int length) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(length);
            return keyGen.generateKeyPair();
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static final String hideEmail(String email) {
        StringBuffer rs = new StringBuffer();
        int index = email.lastIndexOf('@');
        if (index > 0) {
            int p = (index < 5) ? index / 2 : 3;
            rs.append(email.substring(0, p));
            appendSec(rs, index - p);
            rs.append(email.substring(index));
        }
        return rs.length() == 0 ? email : rs.toString();
    }

    public static final String hideMobileno(String mobileno) {
        StringBuffer rs = new StringBuffer();
        int len = mobileno.length();
        if (len < 11) {
            int p = len / 3;
            int m = len - p - p;
            rs.append(mobileno.substring(0, p));
            appendSec(rs, m);
            rs.append(mobileno.substring(len - p, len));
        }
        else {
            rs.append(mobileno.substring(0, 3));
            appendSec(rs, len - 7);
            rs.append(mobileno.substring(len - 4, len));
        }
        return rs.length() == 0 ? mobileno : rs.toString();
    }

    public static final String hideCardno(String cardno) {
        StringBuffer rs = new StringBuffer();
        int len = cardno.length();
        if (len == 18) {
            rs.append(cardno.substring(0, 4));
            appendSec(rs, 10);
            rs.append(cardno.substring(len - 4, len));
        }
        else {
            int p = len / 3;
            int m = len - p - p;
            rs.append(cardno.substring(0, p));
            appendSec(rs, m);
            rs.append(cardno.substring(len - p, len));
        }
        return rs.length() == 0 ? cardno : rs.toString();
    }

    public static final String hideOthers(String value) {
        StringBuffer rs = new StringBuffer();
        int len = value.length();
        if (len > 3) {
            rs.append(value.substring(0, 3));
            appendSec(rs, len - 7);
            rs.append(value.substring(len - 4, len));
        }
        else if (len > 1) {
            appendSec(rs, len - 1);
            rs.append(value.substring(len - 1, len));
        }
        return rs.length() == 0 ? value : rs.toString();
    }

    private static StringBuffer appendSec(StringBuffer buf, int len) {
        int i = len;
        while (i > 0) {
            buf.append("*");
            i--;
        }

        return buf;
    }

    public static void main(String[] args) {
        String s = "openaccount";
        String ss = encryptDES(s);
        String as = decryptDES("FE8311DCD308093E98949277401E3B3B379025C14ECE8E51");
        System.out.println(ss);
        System.out.println(as);
    }

    /**
     * 私有构造方法
     */
    private SecurityUtils() {

    }
}
