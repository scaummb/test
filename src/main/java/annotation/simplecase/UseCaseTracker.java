package annotation.simplecase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 反射获取方法注解用例
 *
 * @author: mmb
 * @date: 19-8-10
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> userCases, Class<?> cl){
        // 类通过反射取到所有方法
        for (Method m : cl.getDeclaredMethods()){
            // 获取方法的注解
            UserCase uc = m.getAnnotation(UserCase.class);
            if (uc != null ){
                System.out.println("Found Use Case - "+uc.id()+ " "+ uc.description());
            }
        }

    }

    public static void main(String[] args){
        ArrayList<Integer> userCases = new ArrayList<>();
        Collections.addAll(userCases,47,48,49,50);
        trackUseCases(userCases,PasswordUtils.class);
    }

}
