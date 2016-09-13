package cn.datai.puer.promotion.website.utils.sms;

import com.alibaba.fastjson.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {
	private static String PROCESS_PROPERTIES = "process.properties";

	static private String value = null;

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

	synchronized static public void loads(String key){
		InputStream in = null;
		Properties properties = new Properties();
		try {
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(PROCESS_PROPERTIES);
			properties.load(in);
			value = properties.getProperty(key);

		} catch (IOException e) {
			logger.error("抽取数据出错，可能会导致定时任务运行时，不能正常抽取相应数据，请检查邮件配置文件【"+PROCESS_PROPERTIES+"】",e);
		}finally {
			IOUtils.close(in);
		}
	}
	public static String getValue(String key) {
		loads(key);
		return value;
	}

}
