package cn.datai.puer.promotion.website.framework.system;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by zhangyutao on 2016/8/24.
 */
@Component
public class ParamInitializer {

    private Logger logger = LoggerFactory.getLogger(ParamInitializer.class);

    @Resource(name = "initProperties")
    private Properties properties;

    @Autowired
    private ServletContext servletContext;

    @PostConstruct
    public void init(){
        Enumeration<?> propertyNames = this.properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String propertyName = (String)propertyNames.nextElement();
            String propertyValue = properties.getProperty(propertyName);
            servletContext.setAttribute(toCamelCase(propertyName, true), propertyValue);
            logger.info("设置系统参数:{} ------[{}]", toCamelCase(propertyName, true), propertyValue);
        }
        String imgPath = properties.getProperty("img.path");
        if(StringUtils.isEmpty(imgPath)){
            imgPath = servletContext.getContextPath();
        }
        servletContext.setAttribute("imgPath",imgPath);
        logger.info("设置静态资源的路径:{}", imgPath);
    }

    private String toCamelCase(String value, boolean startWithLowerCase) {
        value = StringUtils.replaceEachRepeatedly(value, new String[]{".", "-"}, new String[]{"_", "_"});
        String[] strings = StringUtils.split(value, "_");
        for (int i = startWithLowerCase ? 1 : 0; i < strings.length; i++){
            strings[i] = StringUtils.capitalize(strings[i]);
        }
        return StringUtils.join(strings);
    }

}
