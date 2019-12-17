package methodavoke;

/**
 * @author moubin.mo
 * @date: 2019/12/11 18:02
 */

public class TestAvoke {
	public static void main(String[] args) {
		Long a = 100L;
		changeValue(a);
		System.out.print(a);

		Value value = new Value();
		value.setValue(100L);
		changeValue(value);
		System.out.print(value.getValue());
	}

	private static void changeValue(Value value) {
		value.setValue(1000L);
	}

	public static void changeValue(Long anchor){
		anchor=1000L;
	}
}

class Value{
	Long value;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}
