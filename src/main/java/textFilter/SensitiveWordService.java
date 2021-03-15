package textFilter;

import com.hankcs.algorithm.AhoCorasickDoubleArrayTrie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author moubin.mo
 * @date: 2020/6/19 14:16
 */

public class SensitiveWordService {

	private static AhoCorasickDoubleArrayTrie<String> acdat = null;

	private static String url = "http://beta-cs.zuolin.com:80/file/ZmlsZS9NenBqWldZNFlqQXpZekZoWkRVMU9UQTFOalUyWVRVMU0yTmtZbU5oTW1VMU5n?token=0R1Bg2O5iZv2jV1lLxHFtgYM38L3hQ_F2AKoDaBkZVOs_udZWepmGMDY7SgjhNvBmt9M5AX9Y-IX7hHEdaExVr0xgV0wAKGxq2POIGRNQXA";

	public static void main(String[] args) {
		init();
		filter("aaaa");
	}

	/**
	 * <p>过滤</p>
	 */
	private static void filter(String text) {
		String regex = "<\\s*img(.+?)src=[\"'](.*?)[\"']\\s*/?\\s*>";
		Set<String> wordSet = new HashSet<>();

		//匹配敏感词时，先将富文本中的链接去除 add by yanlong.liang 20190920
		try {
			text = text.replaceAll(regex, "");
		} catch (Exception e) {
		}
		String[] chineseWords = text.split("[a-zA-Z]+");
		for (String word : chineseWords) {
			if (acdat != null && acdat.size() != 0) {
				List<AhoCorasickDoubleArrayTrie.Hit<String>> hits = acdat.parseText(word);
				for (AhoCorasickDoubleArrayTrie.Hit<String> hit : hits) {
					wordSet.add(hit.value);
				}
			}
		}
		String[] englishWords = text.split("[^a-zA-Z]+");
		for (String word : englishWords) {
			if (acdat != null && acdat.size() != 0) {
				int index = acdat.exactMatchSearch(word.toUpperCase());
				//域空间有自己独立维护的敏感词，每次要同样需要对这部分进行过滤 add by yang.yang 20191216
				if (index > 0) {
					String hit = acdat.get(index);
					wordSet.add(hit);
				}
			}
		}
	}

	/**
	 * <p>初始化</p>
	 */
	private static void init() {

		TreeMap<String, String> map = new TreeMap<String, String>();

		if (null == acdat) {
			acdat = new AhoCorasickDoubleArrayTrie<String>();
		}

		BufferedReader in = null;
		URL realUrl = null;
		String s = null;
		try {
			realUrl = new URL(url);
			URLConnection connection = connect(realUrl);
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			//使用readLine方法，一次读一行
			while ((s = in.readLine()) != null) {
				map.put(s.trim().toUpperCase(), s.trim().toUpperCase());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (map.size() > 0) {
			acdat.build(map);
		} else {
			acdat = null;
		}

	}

	/**
	 * <p>初始化</p>
	 */
	private static URLConnection connect(URL realUrl) {
		URLConnection connection = null;
		try {
			connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(50000);
			connection.setReadTimeout(50000);
			// 建立实际的连接
			connection.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
