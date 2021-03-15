// @formatter:off
package sso;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.apache.http.annotation.Contract;
//import org.apache.http.annotation.ThreadingBehavior;

/**
 * http请求
 *
 * @author tangtong
 */
@SuppressWarnings("deprecation")
public class HttpUtils {
	protected static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	/**
	 * post请求 ，超时默认30秒
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String post(String url, Map<String, String> params) throws IOException {
		return post(url, params, 20, false);
	}

	/**
	 * 带签名的post请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public static String postWithAuthority(String url, Map<String, String> params) throws IOException {
		return post(url, params, 20, false);
	}

	/**
	 * post请求
	 *
	 * @param url
	 * @param params
	 * @param timeout 超时时间，秒
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String post(String url, Map<String, String> params, int timeout) throws IOException {
		HttpClient httpclient = getHttpClient(timeout);
//		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
//		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					formparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, HTTP.UTF_8);
			HttpPost httppost = new HttpPost(url);
			setHeaderInfo(httppost);
			httppost.setEntity(entity);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(HTTP.ISO_8859_1), HTTP.UTF_8);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * post请求
	 *
	 * @param url
	 * @param params
	 * @param timeout       超时时间，秒
	 * @param isParseReturn 是否转码返回值
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String post(String url, Map<String, String> params, int timeout, boolean isParseReturn)
			throws IOException {
		StopWatch clock = new StopWatch();
		clock.start();

//		HttpClient httpclient = new DefaultHttpClient();
		HttpClient httpclient = getHttpClient(timeout);
//		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
//		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					formparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, HTTP.UTF_8);
			HttpPost httppost = new HttpPost(url);
			setHeaderInfo(httppost);
			httppost.setEntity(entity);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (isParseReturn) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(HTTP.ISO_8859_1),
						HTTP.UTF_8);
			} else {
				retVal = httpclient.execute(httppost, responseHandler).toString();
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		logger.info(String.format("===request info===[waiting:%s ms;url:%s;params:%s;reponse:%s]", clock.getTime(), url,
				params, retVal));
		return retVal;
	}

	/**
	 * 设置头信息
	 *
	 * @param httppost
	 */
	private static void setHeaderInfo(HttpPost httppost) {

	}

