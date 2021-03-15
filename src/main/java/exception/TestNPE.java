package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2019/11/12 17:48
 */

public class TestNPE {
	public static void main(String[] args) {
		List<A> alist = new ArrayList<>();
		if (alist != null) {
			alist.stream().forEach(
					(r) -> {
						System.out.println(r.getName());
					}
			);

		}
	}
}

class A {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}