package string;

import java.util.Date;

/**
 * @author moubin.mo
 * @date: 2019/8/15 18:33
 */

public class Test {
    public static void main(String[] args){
        String pushEventValue = String.format("%d:%s:%d:%d:%s:%d", 550809,"beb651362f134e9ab7599f41d9692585",203000,11,"USER",11);
        System.out.println(pushEventValue);
        String stringValue = String.format("Today is %tc, i am %s", new Date(), "mmb");
        System.out.println(stringValue);
    }
}
