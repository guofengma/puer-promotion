package cn.datai.puer.promotion.website.utils;/*
 * 文件名：HttpUtil.java
 * 版权：Copyright 2015 江苏大泰信息技术有限公司. All Rights Reserved. 
 * 描述：Http工具类
 * 创建人：汪涛
 * 创建时间：2015-08-03
 */

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Http工具类.
 * 提供Http通讯相关方法
 * @author wangtao
 *
 */
public class HttpUtil {

    /** Http请求成功编码. */
    public static final String HTTP_RESP_OK = "1000";
    /** Http请求失败编码. */
    public static final String HTTP_RESP_ERR = "1001";
    /** Http请求无响应编码. */
    public static final String HTTP_RESP_NONE = "1002";
    /** Http请求链接异常. */
    public static final String HTTP_CONNECT_ERR = "1003";

    /**
     * 验证请求客户端URL是否合法
     * @param req 请求
     * @param url 合法的URL
     * @return true:合法;false:非法
     */
    public static boolean isCorrectUrl(HttpServletRequest req, String url) {
        String ip = getClientUrl(req);
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            return false;
        }
        if (StringUtils.isEmpty(url) || url.startsWith(ip)) {
            return true;
        }
        return false;
    }

    /**
     * 获得请求发起端IP.
     * @param request 请求
     * @return 请求发起端IP
     */
    public static String getClientUrl(HttpServletRequest request) {
        String ipStr = request.getHeader("X-Real-IP");
        if (StringUtils.isEmpty(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("x-forwarded-for");
        }
        if (StringUtils.isEmpty(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getRemoteAddr();
        }
        // 多级反向代理
        if (!StringUtils.isEmpty(ipStr) && !StringUtils.isEmpty(ipStr.trim())) {
            StringTokenizer st = new StringTokenizer(ipStr, ",");
            if (st.countTokens() > 1) {
                return st.nextToken();
            }
        }
        return ipStr;
    }

    /**
     * 实现Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param param 请求参数
     * @param charset 请求字符编码
     * @return 响应包体内容字符串
     */
    public static String doPost(String url, List<NameValuePair> headers, List<NameValuePair> param, String charset) {
        return doPost(url, headers, param, charset, null, null, null);
    }

    /**
     * 实现Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param body 请求参数
     * @param charset 请求字符编码
     * @return 响应包体内容字符串
     */
    public static String doPost(String url, List<NameValuePair> headers, String body, String charset) {
        return doPost(url, headers, body, charset, null, null, null);
    }

    /**
     * 实现Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param param 请求参数
     * @param charset 请求字符编码
     * @param connTimeout 连接超时设定
     * @param soTimeout 数据传输超时设定
     * @param crTimeout 连接管理器超时设定
     * @return 响应包体内容字符串
     */
    public static String doPost(String url, List<NameValuePair> headers, List<NameValuePair> param, String charset, Integer connTimeout, Integer soTimeout, Integer crTimeout) {
        // 响应内容字符串
        String rspStr = null;
        // 请求客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 设置请求各超时时间
        RequestConfig rc = RequestConfig.custom()
                // 请求连接时间  默认60秒
                .setConnectTimeout(null == connTimeout ? 60000 : connTimeout)
                // 数据传输时间 默认180秒
                .setSocketTimeout(null == soTimeout ? 180000 : soTimeout)
                // 连接管理器超时时间 0:无限;-1:未定义
                .setConnectionRequestTimeout(null == crTimeout ? 0 : crTimeout)
                .build();
        // Post请求
        HttpPost post = new HttpPost(url);
        post.setConfig(rc);
        // 响应
        CloseableHttpResponse rsp = null;
        try {
            if (null != headers) {
                for (int i = 0; i < headers.size(); i++) {
                    post.setHeader(headers.get(i).getName(), headers.get(i).getValue());
                }
            }
            String usedCharset = StringUtils.isEmpty(charset) ? "UTF-8" : charset;
            post.setEntity(new UrlEncodedFormEntity(param, usedCharset));
            rsp = client.execute(post);
            HttpEntity eny = rsp.getEntity();
            if (null == eny)
            {
                rspStr = HTTP_RESP_NONE;
            }
            else
            {
                rspStr = EntityUtils.toString(eny, (StringUtils.isEmpty(charset) ? "UTF-8" : charset));
            }
            // 销毁Response体对象
            // 关闭HttpPost
            post.abort();
        } catch (UnsupportedEncodingException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (ClientProtocolException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (IOException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (Exception e) {
            rspStr = HTTP_RESP_ERR;
        } finally {
            // 关闭HttpClient
            try {
                rsp.close();
                client.close();
            } catch (Exception e) {
                rspStr = HTTP_RESP_ERR;
            }
        }
        return rspStr;
    }

    /**
     * 实现Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param body 请求参数
     * @param charset 请求字符编码
     * @param connTimeout 连接超时设定
     * @param soTimeout 数据传输超时设定
     * @param crTimeout 连接管理器超时设定
     * @return 响应包体内容字符串
     */
    public static String doPost(String url, List<NameValuePair> headers, String body, String charset, Integer connTimeout, Integer soTimeout, Integer crTimeout) {
        // 响应内容字符串
        String rspStr = null;
        // 请求客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 设置请求各超时时间
        RequestConfig rc = RequestConfig.custom()
                // 请求连接时间  默认60秒
                .setConnectTimeout(null == connTimeout ? 60000 : connTimeout)
                // 数据传输时间 默认180秒
                .setSocketTimeout(null == soTimeout ? 180000 : soTimeout)
                // 连接管理器超时时间 0:无限;-1:未定义
                .setConnectionRequestTimeout(null == crTimeout ? 0 : crTimeout)
                .build();
        // Post请求
        HttpPost post = new HttpPost(url);
        post.setConfig(rc);
        // 响应
        CloseableHttpResponse rsp = null;
        try {
            if (null != headers) {
                for (int i = 0; i < headers.size(); i++) {
                    post.setHeader(headers.get(i).getName(), headers.get(i).getValue());
                }
            }
            String usedCharset = StringUtils.isEmpty(charset) ? "UTF-8" : charset;
            if (!StringUtils.isEmpty(body)) {
                post.setEntity(new StringEntity(body, usedCharset));
            }
            rsp = client.execute(post);
            HttpEntity eny = rsp.getEntity();
            if (null == eny) {
                rspStr = HTTP_RESP_NONE;
            } else {
                rspStr = EntityUtils.toString(eny, (StringUtils.isEmpty(charset) ? "UTF-8" : charset));
            }
            // 销毁Response体对象
            // 关闭HttpPost
            post.abort();
        } catch (UnsupportedEncodingException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (ClientProtocolException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (IOException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (Exception e) {
            rspStr = HTTP_RESP_ERR;
        } finally {
            // 关闭HttpClient
            try {
                rsp.close();
                client.close();
            } catch (Exception e) {
                rspStr = HTTP_RESP_ERR;
            }
        }
        return rspStr;
    }

    /**
     * 实现SSL Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param param 请求参数
     * @return 响应包体内容字符串
     */
    public static String doSSLPost(String url, List<NameValuePair> headers, List<NameValuePair> param) {
        return doSSLPost(url, headers, param, null, null, null, null);
    }

    /**
     * 实现SSL Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param param 请求参数
     * @param charset 请求字符编码
     * @return 响应包体内容字符串
     */
    public static String doSSLPost(String url, List<NameValuePair> headers, List<NameValuePair> param, String charset) {
        return doSSLPost(url, headers, param, null, null, null, charset);
    }

    /**
     * 实现SSL Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param param 请求参数
     * @param connTimeout 连接超时设定
     * @param soTimeout 数据传输超时设定
     * @param crTimeout 连接管理器超时设定
     * @param charset 编码
     * @return 响应包体内容字符串
     */
    public static String doSSLPost(String url, List<NameValuePair> headers, List<NameValuePair> param, Integer connTimeout, Integer soTimeout, Integer crTimeout, String charset) {
        // 响应内容字符串
        String rspStr = null;
        CloseableHttpClient client = null;
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(trustStore).build();
            TrustManager tm = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                @Override
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
            };
            sslContext.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier(){
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }
                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }
                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }
                
            });
            client = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException  e) {
            rspStr = HTTP_CONNECT_ERR;
        } catch (NoSuchAlgorithmException e) {
            rspStr = HTTP_CONNECT_ERR;
        } catch (KeyStoreException e) {
            rspStr = HTTP_CONNECT_ERR;
        } catch (Exception  e) {
            rspStr = HTTP_CONNECT_ERR;
        }
        // 设置请求各超时时间
        RequestConfig rc = RequestConfig.custom()
                // 请求连接时间  默认60秒
                .setConnectTimeout(null == connTimeout ? 60000 : connTimeout)
                // 数据传输时间 默认180秒
                .setSocketTimeout(null == soTimeout ? 180000 : soTimeout)
                // 连接管理器超时时间 0:无限;-1:未定义
                .setConnectionRequestTimeout(null == crTimeout ? 0 : crTimeout)
                .build();
        // Post请求
        HttpPost post = new HttpPost(url);
        post.setConfig(rc);
        // 响应
        CloseableHttpResponse rsp = null;
        try {
            if (null != headers) {
                for (int i = 0; i < headers.size(); i++) {
                    post.setHeader(headers.get(i).getName(), headers.get(i).getValue());
                }
            }
            String usedCharset = StringUtils.isEmpty(charset) ? "UTF-8" : charset;
            if (null != param && 0 < param.size()) {
                post.setEntity(new UrlEncodedFormEntity(param, usedCharset));
            }
            rsp = client.execute(post);
            HttpEntity eny = rsp.getEntity();
            if (null == eny) {
                rspStr = HTTP_RESP_NONE;
            } else {
                rspStr = EntityUtils.toString(eny, (StringUtils.isEmpty(charset) ? "UTF-8" : charset));
            }
            // 销毁Response体对象
            // 关闭HttpPost
            post.abort();
        } catch (UnsupportedEncodingException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (ClientProtocolException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (IOException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (Exception e) {
            rspStr = HTTP_RESP_ERR;
        } finally {
            // 关闭HttpClient
            try {
                rsp.close();
                client.close();
            } catch (Exception e) {
                rspStr = HTTP_RESP_ERR;
            }
        }
        return rspStr;
    }

    /**
     * 实现SSL Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param body 请求参数
     * @return 响应包体内容字符串
     */
    public static String doSSLPost(String url, List<NameValuePair> headers, String body) {
        return doSSLPost(url, headers, body, null, null, null, null);
    }

    /**
     * 实现SSL Post请求.
     * @param url 请求地址
     * @param body 请求参数
     * @param charset 请求参数编码
     * @return 响应包体内容字符串
     */
    public static String doSSLPost(String url, List<NameValuePair> headers, String body, String charset) {
        return doSSLPost(url, headers, body, null, null, null, charset);
    }

    /**
     * 实现SSL Post请求.
     * @param url 请求地址
     * @param headers Header参数
     * @param body 请求参数
     * @param connTimeout 连接超时设定
     * @param soTimeout 数据传输超时设定
     * @param crTimeout 连接管理器超时设定
     * @param charset 编码
     * @return 响应包体内容字符串
     */
    public static String doSSLPost(String url, List<NameValuePair> headers, String body, Integer connTimeout, Integer soTimeout, Integer crTimeout, String charset) {
        // 响应内容字符串
        String rspStr = null;
        CloseableHttpClient client = null;
        try {
            TrustManager tm = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
                @Override
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
            };
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    return true;
                }
            }).build();
            sslContext.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            client = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException  e) {
            rspStr = HTTP_CONNECT_ERR;
        } catch (NoSuchAlgorithmException e) {
            rspStr = HTTP_CONNECT_ERR;
        } catch (KeyStoreException e) {
            rspStr = HTTP_CONNECT_ERR;
        } catch (Exception  e) {
            rspStr = HTTP_CONNECT_ERR;
        }
        // 设置请求各超时时间
        RequestConfig rc = RequestConfig.custom()
                // 请求连接时间  默认60秒
                .setConnectTimeout(null == connTimeout ? 60000 : connTimeout)
                // 数据传输时间 默认180秒
                .setSocketTimeout(null == soTimeout ? 180000 : soTimeout)
                // 连接管理器超时时间 0:无限;-1:未定义
                .setConnectionRequestTimeout(null == crTimeout ? 0 : crTimeout)
                .build();
        // Post请求
        HttpPost post = new HttpPost(url);
        post.setConfig(rc);
        // 响应
        CloseableHttpResponse rsp = null;
        try {
            if (null != headers) {
                for (int i = 0; i < headers.size(); i++) {
                    post.setHeader(headers.get(i).getName(), headers.get(i).getValue());
                }
            }
            String usedCharset = StringUtils.isEmpty(charset) ? "UTF-8" : charset;
            if (!StringUtils.isEmpty(body)) {
                post.setEntity(new StringEntity(body, usedCharset));
            }
            rsp = client.execute(post);
            HttpEntity eny = rsp.getEntity();
            if (null == eny) {
                rspStr = HTTP_RESP_NONE;
            } else {
                rspStr = EntityUtils.toString(eny, (StringUtils.isEmpty(charset) ? "UTF-8" : charset));
            }
            // 销毁Response体对象
            // 关闭HttpPost
            post.abort();
        } catch (UnsupportedEncodingException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (ClientProtocolException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (IOException e) {
            rspStr = HTTP_RESP_ERR;
        } catch (Exception e) {
            rspStr = HTTP_RESP_ERR;
        } finally {
            // 关闭HttpClient
            try {
                rsp.close();
                client.close();
            } catch (Exception e) {
                rspStr = HTTP_RESP_ERR;
            }
        }
        return rspStr;
    }

    /**
     * 检查https请求返回是否发生异常
     * @param resultStr
     * @return
     */
    public static boolean checkResultHttps(String resultStr){
        boolean result = true;

        if(HTTP_RESP_OK.equals(resultStr)){
            result = false;
        }
        if(HTTP_RESP_ERR.equals(resultStr)){
            result = false;
        }
        if(HTTP_RESP_NONE.equals(resultStr)){
            result = false;
        }
        if(HTTP_CONNECT_ERR.equals(resultStr)){
            result = false;
        }
        return result;
    }
}
