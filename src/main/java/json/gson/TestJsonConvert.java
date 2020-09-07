package json.gson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/9/7 01:05
 */

public class TestJsonConvert {
	public static void main(String[] args) {
		test3();
	}

	private static void test3() {
//		String test = "{\"field1\":\"测试企业2\",\"field3\":\"测试企业1\",\"field2\":\"左邻\"}";
		String test = "";
		System.out.println(getValue(test));
	}

	private static String getValue(String test) {
		Gson gson = new Gson();
		Map fieldValueMap = gson.fromJson(test, Map.class);
		return String.valueOf(fieldValueMap.values());
	}

	private static void test2() {
		//描述
		HashMap<String, Object> map = new HashMap<String, Object>(){{put("userName", "root");}};
		Gson gson = new Gson();
		String s = gson.toJson(map);
		System.out.println(s);

		String s1 = JSONObject.toJSONString(map);
		System.out.println("输出的结果是：" + s1);

		String s2 = org.json.simple.JSONObject.toJSONString(map);
		System.out.println("输出的结果是：" + s2);
	}

	private static void test1() {
		String test = "{ \"dataObject\" :{ \"fields\" :[ { \"display_name\" : \"字符串类型\",\n" +
				" \"field_name\" : \"string\", \"display_mode\":\"2\" }, { \"display_name\" : \"字符串列表类型\",\n" +
				" \"field_name\" : \"stringList\", \"display_mode\":\"2\"  }, { \"display_name\" : \"字符串键值对类型\",\n" +
				" \"field_name\" : \"stringStringMap\", \"display_mode\":\"2\"   }]}}";
		LogTemplate2 template = JSON.parseObject(test, LogTemplate2.class);
		System.out.println(template);
	}
}
class LogTemplate2 {
	private String description;
	private LogTemplateObject2 dataObject;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LogTemplateObject2 getDataObject() {
		return dataObject;
	}

	public void setDataObject(LogTemplateObject2 dataObject) {
		this.dataObject = dataObject;
	}
}

class LogTemplateObject2 {
	private List<LogTemplateObjectField2> fields;

	public List<LogTemplateObjectField2> getFields() {
		return fields;
	}

	public void setFields(List<LogTemplateObjectField2> fields) {
		this.fields = fields;
	}
}



class LogTemplateObjectField2 {
	private String display_name;
	private String field_name;
	private String fieldValue;
	private Byte display_mode;

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public Byte getDisplay_mode() {
		return display_mode;
	}

	public void setDisplay_mode(Byte display_mode) {
		this.display_mode = display_mode;
	}
}
