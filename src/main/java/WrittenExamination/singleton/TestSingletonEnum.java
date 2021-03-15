package WrittenExamination.singleton;

/**
 * 枚举：对象有限几个
 *
 * @author moubin.mo
 * @date: 2021/2/26 22:49
 */

public class TestSingletonEnum {

	private TestSingletonEnum() {
	}

	public static TestSingletonEnum singletonEnum() {
		return ClassB.INSTANCE.getSingletonEnum();
	}

	enum ClassB {
		INSTANCE;
		private TestSingletonEnum singletonEnum;

		private ClassB() {
			singletonEnum = new TestSingletonEnum();
		}

		public TestSingletonEnum getSingletonEnum() {
			return singletonEnum;
		}
	}


}
