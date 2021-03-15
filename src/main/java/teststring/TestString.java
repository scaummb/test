package teststring;

import Utils.PrintUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author momoubin
 * @date 2020/5/9
 */
public class TestString {
	public static void main(String[] args) {
		String routerUrl = "zl://enterprise/member-apply？url=http%3A%2F%2Fgonggdev2.zuolin.com%2Fuser-identification%2Fbuild%2Findex.html%23%2FenterpriseApply%3FuserId%3D550500%26namepaceId%3D11%26requestId%3D5&clientHandlerType=2";
		// 新版本的认证消息（带url）
		try {
			String[] data = routerUrl.split("url=");
			String decodeString = URLDecoder.decode(data[1], "UTF-8");
//            PrintUtils.printObjects(decodeString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String aa = "zl://enterprise/member-apply?url=http%3A%2F%2Fgonggdev2.zuolin.com%2Fuser-identification%2Fbuild%2Findex.html%23%2FenterpriseApply%3FuserId%3D550500%26namepaceId%3D11%26requestId%3D9%23sign_suffix&clientHandlerType=2";
		try {
			String decode = URLDecoder.decode(aa, "utf-8");
			PrintUtils.printObjects(decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
