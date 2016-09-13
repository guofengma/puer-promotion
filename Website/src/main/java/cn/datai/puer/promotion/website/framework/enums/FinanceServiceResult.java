package cn.datai.puer.promotion.website.framework.enums;

/**
 * Created by Administrator on 2016/3/9.
 */
public class FinanceServiceResult {

    /**
     * 订单处理返回码：成功
     */
    public static int SUCCESS = 2000;

    /**
     * 订单处理返回码：余额不足
     */
    public static int FAIL_NO_BALANCE = 4001;

    /**
     * 订单处理返回码：账户问题
     */
    public static int FAIL_ACCOUNT = 5000;

    /**
     * 订单处理返回码：订单问题
     */
    public static int FAIL_ORDER = 6000;

}
