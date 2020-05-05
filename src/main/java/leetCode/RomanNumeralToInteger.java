package leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Date: 2019/5/3 10 :28
 *
 * @author moubin.mo
 */

public class RomanNumeralToInteger {
    //匿名内部类初始化法，调用父类（非私有方法）方法，向上转型
    private static HashMap<String, Integer> romanNumberToIntegerMap = new HashMap<String, Integer>(){{
        put("I",1);
        put("V",5);
        put("X",10);
        put("L",50);
        put("C",100);
        put("D",500);
        put("M",1000);
        put("IV",4);
        put("IX",9);
        put("XL",40);
        put("XC",90);
        put("CD",400);
        put("CM",900);
    }};

    public static int romanToInt(String s) {


        char[] romanNumbers = s.toCharArray();
        Integer result = 0;

        for (int i = 0; i < romanNumbers.length ; i ++){
            switch (romanNumbers[i]) {
                case 'I':
                    if ((i < romanNumbers.length-1) && (romanNumbers[i + 1] == 'V' || romanNumbers[i + 1] == 'X')) {
                        result += getIntegerValue(romanNumbers[i] , romanNumbers[i + 1]);
                        i++;
                    }else {
                        result += getIntegerValue(romanNumbers[i]);
                    }
                    break;
                case 'X':
                    if ((i < romanNumbers.length-1) && (romanNumbers[i + 1] == 'L' || romanNumbers[i + 1] == 'C')) {
                        result += getIntegerValue(romanNumbers[i] , romanNumbers[i + 1]);
                        i++;
                    }else {
                        result += getIntegerValue(romanNumbers[i]);
                    }
                    break;
                case 'C':
                    if ((i < romanNumbers.length-1) && (romanNumbers[i + 1] == 'D' || romanNumbers[i + 1] == 'M')) {
                        result += getIntegerValue(romanNumbers[i] , romanNumbers[i + 1]);
                        i++;
                    }else {
                        result += getIntegerValue(romanNumbers[i]);
                    }
                    break;
                default:
                    result += getIntegerValue(romanNumbers[i]);
                    break;
            }
        }

        return result;
    }

    public static Integer getIntegerValue(Character... characters){
        StringBuilder sb = new StringBuilder();
        characters).forEach(
            (r) -> {
                sb.append(r);
            }
        );
        return romanNumberToIntegerMap.get(sb.toString());
    }

    public static void main(String[] args){
        int result = romanToInt("MCMXCIV");
        System.out.println("result: "+result);
    }
}
