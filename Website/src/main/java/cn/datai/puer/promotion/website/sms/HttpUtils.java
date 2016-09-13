package cn.datai.puer.promotion.website.sms;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }
    
    /**
     * HTTP GET 请求
     * @param url
     * @param param
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String get(String url, Map<String, String> param, String charset) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringBuffer buffer = null;
        if (param != null && param.size() > 0) {
            buffer = new StringBuffer();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                try {
                    buffer.append("&").append(entry.getKey()).append("=")
                            .append(new String(entry.getValue().getBytes(), charset));
                }
                catch (Exception e) {
                }
            }
        }
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        try {
            if (buffer != null && buffer.length() > 0) {
                httpGet = new HttpGet(url + buffer.toString().replaceFirst("&", "?"));
            }
            else {
                httpGet = new HttpGet(url);
            }
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), charset);
            }
            return response.getStatusLine().getStatusCode() + "";
        }
        catch (Exception e) {
            logger.error("HTTP Client [Get] Error", e);
            return e.getLocalizedMessage();
        }
        finally {
            if (httpGet != null)
                httpGet.abort();
            if (response != null) {
                try {
                    response.close();
                }
                catch (IOException e) {
                }
            }
        }
    }
    
    /**
     * HTTP POST 请求
     * @param url
     * @param param
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String post(String url, Map<String, String> headers, Map<String, String> param, String charset) {
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        try {
            httpPost = new HttpPost(url);
            // 添加HTTP消息头
            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.addHeader(entry.getKey(), entry.getValue());
                }
            }
            
            // 设置编码格式与数据
            List<NameValuePair> nvps = new ArrayList<NameValuePair>(param.size());
            for (Map.Entry<String, String> entry : param.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
//            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, charset));

            // 发送HTTP Post请求
            CloseableHttpClient httpclient = HttpClients.createDefault();
            response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity(), charset);
            }
            return response.getStatusLine().getStatusCode() + "";
        }
        catch (Exception e) {
            logger.error("HTTP Client [POST] Error", e);
            return e.getLocalizedMessage();
        }
        finally {
            if (httpPost != null)
                httpPost.abort();
            if (response != null) {
                try {
                    response.close();
                }
                catch (IOException e) {
                }
            }
        }
    }
}
