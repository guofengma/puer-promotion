package cn.datai.puer.promotion.website.sms;

import cn.datai.puer.promotion.website.sms.rsp.MessageResponse;
import cn.datai.puer.promotion.website.sms.rsp.ResultCode;
import cn.datai.puer.promotion.website.utils.sms.PropertiesUtil;
import cn.datai.puer.promotion.website.utils.sms.SecurityUtils;
import cn.datai.puer.promotion.website.utils.sms.Strings;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 神州软科HTTP协议
 * @author H.CAAHN
 */
public class SzrkHttpSmsSender extends AbstractMessageSender {
    private static final Logger logger      = LoggerFactory.getLogger(SzrkHttpSmsSender.class);
    
    private static final String URIENCODING = "UTF-8";
    
    private String signtip;
    
    public SzrkHttpSmsSender() {
    	signtip = PropertiesUtil.getValue("sms.port4.signtip");
    }
    
    public MessageResponse send(AbstractMessage message) throws Exception {
        SmsMessage msg = (SmsMessage) message;
        
        MessageResponse response = new MessageResponse();
        if (!this.open) {
            logger.warn("神州软科短信接口被关闭...");
            response.setResult(ResultCode.ERR_CLOSE);
            return response;
        }
        logger.debug("神州软科接口准备发送短消息:{}", message.getContent());
        
        if (!msg.getContent().endsWith(signtip)) {
            msg.setContent(msg.getContent() + signtip);
        }
        
        String content = URLEncoder.encode(msg.getContent(), URIENCODING);
        String sign = Strings.parse16(SecurityUtils.encryptMD5((content + password).getBytes()));
        Map<String, String> param = new HashMap<String, String>();
        param.put("cust_code", account);
        param.put("content", content);
        param.put("destMobiles", msg.getAddress());
        param.put("sign", sign);
        String rspstr = HttpUtils.get(submitUrl, param, URIENCODING);
        logger.info("神州软科短信接口消息发送: {}，接口返回结果:{}", SecurityUtils.hideMobileno(message.getAddress()), rspstr);
        
        response.setRspstr(rspstr);
        response.setResult(parseResult(rspstr));
        return response;
    }
    
    
    protected ResultCode parseResult(String rspstr) {
        if (StringUtils.isBlank(rspstr)) {
            logger.warn("调用神州软科短信接口，返回值为空");
            return ResultCode.ERR_RESULT_EMPTY;
        }
        
        ResultCode r = ResultCode.ERR_RESULT_UNDEFINE;
        String[] strs = rspstr.split("\r\n");
        if (strs.length > 0) {
            if (strs[0].startsWith("SUCCESS") && strs.length > 1) {
                String[] line = strs[1].split(":");
                String code = line[line.length - 1];
                switch (code) {
                    case "0":
                        r = ResultCode.SUCCESS;
                        break;
                    case "1":
                    case "6":
                    case "27":
                        r = ResultCode.FAIL_CONTENT;
                        break;
                    case "2":
                        r = ResultCode.FAIL_IP;
                        break;
                    case "3":
                    case "12":
                    case "13":
                    case "22":
                    case "23":
                        r = ResultCode.FAIL_ACCOUNT_AUTH;
                        break;
                    case "8":
                        r = ResultCode.FAIL_FREQUENT;
                        break;
                    case "24":
                        r = ResultCode.FAIL_BALANCE;
                        break;
                    case "25":
                        r = ResultCode.FAIL_KEYWORD;
                        break;
                    case "26":
                    case "28":
                        r = ResultCode.FAIL_TEMPLATE;
                        break;
                    default:
                        break;
                }
            }
            else {
                logger.error("调用神州软科短信接口失败，接口返回：{}", strs[0]);
            }
        }
        return r;
    }

	@Override
	public void callback(MessageResponse rsp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callbackException(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean testOpen() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static void sendMessage() throws Exception {
        SzrkHttpSmsSender sender = new SzrkHttpSmsSender();
        sender.setSubmitUrl("http://115.29.37.184:8860");
        sender.setOpen("true");
        sender.setAccount("100024");
        sender.setPassword("W5UZFWXJ6Q");
        SmsMessage msg = new SmsMessage();
        msg.setAddress("15996366464");
        msg.setContent("尊敬的用户，您本次的验证码为125458，为了保护您的帐号安全，此短信请勿告知他人。【江苏大泰】");
        MessageResponse rsp = sender.send(msg);
        System.out.println(JSON.toJSONString(rsp));
    }
	
	public static void main(String[] args) throws Exception {
		 SzrkHttpSmsSender sender = new SzrkHttpSmsSender();
	        sender.setSubmitUrl("http://115.29.37.184:8860");
	        sender.setOpen("true");
	        sender.setAccount("900174");
	        sender.setPassword("5XAH6PR8SC");
	        SmsMessage msg = new SmsMessage();
	        msg.setAddress("15996366464");
	        sender.signtip = "【江苏大泰】";
	        msg.setContent("尊敬的用户，您本次的验证码为125458，为了保护您的帐号安全，此短信请勿告知他人。【江苏大泰】");
	        MessageResponse rsp = sender.send(msg);
	        System.out.println(JSON.toJSONString(rsp));
	}
}
