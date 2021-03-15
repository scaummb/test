package sso;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * @author moubin.mo
 * @date: 2020/11/19 10:03
 */

public class SSODemo {
	static String URL_GET_AUTHORIZATION_CODE = "https://evh/oauth2/authorize?response_type=code&client_id=%s&redirect_uri=%s&scope=basic&state=%s#oauth2_redirect";
	static String URL_GET_AUTHORIZATION_ACCESS_TOKEN = "http://evh/oauth2/token";
	static String URL_GET_AUTHORIZATION_USER_INFO = "http://evh/oauth2api/trd/userInfo";

	private final static String appKey = "6d00f9de-06c4-417d-9c5f-923dcb52ae09";
	private final static String secretKey = "ra9VSteycacFGmbRrB/w3waO/AnTX4svgYNHNOF1l6EYnFN5JQp2HY11JknirgYJWLF6pI8L+VC+zECIX6Xftg==";

	public static void main(String[] args) throws IOException {
		//第一步：获取授权码code
		String client_id = appKey;
		String url = "http://www.baidu.com"; //第三方H5页面
		String state = "zhiwei";//所填内容，客户端跳转原封不动返回给第三方H5页面的数据(有需要就用)
		String getUrl = String.format(URL_GET_AUTHORIZATION_CODE, client_id, URLEncoder.encode(url, "utf-8"), state);
		CloseableHttpClient httpclient = getHttplient();
		HttpGet httpGet = getHttpGet(getUrl);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		int status = response.getStatusLine().getStatusCode();
		String code = null; //授权码code
		if (status == 200) {
			//响应处理
			HttpEntity entity = response.getEntity();
			String entities = EntityUtils.toString(entity, "UTF-8");
			HashMap entitiesMap = (HashMap) fromJsonString(entities, HashMap.class);
			code = (String) entitiesMap.get("code");
		}


		//第二步：获取令牌 accessToken
		HttpPost httpPost = getHttpPost(URL_GET_AUTHORIZATION_ACCESS_TOKEN);
		String grant_type = "authorization_code";
		String redirect_uri = url;
		String authorization = "***"; //请求头的计算⽅式为：Basic + 空格 + appKey 和 secretKey ⽤冒号连接后 base64 的字符串
		MultipartEntityBuilder entityBuilder = buildHttpMultipartEntityBuilder(grant_type, code, redirect_uri, client_id);
		httpPost.setEntity(entityBuilder.build());
		httpPost.setHeader("Authorization", authorization);
		CloseableHttpResponse response1 = httpclient.execute(httpPost);
		String accessToken = null; //令牌
		if (status == 200) {
			//响应处理
			HttpEntity entity = response.getEntity();
			String entities = EntityUtils.toString(entity, "UTF-8");
			HashMap entitiesMap = (HashMap) fromJsonString(entities, HashMap.class);
			accessToken = (String) entitiesMap.get("access_token");
		}

		//第三步：获取登陆用户uid
		String contentType2 = "application/x-www-form-urlencoded";
		String authorization2 = "***"; //请求头的计算⽅式为：Bearer + 空格 + 将 access_token 进⾏ base64 后的字符串
		HttpGet httpGet2 = getHttpGet(URL_GET_AUTHORIZATION_USER_INFO);
		httpGet2.setHeader("Content-Type", contentType2);
		httpGet2.setHeader("Authorization", authorization2);
		CloseableHttpResponse response2 = httpclient.execute(httpGet2);
		UserInfo UserInfo = null;
		Long userId = null; //用户uid
		if (status == 200) {
			//响应处理
			HttpEntity entity = response.getEntity();
			String entities = EntityUtils.toString(entity, "UTF-8");
			HashMap entitiesMap = (HashMap) fromJsonString(entities, HashMap.class);
			String userInfoString = (String) entitiesMap.get("response");
			UserInfo userInfo = (SSODemo.UserInfo) fromJsonString(userInfoString, UserInfo.getClass());
			userId = userInfo.getId();
		}

		//....
	}

	class UserInfo {
		private Long id;
		private String phone;
		private String regionCode;
		private String accountName;
		private String nickName;
		private String avatarUrl;
		private String birthday;
		private String gender;

		public Long getId() {
			return id;
		}
	}

	private static MultipartEntityBuilder buildHttpMultipartEntityBuilder(String grant_type, String code, String redirect_uri, String client_id) throws UnsupportedEncodingException {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setContentType(ContentType.MULTIPART_FORM_DATA);
		builder.setCharset(Charset.forName("UTF-8"));
		builder.addTextBody("grant_type", grant_type);
		builder.addTextBody("code", code);
		builder.addTextBody("redirect_uri", URLEncoder.encode(redirect_uri, "utf-8"));
		builder.addTextBody("client_id", client_id);
		return builder;
	}

	/**
	 * <p>初始化HttpGet的请求头属性</p>
	 */
	private static HttpGet getHttpGet(String businessUrl) {
		HttpGet httpGet = new HttpGet(businessUrl);
		return httpGet;
	}

	/**
	 * <p>请求客户端</p>
	 */
	private static CloseableHttpClient getHttplient() {
		//请求构造
		CloseableHttpClient httpclient = HttpUtils.getHttpClient(10000);
		return httpclient;
	}

	/**
	 * <p>初始化HttpPost的请求头属性</p>
	 */
	private static HttpPost getHttpPost(String businessUrl) {
		HttpPost httpPost = new HttpPost(businessUrl);
		return httpPost;
	}

	/**
	 * <p>Json字符串转为对象</p>
	 */
	public static Object fromJsonString(String jsonString, Class<?> clz) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, clz);
	}

}
