package LINTCODE14;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1351 {
    /*Description
    * 给定两个整数，分别表示分数的分子和分母，转换为小数并以字符串格式返回。
    * 如果得到循环小数，则将重复部分括在括号中。
    * */

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator%denominator==0)
            return numerator/denominator+"";
        StringBuilder result=new StringBuilder();
        result.append(numerator/denominator).append('.');
        numerator%=denominator;
        StringBuilder res=new StringBuilder();
        Map<Integer,Integer> map=new HashMap<>();
        int index=0;
        while(numerator!=0&&!map.containsKey(numerator)){
            map.put(numerator,index++);
            numerator*=10;
            res.append(numerator/denominator);
            numerator%=denominator;
        }
        if(numerator==0)
            return result.append(res).toString();
        index=map.get(numerator);
        result.append(res.substring(0,index));
        result.append('(').append(res.substring(index)).append(')');
        return result.toString();
        // write your code here
    }
}
