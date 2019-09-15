package design.ObserverPattern;

/**
 * Date: 2019/4/26 16 :44
 *
 * @author moubin.mo
 */

public class ObserverPatternDemo {

    public static void main(String[] args){
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
