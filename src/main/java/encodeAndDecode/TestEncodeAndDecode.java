package encodeAndDecode;

import Utils.PrintUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author momoubin
 * @date 2020/5/7
 */
public class TestEncodeAndDecode {
	public static void main(String[] args) {
//        URLEncoder.encode()
		String string = "%7B%22resourceType%22%3A%22EhOrganizations%22%2C%22resourceId%22%3A1056921%2C%22requestorUid%22%3A963353%2C%22requestorNickName%22%3A%22%E6%B5%8B%E8%AF%95%E7%94%A8%E6%88%B7%22%2C%22requestorAvatar%22%3A%22cs%3A%2F%2F1%2Fimage%2FaW1hZ2UvTVRveE1tUTFNalUwWkRZeFpUQmlPR016WXpNNU9ERTFORGd4TnpBM09ESmpOUQ%22%2C%22requestorAvatarUrl%22%3A%22http%3A%2F%2Fbeta-cs.zuolin.com%3A80%2Fimage%2FaW1hZ2UvTVRveE1tUTFNalUwWkRZeFpUQmlPR016WXpNNU9ERTFORGd4TnpBM09ESmpOUQ%3FownerType%5Cu003dEhUsers%5Cu0026ownerId%5Cu003d963353%5Cu0026token%5Cu003dfjAi-ViRtHWfe0vjQ0EgmNPmTPu3JaOqdlajIWZ1hSXyt5c3lCGXhW19JFG5afEcje_LMI7geEo_B_IYnzhwymLWinpVpyKbX8LM-KT_M-QlaqRpnTcOrzsWasE5J8FG%5Cu0026pxw%5Cu003d512%5Cu0026pxh%5Cu003d512%22%2C%22requestTime%22%3A1584475443878%2C%22requestInfo%22%3A%22%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95%E5%90%8D%E7%A7%B0%2818232067958%29%28%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95%E9%83%A8%E9%97%A8%29%E7%94%B3%E8%AF%B7%E5%8A%A0%E5%85%A5%E5%85%AC%E5%8F%B8%E2%80%9C%E9%87%91%E9%83%BD%E5%9B%BD%E9%99%85%E5%95%86%E4%B8%9A%E5%9B%AD%E5%8C%BA%E2%80%9D%EF%BC%8C%E6%98%AF%E5%90%A6%E5%90%8C%E6%84%8F%EF%BC%9F%22%2C%22requestId%22%3A2417042%2C%22contactName%22%3A%22%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95%E5%90%8D%E7%A7%B0%22%2C%22contactDescription%22%3A%22%E8%87%AA%E5%8A%A8%E5%8C%96%E6%B5%8B%E8%AF%95%E9%83%A8%E9%97%A8%22%2C%22phoneNo%22%3A%2218232067958%22%2C%22regionCode%22%3A86%2C%22enterpriseManageFlag%22%3A0%2C%22gender%22%3A1%7D&clientHandlerType=0";
		try {
			String decode = URLDecoder.decode(string, "UTF-8");
//            PrintUtils.printObjects(decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String decodeString = "\"{\\\"resourceType\\\":\\\"EhOrganizations\\\",\\\"resourceId\\\":1056921,\\\"requestorUid\\\":963353,\\\"requestorNickName\\\":\\\"测试用户\\\",\\\"requestorAvatar\\\":\\\"cs://1/image/aW1hZ2UvTVRveE1tUTFNalUwWkRZeFpUQmlPR016WXpNNU9ERTFORGd4TnpBM09ESmpOUQ\\\",\\\"requestorAvatarUrl\\\":\\\"http://beta-cs.zuolin.com:80/image/aW1hZ2UvTVRveE1tUTFNalUwWkRZeFpUQmlPR016WXpNNU9ERTFORGd4TnpBM09ESmpOUQ?ownerType\\\\u003dEhUsers\\\\u0026ownerId\\\\u003d963353\\\\u0026token\\\\u003dfjAi-ViRtHWfe0vjQ0EgmNPmTPu3JaOqdlajIWZ1hSXyt5c3lCGXhW19JFG5afEcje_LMI7geEo_B_IYnzhwymLWinpVpyKbX8LM-KT_M-QlaqRpnTcOrzsWasE5J8FG\\\\u0026pxw\\\\u003d512\\\\u0026pxh\\\\u003d512\\\",\\\"requestTime\\\":1584475443878,\\\"requestInfo\\\":\\\"自动化测试名称(18232067958)(自动化测试部门)申请加入公司“金都国际商业园区”，是否同意？\\\",\\\"requestId\\\":2417042,\\\"contactName\\\":\\\"自动化测试名称\\\",\\\"contactDescription\\\":\\\"自动化测试部门\\\",\\\"phoneNo\\\":\\\"18232067958\\\",\\\"regionCode\\\":86,\\\"enterpriseManageFlag\\\":0,\\\"gender\\\":1}&clientHandlerType=0\",\\\"url\\\":\\\"xxx\\\"";
		try {
			String decode = URLDecoder.decode(decodeString, "UTF-8");
			PrintUtils.printObjects(decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
