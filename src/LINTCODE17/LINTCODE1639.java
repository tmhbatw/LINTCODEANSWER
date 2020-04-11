package LINTCODE17;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1639 {
    /*Description
    *给定字符串S和整数K.
    * 计算长度为K且包含K个不同字符的子串数
    * */

    public int KSubstring(String stringIn, int K) {
        if(stringIn.length()<K)
            return 0;
        int[] time=new int[128];
        for(int i=0;i<K-1;i++)
            time[stringIn.charAt(i)]++;
        Set<String> result=new HashSet<>();
        for(int i=K-1;i<stringIn.length();i++){
            time[stringIn.charAt(i)]++;
            if(isValid(time))
                result.add(stringIn.substring(i-K+1,i+1));
            time[stringIn.charAt(i-K+1)]--;
        }
        return result.size();
        //Write your code here
    }

    private boolean isValid(int[] time){
        for(int i=0;i<128;i++){
            if(time[i]>1)
                return false;
        }
        return true;
    }
}
