package keygenerator.otp;

import org.apache.commons.codec.binary.Base64;

/**
 * @author moubin.mo
 * @date: 2019/10/18 18:30
 */

public class TestBased64 {
	public static void main(String[] args) {
		String code = "NTECiwMAiG22CvJrwrB4MTaZ+nEF8NdaFclkU2QVqDDC8buKvDCzd06IrU5sp4HxBOITnis6GgYI4lAMOy0o8b5Q+9s8kXPSAf0Wvt7s1KCXLHibnhcjqOpREjuytB936HA1/AN1y1XJ/a7OxNeKZBjo/XuahDsqFX31B4B26AiCmX3w6h5HXamQVV2pkq0=";
		byte[] bytes = Base64.decodeBase64(code.getBytes());
		System.out.println(bytes);
	}
}
