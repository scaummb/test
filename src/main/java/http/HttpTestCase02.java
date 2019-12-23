package http;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 第二种方式：apache HttpClient3.1
 * @author moubin.mo
 * @date: 2019/12/18 21:51
 */

public class HttpTestCase02 {

	private final static HttpClient httpClient = new HttpClient();

	public static void main(String[] args) {

	}

	public static String doGet(String url){

		// 输入流
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		// 设置http连接主机服务超时时间：15000毫秒
		// 先获取连接管理器对象，再获取参数对象,再进行参数的赋值
		httpClient.getHttpConnectionManager()
				.getParams().setConnectionTimeout(15000);
		// 创建一个Get方法实例对象
		GetMethod getMethod = new GetMethod(url);
		// 设置get请求超时为60000毫秒
		getMethod.getParams().setParameter(
				HttpMethodParams.SO_TIMEOUT, 60000
		);
		// 设置请求重试机制，默认重试次数：3次，参数设置为true，重试机制可用，false相反
		getMethod.getParams().setParameter(
				HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler(3, true)
		);

		try{
			// 执行Get方法
			int statusCode = httpClient.executeMethod(getMethod);
			// 判断返回码
			if (statusCode != HttpStatus.SC_OK){
				// 如果状态码返回的不是ok,说明失败了,打印错误信息
				System.err.println("Method faild: " + getMethod.getStatusLine());
			} else {
				// 通过getMethod实例，获取远程的一个输入流
				is = getMethod.getResponseBodyAsStream();
				// 包装输入流
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				StringBuffer sbf = new StringBuffer();
				// 读取封装的输入流
				String temp = null;
				while ((temp = br.readLine()) != null){
					sbf.append(temp);
				}

				result = sbf.toString();
			}

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// 释放连接
			getMethod.releaseConnection();
		}

		return result;
	}

	public static String doPost(String url, Map<String, Object> paramMap){
		// 获取输入流
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		// 设置httpClient连接主机服务器超时时间：15000毫秒
		httpClient.getHttpConnectionManager().getParams()
				.setConnectionTimeout(15000);

		// 创建post请求方法实例对象
		PostMethod postMethod = new PostMethod(url);
		// 设置post请求超时时间
		postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);

		NameValuePair[] nvp = null;
		if (paramMap != null && paramMap.size() > 0){
			// 创建键值参数对象数组，大小为参数的个数
			nvp = new NameValuePair[paramMap.size()];

			Set<Map.Entry<String, Object>> entrySet = paramMap.entrySet();

			Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();

			int index = 0;

			while (iterator.hasNext()){
				Map.Entry<String, Object> mapEntry = iterator.next();
				// 从mapEntry中获取key和value创建键值对象存放到数组中
				nvp[index] = new NameValuePair() {
					@Override
					public String getName() {
						return mapEntry.getKey();
					}

					@Override
					public String getValue() {
						try {
							return new String(mapEntry.getValue().toString().getBytes("UTF-8"), "UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						return null;
					}
				};
				index++;
			}

			if (nvp != null && nvp.length > 0){
				postMethod.setRequestBody((org.apache.commons.httpclient.NameValuePair[]) nvp);
			}

		}

		return result;
	}
}
