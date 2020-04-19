package datastructure;

import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

/**
 * byte、byte[]、String之间的转换关系
 * @author moubin.mo
 * @date: 2019/10/18 15:38
 */
@Slf4j
public class DataStructure {
	public static void main(String[] args) {

		//1.通过String类将String转换成byte[]或者byte[]转换成String
		//Original String
		String string = "hello world";
		//Convert to byte[]
		byte[] bytes = string.getBytes();
		String s = new String(bytes);

		//2.通过Base64 将String转换成byte[]或者byte[]转换成String[Java 8]
		byte[] bytesFromString = string.getBytes();
		//Base64 Encoded
		String encoded = Base64.getEncoder().encodeToString(bytes);
		//Base64 Decoded
		byte[] decoded = Base64.getDecoder().decode(encoded);
		//Verify original content
		System.out.println( new String(decoded) );
	}
}
