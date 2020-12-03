package url.urlbuild;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import sso.HttpUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;

/**
 * @author moubin.mo
 * @date: 2020/11/27 10:08
 */

public class TestUrlBuild {
	private final static String appKey = "49ba4da8-75b0-4f0a-83b3-e9574c9ae8c6";
	private final static String secreatKey = "KwVMyXiuq3G0bfP8jJTVTxlXF9PWaUEUwAj6orJy++Lc1DE42CLfIV8Dof3Soz4jG0bqOzzAG0/6tZF7D6uhxw==";

	public static void main(String[] args) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;

		String businessUrl = "http://116.239.33.45:6062/qrCodes/getUserQrCode?systemId=1&qrType=1";
		try {
			//请求构造
			httpclient = HttpUtils.getHttpClient(10000);
			HttpPost httpPost = buildHttpPost(businessUrl);
			MultipartEntityBuilder builder = buildHttpMultipartEntityBuilder(123L, appKey, secreatKey);
			httpPost.setEntity(builder.build());
			//请求发起
			response = httpclient.execute(httpPost);
			int status = response.getStatusLine().getStatusCode();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	/**
	 * <p>初始化HttpPost的请求头属性</p>
	 */
	private static HttpPost buildHttpPost(String businessUrl) {
		HttpPost httpPost = new HttpPost(businessUrl);
		return httpPost;
	}


	/**
	 * <p>初始化 StringEntity，补充请求业务参数与签名</p>
	 * @param userId
	 * @param appKey
	 * @param secreatKey
	 * @return MultipartEntityBuilder
	 * @see MultipartEntityBuilder
	 */
	private static MultipartEntityBuilder buildHttpMultipartEntityBuilder(Long userId, String appKey, String secreatKey) throws UnsupportedEncodingException {

		long timeMillis = System.currentTimeMillis();
		int nonce = new Random().nextInt(Integer.MAX_VALUE);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setContentType(ContentType.MULTIPART_FORM_DATA);
		builder.setCharset(Charset.forName("UTF-8"));
		builder.addTextBody("userId",  userId.toString());
		builder.addTextBody("appKey", appKey);
		builder.addTextBody("timestamp", String.valueOf(timeMillis));
		builder.addTextBody("nonce", String.valueOf(nonce));
		HashMap hashMap = new HashMap();
		hashMap.put("userId", userId.toString());
		hashMap.put("appKey", appKey);
		hashMap.put("timestamp", String.valueOf(timeMillis));
		hashMap.put("nonce", String.valueOf(nonce));
		builder.addTextBody("signature", SignatureUtil.computeSignature(hashMap, secreatKey));
		return builder;
	}

}
