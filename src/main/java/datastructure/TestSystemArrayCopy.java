package datastructure;

import lombok.extern.slf4j.Slf4j;

/**
 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * 代码解释:
 * 　　Object src : 原数组
 * int srcPos : 从元数据的起始位置开始
 * 　　Object dest : 目标数组
 * 　　int destPos : 目标数组的开始起始位置
 * 　　int length  : 要copy的数组的长度
 *
 * @author moubin.mo
 * @date: 2019/10/18 17:33
 */
@Slf4j
public class TestSystemArrayCopy {
	public static void main(String[] args) {

		byte[] originalByte = new byte[]{2, 4, 0, 0, 0, 0, 0, 10, 15, 50};
		byte[] originalByteCopy = new byte[5];
		System.arraycopy(originalByte, 2, originalByteCopy, 0, 5);
		for (byte element : originalByteCopy) {
			System.out.print(element + ", ");
		}
	}
}
