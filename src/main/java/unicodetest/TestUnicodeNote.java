package unicodetest;

/**
 * <p>避免在注释里添加Unicode字符</p>
 *
 * @author momoubin
 * @date 2020/5/5
 */
public class TestUnicodeNote {
	public static void main(String[] args) {
		Integer id = 1111;
		// \u000d id = 2222;
		System.out.println(id);
		// \u000d // 阿斯蒂芬
	}
}
