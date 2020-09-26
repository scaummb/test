package effectivejava.no42;

/**
 * @author moubin.mo
 * @date: 2020/9/27 02:52
 */

public interface VarargsInterface {
	public void foo();
	public void foo(int a1);
	public void foo(int a1, int a2);
	public void foo(int a1, int a2, int a3);
	public void foo(int a1, int a2, int a3, int... rest);
}
