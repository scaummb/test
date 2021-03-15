package switchtest;

/**
 * @author moubin.mo
 * @date: 2021/2/25 11:39
 */

public class SwitchTest {
	public static void main(String[] args) {
		int a = 1;
		float b = 1.1f;
		double c = 1.1;
		char d = ';';
		long e = 1l;
		byte f = 1;
		Object obj = new Object();


		switch (a) {
			default:
				;
		}

//		switch (b){ no
//		switch (c){ no
//		switch (d){ yes
//		switch (e){ no
//		switch (obj){ no
		switch (f) { //yes
			default:
				;
		}
	}
}
