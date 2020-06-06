package freemarker.test;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

/**
 * @author moubin.mo
 * @date: 2020/6/6 17:19
 */

public class TemplateConfigurationFactory {
	private final static HashMap<String, Configuration> map = new HashMap();
	private final static String DEFAULT_CONFIGURAION = "DEFAULT_CONFIGURATION";

	public Configuration templateConfig;

	public static Configuration getConfiguration(){
		if (ObjectUtils.isEmpty(map.get(DEFAULT_CONFIGURAION))){
			Configuration templateConfig = new Configuration();
			templateConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
			templateConfig.setTemplateLoader(new StringTemplateLoader());
			templateConfig.setTemplateUpdateDelay(0);
			map.putIfAbsent(DEFAULT_CONFIGURAION, templateConfig);
		}
		return map.get(DEFAULT_CONFIGURAION);
	}
}
