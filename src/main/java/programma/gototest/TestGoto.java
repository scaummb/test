package programma.gototest;

/**
 * @author moubin.mo
 * @date: 2020/11/11 22:34
 */

public class TestGoto {
	public static void main(String[] args) {
		int i = 0;
		int j = 0;
		LABLE:
		for (; i <10; i++) {
			for (; j <10; j++) {
				if (j == 7 ){
					break LABLE;
				}
			}
		}
		System.out.println("i = " + i + " , j = "+ j);
	}
}
