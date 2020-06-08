package freemarker.test;

import com.alibaba.fastjson.JSON;
import freemarker.FreeMarkerTemplateUtils;
import freemarker.FreemarkerTemplate;
import freemarker.bean.AppSuite;
import freemarker.template.AdaptorUtils;
import freemarker.template.LogTemplate;
import freemarker.template.Template;

import java.util.HashMap;

/**
 * @author moubin.mo
 * @date: 2020/6/6 17:13
 */

public class TestUpdateFormater {
	public static void main(String[] args) {
		HashMap data = new HashMap();
		AppSuite fromObject = new AppSuite();
		fromObject.setName("aa");
		fromObject.setDescription("aa-description");
		AppSuite toObject = new AppSuite();
		toObject.setName("bb");
		toObject.setDescription("bb-description");

		LogTemplate template = JSON.parseObject(FreemarkerTemplate.TEMPLATE, LogTemplate.class);
		AdaptorUtils.handleDataMap(template.getDataObject(), fromObject, toObject, data);

		try {
			Template freeMarkerTemplate = null;
			freeMarkerTemplate = new Template("key", AdaptorUtils.getTemplateSourceCode(null, FreemarkerTemplate.TEMPLATE_WITH_DOUBLE_OBJECTS_COMPARISON), TemplateConfigurationFactory.getConfiguration());
			if (freeMarkerTemplate != null) {
				String content = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerTemplate, data);
				System.out.println(content);
			}
		} catch(Exception e) {
		}
	}
}
