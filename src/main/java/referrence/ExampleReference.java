package referrence;

/**
 * @author moubin.mo
 * @date: 2021/1/12 14:32
 */

public class ExampleReference {
	String str = new String("hello");
	Integer number = 11;
	char[] ch = {'a', 'b'};

	public static void main(String[] args) {
		ExampleReference ex = new ExampleReference();
		ex.change(ex.str, ex.ch);
		ex.change(ex.number);
		System.out.println(ex.str);
		System.out.println(ex.ch);
		System.out.println(ex.number);
	}

	private void change(Integer number) {
		number = 110;
	}

	public void change(String str, char ch[]) {
		str = "test ok"; //改了副本的指针，不影响原来的指针所指向的内容
		ch[0] = 'c'; //改了指针所指向的内容
	}
}
