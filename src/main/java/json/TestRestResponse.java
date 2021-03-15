package json;

import com.alibaba.fastjson.JSONObject;
import json.response.ListHelpCenterDocumentsByModuleIdResponse;
import json.response.ListParticularHelpCenterDocumentsResponse;
import json.response.ModuleDocumentFlagResponse;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2020/4/17 16:36
 */

public class TestRestResponse {
	public static void main(String[] args) {
		String response1 = TestRestResponseConstants.RESPONSE_GET_MODULE_HELP_DOCUMENTS;
		parseResponseToPojo(response1, ModuleDocumentFlagResponse.class);
		String response2 = TestRestResponseConstants.RESPONSE_LIST_HELP_CENTERDOCUMENTS_BY_MODULE_ID;
		parseResponseToPojo(response2, ListHelpCenterDocumentsByModuleIdResponse.class);
		String response = TestRestResponseConstants.RESPONSE_LIST_PARTICULAR_HELP_CENTER_DOCUMENTS;
		parseResponseToPojo(response, ListParticularHelpCenterDocumentsResponse.class);
	}

	private static void parseResponseToPojo(String response, Class<?> objectClassName) {
		Map<String, Object> jsonmap = JSONObject.parseObject(response);
		if (!CollectionUtils.isEmpty(jsonmap)) {
			JSONObject responseJsonObject = (JSONObject) jsonmap.get("response");
			try {
				Object object = JSONObject.toJavaObject(responseJsonObject, objectClassName);
				System.out.println(object);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void testlistParticularHelpCenterDocuments() {
		Map<String, Object> jsonmap = JSONObject.parseObject(TestRestResponseConstants.RESPONSE_LIST_PARTICULAR_HELP_CENTER_DOCUMENTS);
		if (!CollectionUtils.isEmpty(jsonmap)) {
			JSONObject response = (JSONObject) jsonmap.get("response");
			try {
				ListParticularHelpCenterDocumentsResponse result = JSONObject.toJavaObject(response, ListParticularHelpCenterDocumentsResponse.class);
				System.out.println(result);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void testlistHelpCenterDocumentsByModuleId() {
		Map<String, Object> jsonmap = JSONObject.parseObject(TestRestResponseConstants.RESPONSE_LIST_HELP_CENTERDOCUMENTS_BY_MODULE_ID);
		if (!CollectionUtils.isEmpty(jsonmap)) {
			JSONObject response = (JSONObject) jsonmap.get("response");
			try {
				ListHelpCenterDocumentsByModuleIdResponse result = JSONObject.toJavaObject(response, ListHelpCenterDocumentsByModuleIdResponse.class);
				System.out.println(result);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void testgetModuleHelpDocuments() {
		Map<String, Object> jsonmap = JSONObject.parseObject(TestRestResponseConstants.RESPONSE_GET_MODULE_HELP_DOCUMENTS);
		if (!CollectionUtils.isEmpty(jsonmap)) {
			JSONObject response = (JSONObject) jsonmap.get("response");
			try {
				ModuleDocumentFlagResponse result = JSONObject.toJavaObject(response, ModuleDocumentFlagResponse.class);
				System.out.println(result);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
