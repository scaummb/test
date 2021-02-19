package design_module.ProxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 *     代理类
 * </p>
 */

public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        return result;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
