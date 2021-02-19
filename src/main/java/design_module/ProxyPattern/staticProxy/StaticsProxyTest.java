package design_module.ProxyPattern.staticProxy;

/**
 通过上面的代理代码，我们可以看出代理模式的特点:
 代理类接受一个Subject接口的对象，任何实现该接口的对象，都可以通过代理类进行代理，增加了通用性。
 但是也有缺点，每一个代理类都必须实现一遍委托类（也就是realsubject）的接口，如果接口增加方法，则代理类也必须跟着修改。
 其次，代理类每一个接口对象对应一个委托对象，如果委托对象非常多，则静态代理类就非常臃肿，难以胜任。
 */
public class StaticsProxyTest {
    public static void main(String[] args){
        //代理类
        ProxyHuman proxyHuman = new ProxyHuman(new UserDao());
        proxyHuman.visit();
        //代理类
        proxyHuman.setSubject(new WomanDao());
        proxyHuman.visit();
    }
}
