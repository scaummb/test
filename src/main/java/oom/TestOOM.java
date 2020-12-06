package oom;

/**
 * @author moubin.mo
 * @date: 2020/12/5 21:28
 */

public class TestOOM {
	public static void main(String[] args) {
		//-Xms512m -Xmx1024m -XX:MetaspaceSize=30M -XX:MaxMetaspaceSize=30M
		String s = new String("123456");
		for (int i=0; ;i++) {
			s = new String(String.valueOf(i)).concat(s);
		}
	}
}
