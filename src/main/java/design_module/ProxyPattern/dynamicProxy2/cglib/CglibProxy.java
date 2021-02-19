package design_module.ProxyPattern.dynamicProxy2.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Trancation3 trancation;
    private HelloImpl2 target;

    public CglibProxy(Trancation3 trancation, HelloImpl2 target) {
        this.trancation = trancation;
        this.target = target;
    }
    // 创建代理
    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 开启事务
        trancation.beginTrancation();
        // 方法调用，注！！！此处传入的Object为代理，而不是目标类，目标类需要另外注入
        Object obj = method.invoke(target, objects);
        // 提交事务
        trancation.commit();
        return obj;
    }
}
interface Ihello{
    void sayHello();
}
// 人员DAO
class HelloImpl2 implements Ihello {
    @Override
    public void sayHello() {
        System.out.println("保存人员");
    }
}
// 事务
class Trancation3 {
    public void beginTrancation() {
        System.out.println("开启事务");
    }

    public void commit() {
        System.out.println("提交事务");
    }
}
// 客户端
class Client3 {
    public static void main(String[] args) {
        Trancation3 t3 = new Trancation3();
        HelloImpl2 p3 = new HelloImpl2();
        CglibProxy cglibProxy = new CglibProxy(t3,p3);
        HelloImpl2 helloImpl2 = (HelloImpl2) cglibProxy.createProxy();
        helloImpl2.sayHello();
    }
}
