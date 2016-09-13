package cn.datai.puer.promotion.website.utils.sms;

import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

/**
 * @description 通用工具集
 */
public final class GeneralUtils {
    /**
     * char数组
     */
    public final static char[] digits = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', '_', '-', '~', '!', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+',
            '/', '{', '}', '[', ']', '|', '\\', ':', ';', '"', '\"', '<', '>', ',', '.', '?'};

    /**
     * 获取一个长度为16位的随机ID，该ID字符范围在0-9a-zA-Z和字符'_'之间
     * (该方法的执行速度明显优于UUID)
     * @return
     */
    public static String getRandomId() {
        return getRandomId(16);
    }

    /**
     * 获取指定长度的随机ID，该ID字符范围在0-9a-zA-Z和字符'_'以及'-'之间
     * (该方法的执行速度明显优于UUID)
     * @param length 长度在1~32之间
     * @return
     */
    public static String getRandomId(int length) {
        if (length <= 0 || length > 32) {
            throw new IllegalArgumentException("Input value mast be more then 0 and less then 33, but you input: "
                    + length);
        }

        long num = MathUtils.getRandomLong();
        StringBuffer buf = new StringBuffer();
        for (int i = 0, c = 0; i < length; i++, c++) {
            long n = (num >> c * 6) & 0x3f;
            if (c >= 10) {
                c = -1;
                num = MathUtils.getRandomLong();
            }
            buf.append(digits[(int) n]);
        }

        return buf.toString();
    }

    /**
     * 获取指定随机字符串，该字符串中字符范围在0-9a-zA-Z和特殊字符
     * @param length 长度在1~128之间
     * @return
     */
    public static String getRandomString(int length) {
        if (length <= 0 || length > 128) {
            throw new IllegalArgumentException("Input value mast be more then 0 and less then 129, but you input: "
                    + length);
        }

        StringBuffer buf = new StringBuffer();
        for (byte i = 0; i < length; i++) {
            int n = MathUtils.getRandomNum(digits.length);
            buf.append(digits[n]);
        }

        return buf.toString();
    }

    /**
     * 判断输入的对象是否为null，如果该对象是集合或数组的话，则判断是否包含有数据
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        }
        else if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        return false;
    }

    /**
     * 等待seconds秒，相当于Thread.sleep(seconds)
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds);
        }
        catch (InterruptedException e) {

        }
    }

    /**
     * 获取编译目录下的文件数据
     * @param path
     * @return
     */
    public static InputStream getInputStream(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return GeneralUtils.class.getResourceAsStream(path);
    }

    /**
     * 获取编译目录下的文件路径URL
     * @param path
     * @return
     */
    public static URL getPathURL(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return GeneralUtils.class.getResource(path);
    }

    /**
     * 取消所有点
     * @param str
     * @return
     */
    public static String trimAllPoint(String str) {
        if (StringUtils.isNotBlank(str)) {
            str = str.replaceAll("[·.`●]", "");
        }

        return str;
    }

    /**
     * 将所有点更改为特殊点
     * @param str
     * @return
     */
    public static String replactPoint(String str) {
        if (StringUtils.isNotBlank(str)) {
            str = str.replaceAll("[·.`●]", "·");
        }

        return str;
    }

    /**
     * 私有构造方法
     */
    private GeneralUtils() {

    }

    public static void main(String[] args) {
        String str = "aa.aa·a.";
        str = trimAllPoint(str);
        System.out.println(str);
    }
}