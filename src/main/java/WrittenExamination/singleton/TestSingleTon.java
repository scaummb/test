package WrittenExamination.singleton;

/**
 * @author moubin.mo
 * @date: 2021/2/26 22:46
 */

public class TestSingleTon {
	private final static TestSingleTon SINGLE_TON = new TestSingleTon();
	//constructor
	private TestSingleTon(){}

	public static TestSingleTon getInstance(){
		return SINGLE_TON;
	}
}
