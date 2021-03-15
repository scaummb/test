package effectivejava.no7;

/**
 * @author moubin.mo
 * @date: 2020/10/29 09:07
 */
// Finalizer Guardian idiom
public class Foo {
	// Sole purpose of this object is to finalize outer Foo object
	private final Object finalizerGuardian = new Object() {
		@Override
		protected void finalize() throws Throwable {
			// Finalize outer Foo object
		}
	};
	// Remainder omitted
}
