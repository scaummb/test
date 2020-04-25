package jvm.String;

/**
 * <p>"+" 和 "+=" 是Java重载过的操作符，编译器会自动优化引用StringBuilder，更高效</p>
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.print(s);
    }
}
