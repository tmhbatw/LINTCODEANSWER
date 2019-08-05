package LINTCODE7;

import java.util.*;

public class LINTCODE684 {
    /*Description
    *给出两个字符串，你需要找到缺少的字符串
    * */

    public List<String> missingString(String str1, String str2) {
        String[] s1=str1.split(" ");
        String[] s2=str2.split(" ");
        HashSet<String> set=new HashSet<>();
        for(String cur:s2){
            set.add(cur);
        }
        List<String> res=new ArrayList<>();
        for(String cur:s1){
            if(!set.contains(cur))
                res.add(cur);
        }
        return res;
        // Write your code here
    }
}
