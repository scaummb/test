package stream.test_stream_npe;

import java.util.ArrayList;

/**
 * @author moubin.mo
 * @date: 2019/9/24 20:45
 */

public class TestNPE {
	public static void main(String[] args){
//		test01();
		test2();

	}

	private static void test2() {
		ArrayList<Long> longs = new ArrayList<>();
		longs = null;
		longs.stream().forEach(
				(longnum) -> {
					if (longnum != null){
						try {
							throw new Exception("test ex");
						} catch (Exception e) {
							System.out.println("test long num = "+ longnum);
						}
					} else {
						System.out.println("longnum is null");
					}
				}
		);
	}

	private static void test01() {
		ArrayList<Long> longs = new ArrayList<>();
		longs.add(100L);
		longs.add(1L);
		longs.add(null);
		longs.add(null);

//		longs = null;
		longs.stream().forEach(
				(longnum) -> {
					if (longnum != null){
						try {
							throw new Exception("test ex");
						} catch (Exception e) {
							System.out.println("test long num = "+ longnum);
						}
					} else {
						System.out.println("longnum is null");
					}
				}
		);

	}
}
