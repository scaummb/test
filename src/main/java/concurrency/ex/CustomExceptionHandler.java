package concurrency.ex;

/**
 * @FileName: ExceptionHandle
 * @Description: ExceptionHandle
 * @author: <a href="mailto:***@163.com">myp</a>
 * @create: 2019-01-08 17:11
 */
public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("subThread exception, id = " + t.getId() + " , name = " + t.getName()  +"，e = " + e.toString());
    }
}