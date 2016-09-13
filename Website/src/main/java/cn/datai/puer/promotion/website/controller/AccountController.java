package cn.datai.puer.promotion.website.controller;

import cn.datai.puer.promotion.website.controller.basic.BaseController;
import cn.datai.puer.promotion.website.service.AccountService;
import cn.datai.puer.promotion.website.utils.ConstantUtil;
import cn.datai.puer.promotion.website.utils.CookieUtils;
import cn.datai.puer.promotion.website.vo.*;
import cn.datai.puer.promotion.website.vo.plugins.CustomerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    private static final Random random = new Random();

    @Value("${decision.check_open_account_url}")
    private String check_open_account_url;

    /**
     * 用户提交
     * @param  account 交易账号
     * @return
     */
    @RequestMapping(value = "/generateShareUrl", method = RequestMethod.POST)
    @ResponseBody
    public ServerMessage generateShareUrl(HttpServletRequest request, HttpServletResponse response,String account) throws Exception {
        ServerMessage serverMessage = new ServerMessage();
        if(!isNumeric(account)){
            serverMessage.getResult().setCode(ConstantUtil.ERRORCODE);
            serverMessage.getResult().setMsg("交易账号错误!");
            return serverMessage;
        }

        try {
            //验证用户信息
            CustomerInfo customerInfo = accountService.checkInfoFromMonitor(check_open_account_url,account);

            if(null != customerInfo){
                //老用户(已开户)
                //先检查有没有分享记录
                ShareInfo shareInfo = accountService.selectShareInfoByAccount(account);
                String shareId = "";
                if(null == shareInfo){
                    //没有分享记录
                    ShareInfo newShare = new ShareInfo();
                    if(ConstantUtil.STRING_VALUE_1.equals(customerInfo.getCustomerStatus())){
                        //开户了
                        newShare.setShareMemberId(customerInfo.getMemberNo());
                        newShare.setShareAccount(customerInfo.getCustomerNo());
                        newShare.setShareName(customerInfo.getCustomerName());
                        newShare.setSharePhone(customerInfo.getMobileNo());
                        serverMessage.getResult().setData(customerInfo.getCustomerName());
                    }else{
                        //没有开户
                        String memberno = CookieUtils.getCookie(request,CookieUtils.USER_FALG);//cookie
                       if(StringUtils.isEmpty(memberno)){
                           newShare.setShareMemberId(ramdomMemberInfo("").getMemberId());
                       }else{
                           newShare.setShareMemberId(memberno);
                       }
                        newShare.setShareName("");
                        newShare.setShareAccount(account);
                        newShare.setSharePhone("");
                        serverMessage.getResult().setData("");
                    }
                    newShare.setShareTime(new Date());
                    //插入数据库 返回信息
                    shareId = accountService.insertShare(newShare);
                }else{
                    //有分享记录
                    shareId = shareInfo.getShareId();
                    ShareInfo info = new ShareInfo();
                    info.setShareId(shareId);
                    info.setShareName(null == customerInfo.getCustomerName()? "" : customerInfo.getCustomerName());
                    info.setShareMemberId(customerInfo.getMemberNo());
                    accountService.updateByPrimaryKeySelective(info);
                    serverMessage.getResult().setData(customerInfo.getCustomerName());
                }
                serverMessage.getResult().setMsg(shareId);//生成的分享ID
                serverMessage.getResult().setCode(ConstantUtil.RIGHTCODE);
            }else{
                //新用户
                serverMessage.getResult().setCode(ConstantUtil.ERRORCODE);
                serverMessage.getResult().setMsg("请求异常!");
            }

            //不论新老用户，都是点击了生成推荐网址按钮操作，所以这里需要往统计数据表插入一条数据
            ClickStatistics clickStatistics = new ClickStatistics();
            clickStatistics.setClickType(ConstantUtil.STRING_VALUE_2);
            accountService.insertClickStatistics(clickStatistics);
        } catch (UnsupportedEncodingException e) {
            serverMessage.getResult().setCode(ConstantUtil.ERRORCODE);
            serverMessage.getResult().setMsg("请求处理异常");
        }
        return serverMessage;
    }

    private MemberInfo ramdomMemberInfo(String memberNo){
        if(StringUtils.isEmpty(memberNo)){
            List<MemberInfo> memberInfoList = accountService.queryMemberInfoList(ConstantUtil.FLAG_N);
            Collections.shuffle(memberInfoList);
            return memberInfoList.get(0);
        }
        MemberInfo memberInfo = accountService.queryMemberInfoByMemberId(memberNo);
        if(null != memberInfo) {
            return memberInfo;
        }else{
            List<MemberInfo> memberInfoList = accountService.queryMemberInfoList(ConstantUtil.FLAG_N);
            Collections.shuffle(memberInfoList);
            return memberInfoList.get(0);
        }
    }

    /**
     * 生成{len}位数字随机密码
     * @return
     */
    public static String randomNumStr(int len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + random.nextInt(9);
        }
        return str;
    }

    /**
     * 手机号验证
     * @param  str
     * @return 验证通过返回true
     */
    private static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,6,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 密码
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isPwd(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[0-9a-zA-Z]{6,8}$"); // 验证密码
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 校验纯数字
     * @param str
     * @return
     */
    private static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if(!isNum.matches()){
            return false;
        }
        return true;
    }


}
