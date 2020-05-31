package freemarker;

import com.alibaba.fastjson.JSON;
import freemarker.bean.Zones;
import freemarker.template.AdaptorUtils;
import freemarker.template.LogTemplate;
import freemarker.template.LogTemplateObject;
import freemarker.template.LogTemplateObjectField;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/5/31 21:37
 */

public class Test {
	public static void main(String[] args) {
		LogTemplateObject fromObject = new LogTemplateObject();
		LogTemplateObject toObject = new LogTemplateObject();
		LogTemplateObjectField nameField = new LogTemplateObjectField();
		nameField.setField("name");
		nameField.setPrefixText("Zone名称");
		LogTemplateObjectField expireTimeField = new LogTemplateObjectField();
		expireTimeField.setField("licenseEndDate");
		expireTimeField.setPrefixText("Zone有效期");
		List<LogTemplateObjectField> fromObjectFields = new ArrayList(){{
			add(nameField);
			add(expireTimeField);
		}};
		List<LogTemplateObjectField> toObjectFields = new ArrayList(){{
			add(nameField);
			add(expireTimeField);
		}};
		fromObject.setFields(fromObjectFields);
		toObject.setFields(toObjectFields);
		Map<String, LogTemplateObject> data = new HashMap<>();
		data.putIfAbsent("fromObject", fromObject);
		data.putIfAbsent("toObject", toObject);

		LogTemplate logTemplate = new LogTemplate();
		logTemplate.setDescription("编辑了“${name}”的信息");
		logTemplate.setData(data);

		System.out.println(JSON.toJSON(logTemplate));

		// 校验
		Zones zones = new Zones();
		zones.setName("he1");
		zones.setLicenseEndDate(new Timestamp(1590847662000L));
		Zones newzones = new Zones();
		newzones.setName("he2");
		newzones.setLicenseEndDate(new Timestamp(1585577262000L));
		HashMap hashMap = new HashMap(){{put("fromObject", zones);put("toObject", newzones);}};
		AdaptorUtils.handleDataMap(logTemplate.getData(), zones, newzones, hashMap);
		System.out.println(JSON.toJSON(logTemplate.getData()));
	}


}
