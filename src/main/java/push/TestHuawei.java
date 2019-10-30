package push;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author moubin.mo
 * @date: 2019/10/30 15:46
 */
public class TestHuawei {

	private final static Logger LOGGER = LoggerFactory.getLogger(TestHuawei.class);

	private static String tokenUrl = "https://login.vmall.com/oauth2/token"; //获取认证Token的URL
	private static String apiUrl = "https://api.push.hicloud.com/pushsend.do"; //应用级消息下发API

	private static String tokenUrl_v2 = "https://login.cloud.huawei.com/oauth2/v2/token";
	private static String apiUrl_v2 = "https://push-api.cloud.huawei.com/v1/{0}/messages:send";

	private static String appId = "100691289";
	private static String appSecret = "8b3e887d5228ca92538033eb9e7208dd";
	private static String appPkgName = "com.everhomes.android.yinchuanzhongguancun";
	private static String accessToken;     //下发通知消息的认证Token
	private static long tokenExpiredTime = 0;  //accessToken的过期时间
	private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final static CloseableHttpClient httpClient = HttpClients.createDefault();


	public static void main(String[] args) throws IOException {
		try {
			refreshToken();
			refreshTokenV2();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private static String refreshTokenV2() throws IOException {
		String requestBody = createRequestBody(appId, appSecret);

		HttpPost httpPost = new HttpPost(tokenUrl_v2);
		StringEntity entity = new StringEntity(requestBody);
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		String jsonStr = EntityUtils.toString(response.getEntity());
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			accessToken = jsonObject.getString("access_token");
			tokenExpiredTime = jsonObject.getLong("expires_in") * 1000L;
		} else {
			LOGGER.debug("Fail to refresh token!");
		}
		return null;
	}

	private static String createRequestBody(String appId, String appSecret) {
		return MessageFormat.format("grant_type=client_credentials&client_secret={0}&client_id={1}", appSecret, appId);
	}


	//获取下发通知消息的认证Token
	private static String refreshToken() throws IOException {
		String msgBody = MessageFormat.format(
				"grant_type=client_credentials&client_secret={0}&client_id={1}",
				URLEncoder.encode(appSecret, "UTF-8"), appId);
//		String response = httpPost(tokenUrl, msgBody, 5000, 5000);
		String response = httpPost(tokenUrl_v2, msgBody, 5000, 5000);
		JSONObject obj = JSONObject.parseObject(response);
		if(obj == null) {
			//use the old one
			return accessToken;
		}

		Long left = obj.getLong("expires_in") - 5*60*1000;
		String token = obj.getString("access_token");

		if (left != null && token != null && left > 0) {
			rwl.writeLock().lock();
			accessToken = token;
			tokenExpiredTime = System.currentTimeMillis() + left;
			rwl.writeLock().unlock();
		}

		return token;
	}

	public static String httpPost(String httpUrl, String data, int connectTimeout, int readTimeout) throws IOException {
		OutputStream outPut = null;
		HttpURLConnection urlConnection = null;
		InputStream in = null;

		try {
			URL url = new URL(httpUrl);
			urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("POST");
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			urlConnection.setConnectTimeout(connectTimeout);
			urlConnection.setReadTimeout(readTimeout);
			urlConnection.connect();

			// POST data
			outPut = urlConnection.getOutputStream();
			outPut.write(data.getBytes("UTF-8"));
			outPut.flush();

			// read response
			if (urlConnection.getResponseCode() < 400) {
				in = urlConnection.getInputStream();
			} else {
				in = urlConnection.getErrorStream();
			}
			List<String> lines = IOUtils.readLines(in, urlConnection.getContentEncoding());
			StringBuffer strBuf = new StringBuffer();
			for (String line : lines) {
				strBuf.append(line);
			}
			return strBuf.toString();
		} finally {
			IOUtils.closeQuietly(outPut);
			IOUtils.closeQuietly(in);
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
	}
}
