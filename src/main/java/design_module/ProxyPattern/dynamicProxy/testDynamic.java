package design_module.ProxyPattern.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Date: 2019/7/27 15 :30
 *
 * @author moubin.mo
 */

/**
 * 动态代理有别于静态代理，是根据代理的对象，动态创建代理类。这样，就可以避免静态代理中代理类接口过多的问题。动态代理是实现方式，是通过反射来实现的，借助Java自带的java.lang.reflect.Proxy,通过固定的规则生成。
 * 其步骤如下：
 *
 * 编写一个委托类的接口，即静态代理的（Subject接口）
 * 实现一个真正的委托类，即静态代理的（RealSubject类）
 * 创建一个动态代理类，实现InvocationHandler接口，并重写该invoke方法
 * 在测试类中，生成动态代理的对象。
 *
 * java的动态代理有两种方法：一个是利用实现InvocationHandler接口，一个是利用
 *
 * */
public class testDynamic {
    public static void main(String[] args){
        //委托类RealDynamicSubject
        DynamicSubject dynamicSubject = new RealDynamicSubject();
        //代理类设置对象
        DynamicProxy dynamicProxy = new DynamicProxy(dynamicSubject);
        //委托类RealDynamicSubject的类加载器
        ClassLoader classLoader = dynamicSubject.getClass().getClassLoader();
        //动态生成的代理对象
        DynamicSubject subject = (DynamicSubject) Proxy.newProxyInstance(classLoader, new Class[]{DynamicSubject.class}, dynamicProxy);
        subject.visit();
        subject.gohome();

        ////委托类RealDynamicSubject2
        DynamicSubject dynamicSubject2 = new RealDynamicSubject2();
        //代理类设置对象
        dynamicProxy.setObject(dynamicSubject2);
        //委托类RealDynamicSubject2的类加载器
        ClassLoader classLoader2 = dynamicSubject2.getClass().getClassLoader();
        DynamicSubject subject2 = (DynamicSubject) Proxy.newProxyInstance(classLoader2, new Class[]{DynamicSubject.class}, dynamicProxy);
        subject2.visit();
        subject2.gohome();

    }

    /**
     * 创建动态代理的对象，需要借助Proxy.newProxyInstance。该方法的三个参数分别是：
     * ClassLoader loader表示当前使用到的 appClassloader。
     * Class<?>[] interfaces表示目标对象实现的一组接口。
     * InvocationHandler h表示当前的InvocationHandler实现实例对象。
     * */
}
