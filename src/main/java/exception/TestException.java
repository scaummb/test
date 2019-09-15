package exception;

/**
 * Date: 2019/6/19 15 :47
 *
 * @author moubin.mo
 */

public class TestException {
    public static void main(String[] args){
        for (int i = 0;i<10;i++){
            try{
                testFunction(i);
            }catch (Exception ex){
                System.out.println("main.ex, i="+i);
            }
        }
    }

    public static void testFunction(int i){
        try{
            testFunction2(i);
        }catch (Exception ex){
            System.out.println("testFunction1.ex , i="+i);
        }
    }

    public static void testFunction2(int i){
        try{
            throw new Exception();
        }catch (Exception ex){
            System.out.println("testFunction2.ex , i="+i);
        }
    }
}
