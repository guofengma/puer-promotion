package cn.datai.puer.promotion.website.service;

import cn.datai.puer.promotion.website.vo.ClickStatistics;
import cn.datai.puer.promotion.website.vo.MemberInfo;
import cn.datai.puer.promotion.website.vo.ShareInfo;
import cn.datai.puer.promotion.website.vo.SharedInfo;
import cn.datai.puer.promotion.website.vo.plugins.CustomerInfo;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface AccountService {
    /**
     * 验证来自会员决策的用户信息
     * @param phoneNum
     * @param  checkUrl
     * @return
     */
    public CustomerInfo checkInfoFromMonitor(String checkUrl, String phoneNum) throws UnsupportedEncodingException;

    /**
     * 拼装分享信息
     * @param phoneNum
     * @return
     */
    public ShareInfo getShareInfo(String phoneNum);

    /**
     * 向数据库插入分享信息，并返回分享ID
     * @param shareInfo
     * @return
     */
    public String insertShare(ShareInfo shareInfo);

    /**
     * 通过分享Id查询唯一一条分享信息
     * @param shareId
     * @return
     */
    public ShareInfo selectShareInfoByShareId(String shareId);

    /**
     * 通过状态查询（没有状态默认查询全部）
     * @return
     */
    public List<MemberInfo> queryMemberInfoList(String status);

    /**
     * 根据会员编号查询会员单位信息
     * @param memberId
     * @return
     */
    public MemberInfo queryMemberInfoByMemberId(String memberId);

    /**
     * 插入统计数据
     * @param clickStatistics
     */
    public void insertClickStatistics(ClickStatistics clickStatistics);

    /**
     * 通过交易账号查询是不是有分享记录
     * @param account
     * @return
     */
    public ShareInfo selectShareInfoByAccount(String account);

    /**
     * 查询点击统计
     * @param map
     * @return
     */
    public List<ClickStatistics> queryClickStatisticsByCon(Map<String,Object> map);

    public void updateByPrimaryKeySelective(ShareInfo shareInfo);

}
