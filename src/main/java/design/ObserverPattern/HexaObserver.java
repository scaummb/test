package design.ObserverPattern;

/**
 * Date: 2019/4/26 16 :31
 *
 * @author moubin.mo
 */

public class HexaObserver extends Observer {

    //构造器，subject添加observer到list里
    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}
