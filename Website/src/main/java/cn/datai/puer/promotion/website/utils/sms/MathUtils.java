package cn.datai.puer.promotion.website.utils.sms;

import org.apache.commons.lang.StringUtils;

import java.util.Random;

/**
 * @description 数学工具集
 */
public final class MathUtils {
    /** 随机种子 */
    private static Random random;

    /**
     * 获取一个随机范围在0（包含）到num（不包含）之间的随机数
     * @param num
     * @return
     */
    public static int getRandomNum(int num) {
        initRandomObj();
        return random.nextInt(num);
    }

    /**
     * 获取一个随机范围在min（包含）到max（不包含）之间的随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNum(int min, int max) {
        initRandomObj();
        return random.nextInt(max - min) + min;
    }

    /**
     * 获取一个Long型随机值
     * @return
     */
    public static long getRandomLong() {
        initRandomObj();
        return random.nextLong();
    }

    /**
     * 判断输入的字符串是否是number型
     * @return
     */
    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断输入的字符串是否是number型，且具有指定的length长度
     * @param str
     * @param length
     * @return
     */
    public static boolean isNumber(String str, int length) {
        if (StringUtils.isEmpty(str) || str.length() != length) {
            return false;
        }

        return isNumber(str);
    }

    /**
     * 判断输入的字符串是否是number型，且长度在min到max之间
     * @param str
     * @param min
     * @param max
     * @return
     */
    public static boolean isNumber(String str, int min, int max) {
        if (StringUtils.isEmpty(str) || str.length() < min || str.length() > max) {
            return false;
        }

        return isNumber(str);
    }

    /**
     * 将byte数组转换成long值
     * @param data
     * @return
     */
    public static long parse16(byte[] data) {
        return parse16(data, 0, data.length);
    }

    /**
     * 将byte数组转换成long值
     * @param data
     * @return
     */
    public static long parse16(byte[] data, int index, int length) {
        long result = 0;
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("不能将一个空的byte数组转换成long型");
        }
        else if (data.length < index + length) {
            throw new IllegalArgumentException("byte数组长度过短, 必须等于或大于 \"index\" + \"length\"的值: " + (index + length));
        }
        else if (length > 8) {
            throw new IllegalArgumentException("长度必须小于8");
        }
        else {
            int _index = 0;
            for (int i = (index + length - 1); i >= index; i--) {
                if (_index < length) {
                    result = result | (((long) (data[i] & 0xff)) << (_index * 8));
                    _index++;
                }
                else {
                    break;
                }
            }
        }

        return result;
    }

    /**
     * 获取高斯正态分布数据, miu为均值sigma2为方差
     * @param miu
     * @param sigma2
     * @return
     */
    public static double getGaussian(double miu, double sigma2) {
        double N = 12;
        double x = 0, temp = N;
        do {
            x = 0;
            for (int i = 0; i < N; i++) {
                x = x + (Math.random());
            }
            x = (x - temp / 2) / (Math.sqrt(temp / 12));
            x = miu + x * Math.sqrt(sigma2);
        }
        while (x <= 0);          // 在此我把小于0的数排除掉了
        return x;
    }

    /**
     * 初始化random对象
     */
    private static void initRandomObj() {
        if (random == null) {
            synchronized (MathUtils.class) {
                if (random == null) {
                    random = new Random();
                }
            }
        }
    }

    /**
     * 私有构造方法
     */
    private MathUtils() {

    }
}