package LINTCODE8;

import java.util.List;

public class LINTCODE784 {
    /*Description
    *给出n个字符串dic,和一个目标串，输出目标串与这n个字符串的最长公共前缀的长度的最大值。
    * */

    public int the_longest_common_prefix(List<String> dic, String target) {
        int res=0;
        for(String cur:dic){
            int curNum=Math.min(target.length(),cur.length());
            for(int i=0;i<target.length()&&i<cur.length();i++){
                if(cur.charAt(i)!=target.charAt(i)){
                    curNum=i;
                    break;
                }
            }
            res=Math.max(curNum,res);
        }
        return res;
        // write your code here
    }
}
