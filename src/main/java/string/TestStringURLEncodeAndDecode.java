package string;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author moubin.mo
 * @date: 2019/12/2 11:07
 */
@Slf4j
public class TestStringURLEncodeAndDecode {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestStringURLEncodeAndDecode.class);

	public static void main(String[] args) throws UnsupportedEncodingException {
		String string = "metaObject=%7B%22resourceType%22%3A%22EhOrganizations%22%2C%22resourceId%22%3A1045956%2C%22requestorUid%22%3A505361%2C%22requestorNickName%22%3A%22R%22%2C%22requestorAvatar%22%3A%22cs%3A%2F%2F1%2Fimage%2FaW1hZ2UvTVRvNU5tSXpZVE13T0RGaE16ZG1ZMlUxWXpneFlqa3hNMkV4T1dWaFltSTJaUQ%22%2C%22requestorAvatarUrl%22%3A%22http%3A%2F%2F10.1.120.92%3A5065%2Fimage%2FaW1hZ2UvTVRvNU5tSXpZVE13T0RGaE16ZG1ZMlUxWXpneFlqa3hNMkV4T1dWaFltSTJaUQ%3FownerType%5Cu003dEhUsers%5Cu0026ownerId%5Cu003d505361%5Cu0026token%5Cu003dd1tIJMg1EsLGI1BTNGhU9bwtPLtyPOFqvRvHYkhmcvuVxpnRTR9rcOO6H6yo0ohZje_LMI7geEo_B_IYnzhwypOZNYGZz9xI5OqCfsnhC6IKd_KZ-k2LYKt2x-X0f3tw%5Cu0026pxw%5Cu003d132%5Cu0026pxh%5Cu003d132%22%2C%22requestTime%22%3A1590578066738%2C%22requestInfo%22%3A%22test%E9%83%A8%E9%97%A8departmentInfo%2812000001802%29%28%E4%B8%80%E9%94%AE%E6%8E%A8%E9%80%81%E4%BC%81%E4%B8%9A002%29%E7%94%B3%E8%AF%B7%E5%8A%A0%E5%85%A5%E5%85%AC%E5%8F%B8%E2%80%9C%E4%B8%80%E9%94%AE%E6%8E%A8%E9%80%81%E4%BC%81%E4%B8%9A002%E2%80%9D%EF%BC%8C%E6%98%AF%E5%90%A6%E5%90%8C%E6%84%8F%EF%BC%9F%22%2C%22requestId%22%3A2205892%2C%22contactName%22%3A%22test%E9%83%A8%E9%97%A8departmentInfo%22%2C%22contactDescription%22%3A%22%E4%B8%80%E9%94%AE%E6%8E%A8%E9%80%81%E4%BC%81%E4%B8%9A002%22%2C%22phoneNo%22%3A%2212000001802%22%2C%22regionCode%22%3A86%2C%22enterpriseManageFlag%22%3A0%2C%22gender%22%3A1%2C%22departmentId%22%3A1045958%2C%22departmentName%22%3A%22%E4%B8%80%E9%94%AE%E6%8E%A8%E9%80%81%E4%BC%81%E4%B8%9A002%22%2C%22departmentInfo%22%3A%5B%7B%22departmentId%22%3A1045958%2C%22departmentName%22%3A%22%E4%B8%80%E9%94%AE%E6%8E%A8%E9%80%81%E4%BC%81%E4%B8%9A002%22%7D%5D%7D";
		String[] data = string.split("metaObject=");
		String decodeString = URLDecoder.decode(data[1], "UTF-8");
		// 解密后字符串：{"resourceType":"EhOrganizations","resourceId":1045660,"requestorUid":550618,"requestorNickName":"用户昵称test用户昵称test","requestorAvatar":"cs://1/image/aW1hZ2UvTVRvME1ESTBaV0kwTmpNNE9UYzFZemcwT1RNNE1USTFaR1U0WVRZMU1qQTBNZw","requestorAvatarUrl":"http://10.1.120.92:5066/image/aW1hZ2UvTVRvME1ESTBaV0kwTmpNNE9UYzFZemcwT1RNNE1USTFaR1U0WVRZMU1qQTBNZw?ownerType\u003dEhUsers\u0026ownerId\u003d550618\u0026token\u003dXHNbG9PR1dfkUF9-JJP0-TNBmSt49BhNX7CEEafXGLVGBlqR0Ic3-od-Zr0qt90Lje_LMI7geEo_B_IYnzhwykWCQAJZmpIcWflAdiYE1Tzh7-mfDgypKu8YiiYPffck\u0026pxw\u003d0\u0026pxh\u003d0","requestTime":1553168062236,"requestInfo":"常睿(18899855862)申请加入公司“左邻永佳”，是否同意？","requestId":18,"contactName":"常睿","phoneNo":"18899855862","regionCode":86,"enterpriseManageFlag":0}&clientHandlerType=0


		System.out.println(decodeString);

		String substring = decodeString.substring(decodeString.indexOf("{"), decodeString.lastIndexOf("}") + 1);

		System.out.println(substring);

	}
}

