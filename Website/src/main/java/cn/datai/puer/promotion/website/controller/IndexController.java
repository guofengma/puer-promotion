package cn.datai.puer.promotion.website.controller;

import cn.datai.puer.promotion.website.controller.basic.BaseController;
import cn.datai.puer.promotion.website.framework.annotation.Auth;
import cn.datai.puer.promotion.website.framework.enums.LoginUserType;
import cn.datai.puer.promotion.website.service.AccountService;
import cn.datai.puer.promotion.website.service.WeixinService;
import cn.datai.puer.promotion.website.utils.ConstantUtil;
import cn.datai.puer.promotion.website.utils.CookieUtils;
import cn.datai.puer.promotion.website.vo.*;
import cn.datai.puer.promotion.website.vo.plugins.ExportBaseVo;
import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyutao on 2016/8/8.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private WeixinService weixinService;

    @Value("${openaccount.puer_open_h5}")
    private String puer_open_h5;

    /**
     * 跳转主页面
     * @return
     */
    @RequestMapping("/appbanner")
    public String index(Model model) throws IOException {

        //该处插入数据库一条进入主页面数据
        ClickStatistics clickStatistics = new ClickStatistics();
        clickStatistics.setClickType(ConstantUtil.STRING_VALUE_1);
        accountService.insertClickStatistics(clickStatistics);

        MemberInfo memberInfo = queryMemberInfo("");
        model.addAttribute("memberNo",memberInfo.getMemberId());

        return "share";
    }

    /**
     * 跳转微信页面
     * @return
     */
    @RequestMapping(value = {"/index","/"})
    @Auth(loginUserType = LoginUserType.WEIXIN_BASE)
    public String toWeiXin(Model model, HttpServletRequest request) throws IOException {

        //该处插入数据库一条进入主页面数据
        ClickStatistics clickStatistics = new ClickStatistics();
        clickStatistics.setClickType(ConstantUtil.STRING_VALUE_1);
        accountService.insertClickStatistics(clickStatistics);

        MemberInfo memberInfo = queryMemberInfo("");
        model.addAttribute("memberNo",memberInfo.getMemberId());

        return "wenxinIndex";
    }

    /**
     * 跳转到网上开户页面
     * @return
     */
    @RequestMapping(value = "/openAccount")
    @Auth(loginUserType = LoginUserType.WEIXIN_BASE)
    public String openAccount(HttpServletRequest request,HttpServletResponse response,String shareId,String memberNo,Model model) throws IOException {
        if(!StringUtils.isEmpty(shareId)){
           //老用户
           ShareInfo shareInfo = accountService.selectShareInfoByShareId(shareId);
           if(null != shareInfo){
               model.addAttribute("tradeNo",shareInfo.getShareAccount());
               String shareMemberNo = shareInfo.getShareMemberId();
               MemberInfo memberInfo = this.queryMemberInfo(shareMemberNo);
               model.addAttribute("memberNo",memberInfo.getMemberId());
               model.addAttribute("customerName",shareInfo.getShareName());
           }else{
               model.addAttribute("tradeNo","");
               MemberInfo memberInfo = this.queryMemberInfo(memberNo);
               CookieUtils.setCookie(request,response,CookieUtils.USER_FALG,memberInfo.getMemberId());
           }
        }else{
            //新用户
            MemberInfo memberInfo = this.queryMemberInfo(memberNo);
            model.addAttribute("memberNo",memberInfo.getMemberId());
            model.addAttribute("tradeNo","");
            model.addAttribute("customerName","");
            CookieUtils.setCookie(request,response,CookieUtils.USER_FALG,memberInfo.getMemberId());
        }

        ClickStatistics clickStatistics = new ClickStatistics();
        clickStatistics.setClickType(ConstantUtil.STRING_VALUE_3);
        accountService.insertClickStatistics(clickStatistics);
        return "openaccount";
    }

    /**
     *点击开户按钮
     * @return
     */
    @RequestMapping(value = "/toOpenAccount",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> toOpenAccount(){
        Map<String,Object> result = new HashMap<String,Object>();
        try {
            ClickStatistics clickStatistics = new ClickStatistics();
            clickStatistics.setClickType(ConstantUtil.STRING_VALUE_5);
            accountService.insertClickStatistics(clickStatistics);
            result.put("puer_open_h5",puer_open_h5);
            result.put("flag",true);
        } catch (Exception e) {
           logger.error("toOpenAccount:插入统计操作发生异常：{}",e.getMessage());
            result.put("msg","请求异常不能跳转");
            result.put("flag",false);
        }
        return result;
    }

    private MemberInfo queryMemberInfo(String memberNo){
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

    @Auth(loginUserType = LoginUserType.WEIXIN_BASE)
    @RequestMapping(value = "weixinAuth")
    public String weixinAuth() {
        return "weixinAuth";
    }

    /**
     * 跳转到导出页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/toExportExcel")
    public String exportExcel(Model model){
        return "exportExcel";
    }

    /**
     * 报表管理--交易统计
     * @param clickStatistics
     * @param request
     */
    @RequestMapping(value = "/exportTradeStatsList")
    @ResponseBody
    public void exportTradeStatsList(ClickStatistics clickStatistics, HttpServletRequest request, HttpServletResponse response){
        try {
            Map<String,Object> params = new HashMap<String,Object>();
            String title = "交易统计";
            ExportBaseVo exportBaseVo = getExportBaseVo(title,"数量,创建时间,建仓价,平仓时间,平仓价,建仓手续费,平仓手续费,盈亏资金",request,response);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
            List<ClickStatistics> clickStatisticsList = accountService.queryClickStatisticsByCon(params);

            for (int i = 0; i < clickStatisticsList.size(); i++)
            {
                HSSFRow row  = exportBaseVo.getRow();
                row = exportBaseVo.getSheet().createRow(i + 1);
                // 第四步，创建单元格，并设置值

//                row.createCell(0).setCellValue(clickStatisticsList.get(i).getUserInfoId());
//                row.createCell(8).setCellValue(clickStatisticsList.get(i).getBuildPrice()==null ? "0.00":clickStatisticsList.get(i).getBuildPrice().toString());
//                row.createCell(9).setCellValue(clickStatisticsList.get(i).getCloseTime());

            }
            // 第六步，将文件存到指定位置

            exportBaseVo.getWb().write(response.getOutputStream());
            response.getOutputStream().close();

        } catch (Exception e) {
            logger.error("导出交易统计发生异常!");
        }
    }


    /**
     * 组装导出的excele的title和头信息
     * @return
     */
    private static ExportBaseVo getExportBaseVo(String title,String heads,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(title.getBytes("iso8859-1"),"utf-8") + ".xlsx");
        setFileDownloadHeader(request,response,title+".xls");

        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(title);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        HSSFCell cell = null;
        int cellSize = 0;
        if(!org.apache.commons.lang.StringUtils.isEmpty(heads)){
            String array[] = heads.split(",");
            cellSize= array.length;
            for(int i = 0;i<array.length;i++){
                cell = row.createCell(i);
                cell.setCellValue(array[i]);
                cell.setCellStyle(style);
            }
        }
        return new ExportBaseVo(wb,sheet,row,style,cell,cellSize);
    }

    private static void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
        final String userAgent = request.getHeader("USER-AGENT");
        try {
            String finalFileName = null;
            if(org.apache.commons.lang.StringUtils.contains(userAgent, "MSIE")){//IE浏览器
                finalFileName = URLEncoder.encode(fileName, "UTF8");
            }else if(org.apache.commons.lang.StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
                finalFileName = new String(fileName.getBytes(), "ISO8859-1");
            }else{
                finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
            }
            response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");//这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
        } catch (UnsupportedEncodingException e) {
        }
    }



}
