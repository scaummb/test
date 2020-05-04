package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author momoubin
 * @date 2020/5/3
 */
public class MyClass {
    public MyClass() {
    }

    public void setName(String n) {
        System.out.println(n);
    }

    public static void main(String[] args) {
        Class<MyClass> myClass = MyClass.class;
        try {
            MyClass p = myClass.newInstance();
            Method setName = myClass.getMethod("setName", String.class);
            setName.invoke(p, "abc");
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | SecurityException | IllegalArgumentException
                | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
