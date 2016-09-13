package cn.datai.puer.promotion.website.controller;

import cn.datai.puer.promotion.website.controller.basic.BaseController;
import cn.datai.puer.promotion.website.dao.SharedInfoMapperExt;
import cn.datai.puer.promotion.website.vo.FailedUserInfo;
import cn.datai.puer.promotion.website.vo.Response;
import cn.datai.puer.promotion.website.vo.ResponseHead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangxiang on 2016/8/24
 */
//@Controller
@RequestMapping("/promotion")
public class PromotionController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(PromotionController.class);

    @Autowired
    SharedInfoMapperExt sharedInfoMapperExt;

    @RequestMapping(value = "/queryFailedUserByMobileNo")
    @ResponseBody
    public Response queryFailedUserByMobileNo(String mobileNo){
        Response r = new Response();

        try {
            ResponseHead h = new ResponseHead();
            h.setCode("0");
            h.setMsg("成功");
            r.setHead(h);
            FailedUserInfo u = sharedInfoMapperExt.queryFailedUserByMobileNo(mobileNo);
            if (u != null) {
                r.setBody(u);
            }
        }catch (Exception e){
            logger.error("queryFailedUserByMobileNo for [{}] error:",mobileNo,e);
            ResponseHead h = new ResponseHead();
            h.setCode("-1");
            h.setMsg("系统异常");
            r.setHead(h);
        }
        return r;
    }
}
