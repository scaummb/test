package algorithm.alibba;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * @author moubin.mo
 * @date: 2021/3/3 21:39
 */

public class FileClassTest {
	public static void main(String[] args) {
		String fileName = "E:\\code\\test\\src\\main\\java\\algorithm\\alibba\\hahah.txt";
		System.out.println(getFileLineNum(fileName));
	}

	private static int getFileLineNum(String fileName) {
		try {
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileName));
			lineNumberReader.skip(Long.MAX_VALUE);
			int lineNumber = lineNumberReader.getLineNumber();
			return lineNumber + 1;
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e) {
			return -1;
		}
	}
}
