package design.ObserverPattern;

/**
 * Date: 2019/4/26 16 :26
 *
 * @author moubin.mo
 */

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
