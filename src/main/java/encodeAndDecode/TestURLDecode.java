package encodeAndDecode;

import Utils.PrintUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author momoubin
 * @date 2020/5/10
 */
public class TestURLDecode {
	public static void main(String[] args) {
		String url = "url=http%3A%2F%2Fgonggdev2.zuolin.com%2Fuser-identification%2Fbuild%2Findex.html%23%2FenterpriseApply%3FuserId%3D550500%26namepaceId%3D11%26requestId%3D9%23sign_suffix";
		String url2 = "url=http%3A%2F%2Fgonggdev2.zuolin.com%2Fuser-identification%2Fbuild%2Findex.html%23%2FenterpriseApply%3FuserId%3D550500%26namepaceId%3D11%26requestId%3D8%23sign_suffix";
		String metaObject1 = "metaObject=%7B%22resourceType%22%3A%22EhOrganizations%22%2C%22resourceId%22%3A1047285%2C%22requestorUid%22%3A550500%2C%22requestorNickName%22%3A%22%E5%B1%B1%E6%B5%B7%E4%BE%9D%E6%97%A7%22%2C%22requestorAvatar%22%3A%22cs%3A%2F%2F1%2Fimage%2FaW1hZ2UvTVRvMFlqSXlaV0kwTkRjd01qaGhNV1UyTkRWbU5tVTNNakEwT0RnME5XUmlOUQ%22%2C%22requestorAvatarUrl%22%3A%22http%3A%2F%2F10.1.120.92%3A5065%2Fimage%2FaW1hZ2UvTVRvMFlqSXlaV0kwTkRjd01qaGhNV1UyTkRWbU5tVTNNakEwT0RnME5XUmlOUQ%3FownerType%5Cu003dEhUsers%5Cu0026ownerId%5Cu003d550500%5Cu0026token%5Cu003dbK2KmlsBAUIh82e23kepmlmrVh3ngKGpkv5aEOoxYqAaz2OSp13tu0HC9RYih-SEJ7uosgA3tPL6PNE9lh4u2M_FJtPvh3xrWARJS4qjl7E7AQaRlTtG1dfNzMTsm3Tb%5Cu0026pxw%5Cu003d132%5Cu0026pxh%5Cu003d132%22%2C%22requestTime%22%3A1588952694340%2C%22requestInfo%22%3A%22%E5%B1%B1%E6%B5%B7%E4%BE%9D%E6%97%A7%2818819467607%29%E7%94%B3%E8%AF%B7%E5%8A%A0%E5%85%A5%E5%85%AC%E5%8F%B8%E2%80%9C%E9%BB%98%E8%AE%A4%E5%AE%89%E8%A3%85%E5%BA%94%E7%94%A8%E5%85%AC%E5%8F%B8%E4%B9%8BA3%E2%80%9D%EF%BC%8C%E6%98%AF%E5%90%A6%E5%90%8C%E6%84%8F%EF%BC%9F%22%2C%22requestId%22%3A2205409%2C%22contactName%22%3A%22%E5%B1%B1%E6%B5%B7%E4%BE%9D%E6%97%A7%22%2C%22phoneNo%22%3A%2218819467607%22%2C%22regionCode%22%3A86%2C%22enterpriseManageFlag%22%3A0%2C%22gender%22%3A1%7D";
		String metaObject2 = "metaObject=%7B%22resourceType%22%3A%22EhOrganizations%22%2C%22resourceId%22%3A1047285%2C%22requestorUid%22%3A550500%2C%22requestorNickName%22%3A%22%E5%B1%B1%E6%B5%B7%E4%BE%9D%E6%97%A7%22%2C%22requestorAvatar%22%3A%22cs%3A%2F%2F1%2Fimage%2FaW1hZ2UvTVRvMFlqSXlaV0kwTkRjd01qaGhNV1UyTkRWbU5tVTNNakEwT0RnME5XUmlOUQ%22%2C%22requestorAvatarUrl%22%3A%22http%3A%2F%2F10.1.120.92%3A5065%2Fimage%2FaW1hZ2UvTVRvMFlqSXlaV0kwTkRjd01qaGhNV1UyTkRWbU5tVTNNakEwT0RnME5XUmlOUQ%3FownerType%5Cu003dEhUsers%5Cu0026ownerId%5Cu003d550500%5Cu0026token%5Cu003dbK2KmlsBAUIh82e23kepmlmrVh3ngKGpkv5aEOoxYqAaz2OSp13tu0HC9RYih-SEJ7uosgA3tPL6PNE9lh4u2M_FJtPvh3xrWARJS4qjl7E7AQaRlTtG1dfNzMTsm3Tb%5Cu0026pxw%5Cu003d132%5Cu0026pxh%5Cu003d132%22%2C%22requestTime%22%3A1588952694340%2C%22requestInfo%22%3A%22%E5%B1%B1%E6%B5%B7%E4%BE%9D%E6%97%A7%2818819467607%29%E7%94%B3%E8%AF%B7%E5%8A%A0%E5%85%A5%E5%85%AC%E5%8F%B8%E2%80%9C%E9%BB%98%E8%AE%A4%E5%AE%89%E8%A3%85%E5%BA%94%E7%94%A8%E5%85%AC%E5%8F%B8%E4%B9%8BA3%E2%80%9D%EF%BC%8C%E6%98%AF%E5%90%A6%E5%90%8C%E6%84%8F%EF%BC%9F%22%2C%22requestId%22%3A2205409%2C%22contactName%22%3A%22%E5%B1%B1%E6%B5%B7%E4%BE%9D%E6%97%A7%22%2C%22phoneNo%22%3A%2218819467607%22%2C%22regionCode%22%3A86%2C%22enterpriseManageFlag%22%3A0%2C%22gender%22%3A1%7D";
		try {
			String decode = URLDecoder.decode(url2, "UTF-8");
			PrintUtils.printObjects(decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
