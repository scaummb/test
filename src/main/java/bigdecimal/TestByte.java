package bigdecimal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/11/2 16:43
 */

public class TestByte {
		public static void main(String[] args) {
			List<Integer> list = new ArrayList<>();
			for (int i=0; i<230; i++){
				list.add(i);
			}
			byte len = (byte) list.size(); // 无符号=1110 0110,补码=1001 1001 + 0000 0001 = 1001 1010 (-26)
			System.out.println(list.size());
			System.out.println(len);
			System.out.println((int)len);
			System.out.println((int)len+256);// ?加256
		}
}
