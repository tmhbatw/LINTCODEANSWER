package LINTCODE14;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1377 {
    /*Description
    * 给定长度k，找出字符串str里面所有长为k的子串。子串的字符不能重复，输出满足这样条件的子串数量(子串相同的只算1个)。
    * */

    public int findSubstring(String str, int k) {
        if(str==null||k>str.length()||k>26)
            return 0;
        int[] time= new int[26];
        for(int i=0;i<k-1;i++){
            time[str.charAt(i)-'a']++;
        }
        Set<String> set=new HashSet<>();
        for(int j=0;j<str.length()-k+1;j++){
            time[str.charAt(j+k-1)-'a']++;
            if(fit(time))
                set.add(str.substring(j,j+k));
            time[str.charAt(j)-'a']--;
        }
        return set.size();
        // Write your code here
    }

    private boolean fit(int[] time){
        for(int cur:time){
            if(cur>1)
                return false;
        }
        return true;
    }

}
