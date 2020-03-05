package LINTCODE16;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1589 {
    /*Description
    *你将得到一个字符串数组 A。
    * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是特殊等价的。
    * 一次移动包括选择两个索引 i 和 j，且 i ％ 2 == j ％ 2，交换 S[j] 和 S [i]。
    * 现在规定，A 中的特殊等价字符串组是 A 的非空子集 S，这样不在 S 中的任何字符串与 S 中的任何字符串都不是特殊等价的。
    * 返回 A 中特殊等价字符串组的数量。
    * */

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set=new HashSet<>();
        for(String cur:A){
            set.add(getMessage(cur));
        }
        return set.size();
        // write your code here
    }

    private String getMessage(String cur){
        if(cur.length()<=1)
            return cur;
        int[] num1=new int[26];
        for(int i=0;i<cur.length();i+=2){
            num1[cur.charAt(i)-'a']++;
        }
        int[] num2=new int[26];
        for(int i=1;i<cur.length();i+=2){
            num2[cur.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(num1[i]+" "+num2[i]+" ");
        }
        return sb.toString();
    }
}
