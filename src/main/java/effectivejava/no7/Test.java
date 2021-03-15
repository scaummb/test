package effectivejava.no7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author moubin.mo
 * @date: 2020/10/28 22:47
 */

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(System.currentTimeMillis());
		O o = new O();
		FileInputStream fileInputStream = new FileInputStream("");
		System.out.println(System.currentTimeMillis());
		try {

		} finally {

			System.out.println(System.currentTimeMillis());
		}
	}

	// Manual finalizer chaining
	@Override
	protected void finalize() throws Throwable {
		try {
			// Finalize subclass state
		} finally {
			super.finalize();
		}
	}

}

class O {
}

