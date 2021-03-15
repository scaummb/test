package Utils.demo.boContribute;

import java.io.*;

/**
 * Date: 2019/7/8 16 :08
 *
 * @author moubin.mo
 */

public class testDeom {
	public static void main(String[] args) throws IOException {
//        Group group = new Group();
//        group.setIntegralTag2(240111044332061477L);
//        Long communityId = 240111044332061477L;
//        if (group.getIntegralTag2() - communityId == 0){z`
//            System.out.println("xxxxxxxxxxx");
//        }
//
//        String avatar="cs://1/image/aW1hZ2UvTVRvMk9UQTNNRGczTUdWaFlUUXlaV000TlRNeFlUazFNVEEyTURKa05HVmhOZw";
//        System.out.println(avatar.length());

		String redis_command = "ZREM mbx:mbx-503191-999983-1-2 java.lang.String|\\\"";
		String pathName = "C:\\Users\\zuolin\\Desktop\\zset.txt";
		FileReader fr = new FileReader(pathName);
		BufferedReader bf = new BufferedReader(fr);
		String str;
		// 按行读取字符串
		while ((str = bf.readLine()) != null) {
			String substring = str.substring(22, str.length());
			System.out.println(redis_command + substring + "\\\"\"");
		}
		bf.close();

	}
}
