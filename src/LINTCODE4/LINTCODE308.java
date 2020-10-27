package LINTCODE4;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE308 {
    /*Description
    *给定一个长为 n 的字符串，我们称长为 k 的有且只有 1 种重复字符的子串为特殊子串。
    * 请求出字符串中特殊子串的个数。
    * */

    public int specialSubstringCount(String str, int k) {
        int[] num=new int[26];
        for(int i=0;i<k-1;i++){
            char cur=str.charAt(i);
            num[cur-'a']++;
        }
        int result=0;
        for(int i=k-1;i<str.length();i++){
            char cur=str.charAt(i);
            num[cur-'a']++;
            if(isMatching(num))
                result++;
            num[str.charAt(i-k+1)-'a']--;
        }
        return result;
        // write your code here.
    }

    //用于判断字符串是否匹配我们的规则
    private boolean isMatching(int[] num){
        boolean flag=false;
        for(int cur:num){
            if(cur>=2){
                if(!flag){
                    flag=true;
                }else
                    return false;
            }
        }
        return flag;
    }
}
