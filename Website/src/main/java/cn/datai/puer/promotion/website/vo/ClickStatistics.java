package cn.datai.puer.promotion.website.vo;

import java.io.Serializable;
import java.util.Date;

public class ClickStatistics implements Serializable {
    public static final long serialVersionUID = 1134634526L;

    /**
     * 点击统计ID(自生成，uuid): CLICK_STATISTICS.CLICK_ID
     * @author MyBatis Generator
     */
    private String clickId;

    /**
     * 点击类型(1.进入老用户分享页面，2.老用户点击生成网址，3.新用户点击进入分享页面，4.新用户点击抢红包按钮，5.点击去开户，6.点击下载app,7.通过会员专属url进入): CLICK_STATISTICS.CLICK_TYPE
     * @author MyBatis Generator
     */
    private String clickType;

    /**
     * 点击时间: CLICK_STATISTICS.CLICK_TIME
     * @author MyBatis Generator
     */
    private Date clickTime;

    /**
     * 获取点击统计ID(自生成，uuid): CLICK_STATISTICS.CLICK_ID
     * @return 点击统计ID(自生成，uuid): CLICK_STATISTICS.CLICK_ID
     * @author MyBatis Generator
     */
    public String getClickId() {
        return clickId;
    }

    /**
     * 设置点击统计ID(自生成，uuid): CLICK_STATISTICS.CLICK_ID
     * @param clickId 映射数据库字段: CLICK_STATISTICS.CLICK_ID
     * @author MyBatis Generator
     */
    public void setClickId(String clickId) {
        this.clickId = clickId == null ? null : clickId.trim();
    }

    /**
     * 获取点击类型(1.进入老用户分享页面，2.老用户点击生成网址，3.新用户点击进入分享页面，4.新用户点击抢红包按钮，5.点击去开户，6.点击下载app,7.通过会员专属url进入): CLICK_STATISTICS.CLICK_TYPE
     * @return 点击类型(1.进入老用户分享页面，2.老用户点击生成网址，3.新用户点击进入分享页面，4.新用户点击抢红包按钮，5.点击去开户，6.点击下载app,7.通过会员专属url进入): CLICK_STATISTICS.CLICK_TYPE
     * @author MyBatis Generator
     */
    public String getClickType() {
        return clickType;
    }

    /**
     * 设置点击类型(1.进入老用户分享页面，2.老用户点击生成网址，3.新用户点击进入分享页面，4.新用户点击抢红包按钮，5.点击去开户，6.点击下载app,7.通过会员专属url进入): CLICK_STATISTICS.CLICK_TYPE
     * @param clickType 映射数据库字段: CLICK_STATISTICS.CLICK_TYPE
     * @author MyBatis Generator
     */
    public void setClickType(String clickType) {
        this.clickType = clickType == null ? null : clickType.trim();
    }

    /**
     * 获取点击时间: CLICK_STATISTICS.CLICK_TIME
     * @return 点击时间: CLICK_STATISTICS.CLICK_TIME
     * @author MyBatis Generator
     */
    public Date getClickTime() {
        return clickTime;
    }

    /**
     * 设置点击时间: CLICK_STATISTICS.CLICK_TIME
     * @param clickTime 映射数据库字段: CLICK_STATISTICS.CLICK_TIME
     * @author MyBatis Generator
     */
    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }
}