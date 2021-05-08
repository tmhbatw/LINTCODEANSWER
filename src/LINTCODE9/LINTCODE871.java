package LINTCODE9;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE871 {
    /*Description
    * 给定一个正整数a，找到最小的正整数b，它的每个数字相乘之后等于a。
    * 如果没有答案，或者答案超过了32位有符号整型的范围，返回0。
    * */

    public int smallestFactorization(int a) {
        if(a==1)
            return 1;
        List<Integer> list=new ArrayList<>();
        for(int i=9;i>=2;i--){
            while(a%i==0){
                a/=i;
                list.add(i);
            }
        }
        if(a>1)
            return 0;
        long result=0;
        for(int i=list.size()-1;i>=0;i--){
            result=result*10+list.get(i);
        }
        return result>Integer.MAX_VALUE?0:(int) result;
        // Write your code here
    }
}
