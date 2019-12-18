package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * java原生HttpURLConnection
 * @author moubin.mo
 * @date: 2019/12/18 21:51
 */

public class HttpTestCase01 {

	// Get请求
	public static String doGet(String httpurl) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;

		try{
			URL url = new URL(httpurl);

			connection  = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.setConnectTimeout(15000);

			connection.setReadTimeout(60000);

			connection.connect();

			if (connection.getResponseCode() == 200 ){

				is = connection.getInputStream();

				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null){
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != is){
				try{
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			connection.disconnect();
		}
		return result;
	}

	// POST
	public static String doPost(String httpUrl, String param) {



	}

}
