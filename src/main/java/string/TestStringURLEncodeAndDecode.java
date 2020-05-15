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
		String string = "zl://enterprise/member-apply?\n" +
				"\n" +
				"metaObject=%7B%22resourceType%22%3A%22EhOrganizations%22%2C%22resourceId%22%3A1046267%2C%22requestorUid%22%3A550803%2C%22requestorNickName%22%3A%22%E7%A5%9E%E5%B0%8F%E6%B8%A3%22%2C%22requestorAvatar%22%3A%22cs%3A%2F%2F1%2Fimage%2FaW1hZ2UvTVRvME1ESTBaV0kwTmpNNE9UYzFZemcwT1RNNE1USTFaR1U0WVRZMU1qQTBNZw%22%2C%22requestorAvatarUrl%22%3A%22http%3A%2F%2F10.1.120.65%3A5000%2Fimage%2FaW1hZ2UvTVRvME1ESTBaV0kwTmpNNE9UYzFZemcwT1RNNE1USTFaR1U0WVRZMU1qQTBNZw%3FownerType%5Cu003dEhUsers%5Cu0026ownerId%5Cu003d550803%5Cu0026token%5Cu003dbZlMleT6J_8XO9AGVGiymdt0xmlEmSODgX6j-zD0rU4QIpwhYJx_hFhzd3CaAtAUJ7uosgA3tPL6PNE9lh4u2Ctyme7inCL4xolViUh2Cfg86CodLBHL-QxeLqVe4LFM%22%2C%22requestTime%22%3A1589430330099%2C%22requestInfo%22%3A%2223123123%2816800000024%29%E7%94%B3%E8%AF%B7%E5%8A%A0%E5%85%A5%E5%85%AC%E5%8F%B8%E2%80%9C%E6%B5%8B%E8%AF%951234%E2%80%9D%EF%BC%8C%E6%98%AF%E5%90%A6%E5%90%8C%E6%84%8F%EF%BC%9F%22%2C%22requestId%22%3A2200386%2C%22contactName%22%3A%2223123123%22%2C%22phoneNo%22%3A%2216800000024%22%2C%22regionCode%22%3A86%2C%22enterpriseManageFlag%22%3A0%2C%22gender%22%3A1%7D\",\n";
		String[] data = string.split("metaObject=");
		String decodeString = URLDecoder.decode(data[1], "UTF-8");
		// 解密后字符串：{"resourceType":"EhOrganizations","resourceId":1045660,"requestorUid":550618,"requestorNickName":"用户昵称test用户昵称test","requestorAvatar":"cs://1/image/aW1hZ2UvTVRvME1ESTBaV0kwTmpNNE9UYzFZemcwT1RNNE1USTFaR1U0WVRZMU1qQTBNZw","requestorAvatarUrl":"http://10.1.120.92:5066/image/aW1hZ2UvTVRvME1ESTBaV0kwTmpNNE9UYzFZemcwT1RNNE1USTFaR1U0WVRZMU1qQTBNZw?ownerType\u003dEhUsers\u0026ownerId\u003d550618\u0026token\u003dXHNbG9PR1dfkUF9-JJP0-TNBmSt49BhNX7CEEafXGLVGBlqR0Ic3-od-Zr0qt90Lje_LMI7geEo_B_IYnzhwykWCQAJZmpIcWflAdiYE1Tzh7-mfDgypKu8YiiYPffck\u0026pxw\u003d0\u0026pxh\u003d0","requestTime":1553168062236,"requestInfo":"常睿(18899855862)申请加入公司“左邻永佳”，是否同意？","requestId":18,"contactName":"常睿","phoneNo":"18899855862","regionCode":86,"enterpriseManageFlag":0}&clientHandlerType=0



		System.out.print(decodeString);

	}
}

