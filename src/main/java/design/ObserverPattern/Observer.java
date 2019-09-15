package design.ObserverPattern;


/**
 * Date: 2019/4/26 16 :26
 *
 * @author moubin.mo
 */

//观察者
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
