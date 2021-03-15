package leetCode.middle.tiny_url;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moubin.mo
 * @date: 2019/9/15 11:14
 */

public class HashMapStoreUrl {

	Map<String, String> map = new HashMap<String, String>();
	static final String INDEX = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String TINYURL_PREFIX = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		char[] chs = new char[6];
		while (true) {
			for (int i = 0; i < 6; i++) {
				chs[i] = INDEX.charAt((int) (Math.random() * 62));
			}
			String shortUrl = TINYURL_PREFIX + new String(chs);
			if (!map.containsKey(shortUrl)) {
				map.put(shortUrl, longUrl);
				return shortUrl;
			}
		}
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.get(shortUrl);
	}
}