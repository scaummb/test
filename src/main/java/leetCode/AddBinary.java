package leetCode;

import org.apache.commons.lang.StringUtils;

/**
 * Date: 2019/6/12 12 :36
 *
 * @author moubin.mo
 */

public class AddBinary {
    public static void main(String[] args){
        String a =  "100";
        String b = "110010";
        String result = addBinary(a, b);
        System.out.println("result="+result);
    }

    public static String addBinary(String a, String b) {

        if (a.equals("0") && b.equals("0")){
            return "0";
        }else if (a.equals("0")){
            return b;
        }else if (b.equals("0")){
            return a;
        }

        // 1.转为字符数组
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int maxLength = (charsA.length > charsB.length)?(charsA.length):(charsB.length) +1;

        // 2.递归解决
        String carryBit = "";
        char[] result = new char[maxLength +1]; //预留一个元素空间
        for (int i = 0;i < maxLength;i++){
            String charA = "0";
            String charB = "0";

            // 3.逐个比较。数组未越界则赋值
            if (charsA.length > i){
                charA = String.valueOf(charsA[charsA.length-1 -i]);
            }
            if (charsB.length > i){
                charB = String.valueOf(charsB[charsB.length-1 -i]);
            }

            // 4.递归解决
            String sum = countAB(charA, charB,carryBit);
            if (sum != null){
                switch (sum){
                    case "0": carryBit = "0";result[maxLength-i] = Character.valueOf('0'); break;
                    case "1": carryBit = "0";result[maxLength-i] = Character.valueOf('1'); break;
                    case "10":carryBit = "1";result[maxLength-i] = Character.valueOf('0'); break;
                    case "11":carryBit = "1";result[maxLength-i] = Character.valueOf('1'); break;
                    default:
                }
            }
        }

        // 5.比较最高位是否有进位
        if (carryBit.equals("1")){
            result[0] = '1';
        }
        String string = new String(result);
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i=0;i<string.length();i++){
            if (result[i] > Character.valueOf('0')){
                flag = true;
            }
            if (flag){
                stringBuilder.append(result[i]);
            }
        }

        return stringBuilder.toString();
    }

    // 位运算
    public static String countAB(String a, String b, String carryBit) {
        String result = "0";

        // 1.字符串余位判断（当有一个序列遍历结束）
        if (StringUtils.isEmpty(a)){
            result = b;
        }
        if (StringUtils.isEmpty(b)){
            result = a;
        }

        // 2.运算位判断
        if ("1".equals(a) && "1".equals(b)){
            result = "10";
        }
        if ("0".equals(a)){
            result = b;
        }
        if ("0".equals(b)){
            result = a;
        }

        // 3.进位判断
        if ("1".equals(carryBit)){
            switch (result){
                case "0": result = "1";break;
                case "1": result = "10";break;
                case "10": result = "11";break;
                default:
            }
        }

        return result;
    }
}
