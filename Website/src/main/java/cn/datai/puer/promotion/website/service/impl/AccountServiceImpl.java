package cn.datai.puer.promotion.website.service.impl;

import cn.datai.puer.promotion.website.dao.ClickStatisticsMapperExt;
import cn.datai.puer.promotion.website.dao.MemberInfoMapperExt;
import cn.datai.puer.promotion.website.dao.ShareInfoMapperExt;
import cn.datai.puer.promotion.website.service.AccountService;
import cn.datai.puer.promotion.website.utils.ConstantUtil;
import cn.datai.puer.promotion.website.utils.HttpUtil;
import cn.datai.puer.promotion.website.vo.*;
import cn.datai.puer.promotion.website.vo.plugins.CustomerInfo;
import cn.datai.puer.promotion.website.vo.plugins.Head;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/23.
 */
@Service
public class AccountServiceImpl implements AccountService {

    public static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private ShareInfoMapperExt shareInfoMapperExt;

    @Autowired
    private MemberInfoMapperExt memberInfoMapperExt;

    @Autowired
    private ClickStatisticsMapperExt clickStatisticsMapperExt;

    /**
     * 验证来自会员决策的用户信息
     *
     * @param checkUrl 验证用户的url
     * @param account 交易账号
     * @return
     */
    @Override
    public CustomerInfo checkInfoFromMonitor(String checkUrl, String account) throws UnsupportedEncodingException {

        JSONObject jsonObject=null;
        try {
            String url = checkUrl;
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            paramList.add(new BasicNameValuePair("numberNos",account));
            List<NameValuePair> headList = new ArrayList<NameValuePair>();
            headList.add(new BasicNameValuePair("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"));
            String resultStr = HttpUtil.doSSLPost(url,headList,paramList, 5000, 5000, 5000, "UTF-8");
            if(HttpUtil.checkResultHttps(resultStr)){
                jsonObject=JSONObject.parseObject(resultStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.getCustomerInfoByJsonObject(jsonObject);
    }

    private static CustomerInfo getCustomerInfoByJsonObject(JSONObject jsonObject){
        if(null != jsonObject){
            Head head = JSONObject.parseObject(jsonObject.get("head").toString(),Head.class);
            if(!ConstantUtil.STRING_VALUE_0.equals(head.getCode())){
                return null;
            }else{
                List<CustomerInfo> customerInfoList = JSONObject.parseArray(jsonObject.get("body").toString(),CustomerInfo.class);
                if(null != customerInfoList && !customerInfoList.isEmpty()){
                    return customerInfoList.get(0);
                }
                return null;
            }
        }
        return null;
    }

    /**
     * 拼装分享信息
     *
     * @param phoneNum
     * @return
     */
    @Override
    public ShareInfo getShareInfo(String phoneNum) {
        return null;
    }

    /**
     * 向数据库插入分享信息，并返回分享ID
     *
     * @param shareInfo
     * @return
     */
    @Override
    public String insertShare(ShareInfo shareInfo) {
        shareInfoMapperExt.insert(shareInfo);
        return shareInfo.getShareId();
    }

    /**
     * 通过分享Id查询唯一一条分享信息
     *
     * @param shareId
     * @return
     */
    @Override
    public ShareInfo selectShareInfoByShareId(String shareId) {
        return shareInfoMapperExt.selectByPrimaryKey(shareId);
    }

    /**
     * 通过状态查询（没有状态默认查询全部）
     *
     * @param status
     * @return
     */
    @Override
    public List<MemberInfo> queryMemberInfoList(String status) {
        MemberInfoExample memberInfoExample = new MemberInfoExample();
        if(!StringUtils.isEmpty(status)){
            memberInfoExample.createCriteria().andMemberStatusEqualTo(status);
        }
        return memberInfoMapperExt.selectByExample(memberInfoExample);
    }

    /**
     * 根据会员编号查询会员单位信息
     *
     * @param memberId
     * @return
     */
    @Override
    public MemberInfo queryMemberInfoByMemberId(String memberId) {
        if(StringUtils.isEmpty(memberId)){
            return null;
        }
        MemberInfoExample memberInfoExample = new MemberInfoExample();
        memberInfoExample.createCriteria().andMemberStatusEqualTo(ConstantUtil.FLAG_N).andMemberIdEqualTo(memberId);
        List<MemberInfo> memberInfoList = memberInfoMapperExt.selectByExample(memberInfoExample);
        if(null != memberInfoList && !memberInfoList.isEmpty()){
            return memberInfoList.get(0);
        }
        return null;
    }

    /**
     * 插入统计数据
     *
     * @param clickStatistics
     */
    @Override
    public void insertClickStatistics(ClickStatistics clickStatistics) {
        clickStatistics.setClickTime(new Date());
        clickStatisticsMapperExt.insert(clickStatistics);
    }

    /**
     * 通交易账号查询是不是有分享记录
     *
     * @param account
     * @return
     */
    @Override
    public ShareInfo selectShareInfoByAccount(String account) {
        ShareInfoExample shareInfoExample = new ShareInfoExample();
        shareInfoExample.createCriteria().andShareAccountEqualTo(account);
        List<ShareInfo> shareInfoList =  shareInfoMapperExt.selectByExample(shareInfoExample);
        if(null == shareInfoList || shareInfoList.isEmpty()){
            return null;
        }
        return shareInfoList.get(0);
    }

    /**
     * 查询点击统计
     *
     * @param map
     * @return
     */
    @Override
    public List<ClickStatistics> queryClickStatisticsByCon(Map<String, Object> map) {
        //TODO
        return null;
    }

    @Override
    public void updateByPrimaryKeySelective(ShareInfo ShareInfo) {
        shareInfoMapperExt.updateByPrimaryKeySelective(ShareInfo);
    }

}
