package Utils.demo;

import java.util.regex.Pattern;

/**
 * Date: 2019/5/16 16 :01
 *
 * @author moubin.mo
 */

public class test {
    public static void main(String[] args){
        String name = "毕123456";
        System.out.println(checkUserContactNameIsQualified(name));
    }


    private static boolean checkUserContactNameIsQualified(String contactName) {

        // 1.判空
        String replace = contactName.replace(" ", "");
        if ("".equals(replace) ){
            System.out.println( "真实姓名为空!!");
            return false;
        }

        // 2.用户名是否超出规定字符集
        if (!Pattern.matches("^[\\u4E00-\\u9FA5 A-Za-z0-9.·\\-_\\n]+$", contactName)) {
            System.out.println( "真实姓名中仅允许输入汉字、字母、数字、点（.）、居中点（·）、减号（-）下划线（_）、空格（ ）!!");
            return false;
        }

        // 3.挨个字符判断(是否存在字母或者中文字符)
        char[] chars = contactName.toCharArray();
        for (Character s : chars){
            if (Pattern.matches("([A-Za-z]|[\\u4E00-\\u9FA5])",String.valueOf(s))){
                return true;
            }
        }
        String a = "a";
        a.startsWith("a");
        return true;
    }
}
