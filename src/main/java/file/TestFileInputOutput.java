package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>
 * FileReader:FileReader是一种异步文件读取机制
 * 继承了 InputStreamReader,
 * 继承了 Reader，
 * 实现了  Readable, Closeable
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/1/14 11:54
 */

public class TestFileInputOutput {
	private final static Logger LOGGER = LoggerFactory.getLogger(TestFileInputOutput.class);

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\code\\test\\src\\main\\java\\file\\test.txt");
//		testFileReader(file);
//		testFileWriter(file);
		testPipedReader(file);
	}

	private static void testPipedReader(File file) {

	}

	private static void testFileWriter(File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("000000000");
	}

	private static void testFileReader(File file) throws IOException {
		FileReader reader = new FileReader(file);
		int character = reader.read();
		while (character != -1) {
			System.out.println(new StringBuilder(character));
		}
	}
}