	@SuppressWarnings("resource")
	public static String postJson(String url, String json, int timeout, Object... objects) throws IOException {
		HttpClient httpclient = getHttpClient(timeout);
//		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
//		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			String encoding = HTTP.UTF_8;
			if (objects != null && objects.length > 0) {
				encoding = objects[0].toString();
			}
			HttpPost httppost = new HttpPost(url);
			StringEntity params = new StringEntity(json, encoding);
			httppost.addHeader("Content-Type", "application/json");
			httppost.setEntity(params);
			setHeaderInfo(httppost);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (objects == null || objects.length == 0) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(HTTP.ISO_8859_1),
						HTTP.UTF_8);
			} else if (objects != null && objects[0].equals(HTTP.UTF_8)) {
				retVal = httpclient.execute(httppost, responseHandler);
			} else if (objects != null && objects[0].equals("gb2312")) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes("iso-8859-1"), "gb2312");
			} else {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(), HTTP.UTF_8);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		logger.debug(retVal);
		return retVal;
	}

	public static String postJson(String url, String json, int timeout) throws IOException {
		HttpClient httpclient = getHttpClient(timeout);
//		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
//		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		HttpResponse response = null;
		try {
			String encoding = HTTP.UTF_8;
			HttpPost httppost = new HttpPost(url);
			StringEntity params = new StringEntity(json, encoding);
			httppost.addHeader("Content-Type", "application/json");
			httppost.setEntity(params);
			setHeaderInfo(httppost);
			response = httpclient.execute(httppost);

			int status = response.getStatusLine().getStatusCode();
			if (status == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					retVal = EntityUtils.toString(entity, "utf8");
				}
			}
		} catch (IOException e) {
			logger.error(", response={}", JSON.toJSONString(response));
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		logger.debug(retVal);
		return retVal;
	}


	public static String postJsonWithHeader(String url, String json, int timeout, Map<String, String> map, Object... objects) throws IOException {
		HttpClient httpclient = getHttpClient(timeout);
//		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
//		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			String encoding = HTTP.UTF_8;
			if (objects != null && objects.length > 0) {
				encoding = objects[0].toString();
			}
			HttpPost httppost = new HttpPost(url);
			StringEntity params = new StringEntity(json, encoding);
			httppost.addHeader("Content-Type", "application/json");
			for (Map.Entry<String, String> entry : map.entrySet()) {
				httppost.setHeader(entry.getKey(), entry.getValue());
			}
			httppost.setEntity(params);
			setHeaderInfo(httppost);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (objects == null || objects.length == 0) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(HTTP.ISO_8859_1),
						HTTP.UTF_8);
			} else if (objects != null && objects[0].equals(HTTP.UTF_8)) {
				retVal = httpclient.execute(httppost, responseHandler);
			} else if (objects != null && objects[0].equals("gb2312")) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes("iso-8859-1"), "gb2312");
			} else {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(), HTTP.UTF_8);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		logger.debug(retVal);
		return retVal;
	}

	@SuppressWarnings("resource")
	public static String postForm(String url, String json, int timeout, Object... objects) throws IOException {
		HttpClient httpclient = getHttpClient(timeout);
		String retVal = "";
		try {
			String encoding = HTTP.UTF_8;
			if (objects != null && objects.length > 0) {
				encoding = objects[0].toString();
			}
			HttpPost httppost = new HttpPost(url);
			StringEntity params = new StringEntity(json, encoding);
			httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
			httppost.setEntity(params);
			setHeaderInfo(httppost);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (objects == null || objects.length == 0) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(HTTP.ISO_8859_1),
						HTTP.UTF_8);
			} else if (objects != null && objects[0].equals(HTTP.UTF_8)) {
				retVal = httpclient.execute(httppost, responseHandler);
			} else if (objects != null && objects[0].equals("gb2312")) {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes("iso-8859-1"), "gb2312");
			} else {
				retVal = new String(httpclient.execute(httppost, responseHandler).getBytes(), HTTP.UTF_8);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		logger.debug(retVal);
		return retVal;
	}

	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String get(String url, Map<String, String> params) throws IOException {
		HttpClient httpclient = getHttpClient(100000);
//		httpclient.getParams().setIntParameter("http.socket.timeout", 100000);
		String retVal = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, HTTP.UTF_8);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			retVal = httpclient.execute(httpget, responseHandler);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static InputStream getInputStream(String url, Map<String, String> params) throws IOException {
		HttpClient httpclient = getHttpClient(100000);
		HttpResponse response = null;
//		httpclient.getParams().setIntParameter("http.socket.timeout", 100000);
		String retVal = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, HTTP.UTF_8);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);
			response = httpclient.execute(httpget);
			HttpEntity httpEntity = response.getEntity();
			InputStream is = httpEntity.getContent();
			return is;
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}


	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static byte[] getArray(String url, Map<String, String> params) throws IOException {
		HttpClient httpclient = getHttpClient(100000);
		HttpResponse response = null;
//		httpclient.getParams().setIntParameter("http.socket.timeout", 100000);
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, HTTP.UTF_8);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);

			response = httpclient.execute(httpget);
			int status = response.getStatusLine().getStatusCode();

			if (status == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();

				if (entity != null) {
					byte[] data = EntityUtils.toByteArray(entity);
					return data;
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return null;
	}

	@SuppressWarnings("resource")
	public static String get(String url, Map<String, String> params, String charset, RequestConfig requestConfig) throws IOException {
		CloseableHttpClient httpclient = getHttpClient(100000);
		CloseableHttpResponse retVal = null;
		String result = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, charset);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);
			if (requestConfig != null) {
				httpget.setConfig(requestConfig);
			}
			retVal = httpclient.execute(httpget);
			HttpEntity resEntity = retVal.getEntity();
			result = EntityUtils.toString(resEntity, charset);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}

	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String get(String url, Map<String, String> params, Header[] headers) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", 100000);
		String retVal = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, HTTP.UTF_8);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);
			httpget.setHeaders(headers);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			retVal = httpclient.execute(httpget, responseHandler);
			retVal = new String(retVal.getBytes(HTTP.ISO_8859_1), HTTP.UTF_8);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String getDecodeWithoutISO8859(String url, Map<String, String> params, Header[] headers) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", 100000);
		String retVal = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, HTTP.UTF_8);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			logger.info("The request info, geturl={}", url);
			HttpGet httpget = new HttpGet(url);
			httpget.setHeaders(headers);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			retVal = httpclient.execute(httpget, responseHandler);
			retVal = new String(retVal.getBytes(HTTP.UTF_8));
			logger.info("SendResult from third, url={}, result={}", url, retVal);
		} catch (IOException e) {
			logger.error("The request error, geturl={}", url, e);
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String get(String url, Map<String, String> params, String charset) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", 100000);
		String retVal = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, charset);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			retVal = httpclient.execute(httpget, responseHandler);
			retVal = new String(retVal.getBytes(HTTP.ISO_8859_1), charset);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * 得到访问url的返回状态(200正常)
	 *
	 * @param url     :访问地址
	 * @param timeOut :设置超时时间秒
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	@SuppressWarnings("resource")
	public static int getPostRetStatu(String url, Integer timeOut) {
		HttpResponse response = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			httpclient.getParams().setIntParameter("http.socket.timeout", timeOut * 1000);
			httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
			/**
			 * 此处使用get请求,因为一些网站屏蔽了post请求eg:baidu
			 */
			// HttpPost httpost = new HttpPost(url);
			HttpGet httpget = new HttpGet(url);
			response = httpclient.execute(httpget);
		} catch (Exception e) {
			return 404;
		}
		return response.getStatusLine().getStatusCode();
	}

	/**
	 * @param params
	 * @return
	 * @Description:获取参数路径
	 * @author Alvin.zengqi
	 * @date 2011-6-27 下午08:55:16
	 */
	public static String getParamsPath(Map<String, String> params) {
		String url = "";
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		if (params != null) {
			for (Map.Entry<String, String> param : params.entrySet()) {
				qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
			}
		}
		String paramstr = URLEncodedUtils.format(qparams, HTTP.UTF_8);
		if (StringUtils.isNotEmpty(paramstr)) {
			url = url + "?" + paramstr;
		}
		return url;
	}

	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @param timeout 超时时间，秒
	 * @param charset 编码方式
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static String get(String url, Map<String, String> params, int timeout, String charset) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			List<NameValuePair> qparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					qparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			String paramstr = URLEncodedUtils.format(qparams, charset);
			if (StringUtils.isNotEmpty(paramstr)) {
				url = url + "?" + paramstr;
			}
			HttpGet httpget = new HttpGet(url);

			HttpResponse resp = httpclient.execute(httpget);
			retVal = EntityUtils.toString(resp.getEntity(), charset);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * post请求
	 *
	 * @param url
	 * @param params
	 * @param timeout 超时时间，秒
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String post(String url, Map<String, String> params, int timeout, String charset) throws Exception {
		HttpClient httpclient = getHttpClient(timeout);
//		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
//		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					formparams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, charset);
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(entity);
			HttpResponse resp = httpclient.execute(httppost);
			retVal = EntityUtils.toString(resp.getEntity(), charset);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * put请求
	 *
	 * @param url
	 * @param json
	 * @param timeout
	 * @param objects
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String putJson(String url, String json, int timeout, Object... objects) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			String encoding = HTTP.UTF_8;
			if (objects != null && objects.length > 0) {
				encoding = objects[0].toString();
			}
			HttpPut httpput = new HttpPut(url);
			StringEntity params = new StringEntity(json, encoding);
			httpput.addHeader("content-type", "application/json");
			httpput.setEntity(params);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (objects == null || objects.length == 0) {
				retVal = new String(httpclient.execute(httpput, responseHandler).getBytes(HTTP.ISO_8859_1), HTTP.UTF_8);
			} else if (objects != null && objects[0].equals(HTTP.UTF_8)) {
				retVal = httpclient.execute(httpput, responseHandler);
			} else if (objects != null && objects[0].equals("gb2312")) {
				retVal = new String(httpclient.execute(httpput, responseHandler).getBytes("iso-8859-1"), "gb2312");
			} else {
				retVal = new String(httpclient.execute(httpput, responseHandler).getBytes(), HTTP.UTF_8);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * delete请求
	 *
	 * @param url
	 * @param timeout
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String delete(String url, int timeout, String charset) throws IOException {
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			HttpDelete httpDelete = new HttpDelete(url);
			HttpResponse resp = httpclient.execute(httpDelete);
			retVal = EntityUtils.toString(resp.getEntity(), charset);
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return retVal;
	}

	/**
	 * delete请求
	 *
	 * @param url
	 * @param json
	 * @param timeout
	 * @param objects
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static String deleteJson(String url, String json, int timeout, Object... objects) throws IOException {

		/**
		 * 没有现成的delete可以带json的，自己实现一个，参考HttpPost的实现
		 */
		//@Contract(threading = ThreadingBehavior.UNSAFE)
		class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
			public static final String METHOD_NAME = "DELETE";

			@SuppressWarnings("unused")
			public HttpDeleteWithBody() {
			}

			@SuppressWarnings("unused")
			public HttpDeleteWithBody(URI uri) {
				setURI(uri);
			}

			public HttpDeleteWithBody(String uri) {
				setURI(URI.create(uri));
			}

			@Override
			public String getMethod() {
				return METHOD_NAME;
			}
		}

		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setIntParameter("http.socket.timeout", timeout * 1000);
		httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
		String retVal = "";
		try {
			String encoding = HTTP.UTF_8;
			if (objects != null && objects.length > 0) {
				encoding = objects[0].toString();
			}
			HttpDeleteWithBody httpdelete = new HttpDeleteWithBody(url);
			StringEntity params = new StringEntity(json, encoding);
			httpdelete.addHeader("content-type", "application/json");
			httpdelete.setEntity(params);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			if (objects == null || objects.length == 0) {
				retVal = new String(httpclient.execute(httpdelete, responseHandler).getBytes(HTTP.ISO_8859_1),
						HTTP.UTF_8);
			} else if (objects != null && objects[0].equals(HTTP.UTF_8)) {
				retVal = httpclient.execute(httpdelete, responseHandler);
			} else if (objects != null && objects[0].equals("gb2312")) {
				retVal = new String(httpclient.execute(httpdelete, responseHandler).getBytes("iso-8859-1"), "gb2312");
			} else {
				retVal = new String(httpclient.execute(httpdelete, responseHandler).getBytes(), HTTP.UTF_8);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		logger.debug(retVal);
		return retVal;


	}

	/**
	 * 发送HttpsPost（通过绕过证书检查的HttpClient），不推荐使用。
	 */
	public static String httpsPost(String url, Map<String, String> paras) {
		String result = null;
		try {
			CloseableHttpClient httpClient = createHttpsClient();
			HttpPost httpPost = new HttpPost(url);
			List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			if (paras != null) {
				for (Map.Entry<String, String> param : paras.entrySet()) {
					formParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, HTTP.UTF_8);
			httpPost.setEntity(entity);

			logger.info("Executing request " + httpPost.getRequestLine());

			result = httpClient.execute(httpPost, new BasicResponseHandler());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 创建可以绕过证书检查的HttpClient，不推荐使用。
	 */
	public static CloseableHttpClient createHttpsClient() throws Exception {
		// 不做任何检查的X509TrustManager匿名类
		X509TrustManager x509mgr = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, new TrustManager[]{x509mgr}, new java.security.SecureRandom());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return null;
	}

	/**
	 * 通过httpclient获取远程数据
	 */
	public static <T> T getDataFromRemote(String url, Map<String, String> params, Class<T> clazz) throws Exception {
		T result = null;
		String resultStr = post(url, params);
		JSONObject resultJson = JSONObject.parseObject(resultStr);
		if (null != resultJson) {
			int errorCode = resultJson.getIntValue("errorCode");
			if (errorCode != 200) {
				throw new Exception("remote server inner error with errorCode " + errorCode);
			}
			String responseStr = resultJson.getString("response");
			result = resultJson.getObject("response", clazz);
		}
		return result;
	}


	public static CloseableHttpClient getHttpClient(int timeout) {
		int connectionRequestTimeout = 5000; // 申请连接超时时间，单位毫秒
		int connectTimeout = 5000; // 连接目标主机超时时间，单位毫秒
		int socketTimeout = 60000; // 读取数据超时时间，单位毫秒
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(connectionRequestTimeout)
				.setConnectTimeout(connectTimeout)
				.setSocketTimeout(socketTimeout)
				.build();
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
				//.setMaxConnTotal(maxConnTotal)
				//.setMaxConnPerRoute(maxConnPerRoute)
				.build();
		return httpClient;
	}


	private static PoolingHttpClientConnectionManager createConnectionManager() {
		try {
			SSLContext sslContext = new SSLContextBuilder()
					.loadTrustMaterial(null, (x509CertChain, authType) -> true)
					.build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
			Registry<ConnectionSocketFactory> socketFactoryRegistry =
					RegistryBuilder.<ConnectionSocketFactory>create()
							.register("https", sslsf)
							.register("http", PlainConnectionSocketFactory.getSocketFactory())
							.build();

			PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			manager.setDefaultMaxPerRoute(50);
			manager.setMaxTotal(50 * 2);
			return manager;
		} catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}


}
