package LINTCODE11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LINTCODE1071 {
    /*Description
    *给出一系列字符串单词表示一个英语词典，找到字典中最长的单词，这些单词可以通过字典中的其他单词每次增加一个字母构成。
    * 如果有多个可能的答案，则返回字典顺序最小的那个。
    * 如果没有答案，则返回空字符串。
    * */

    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        int maxLength=Integer.MIN_VALUE;
        String result="";
        for(String cur:words){
            if(cur.length()<maxLength)
                continue;
            boolean flag=true;
            for(int i=0;i<cur.length()-1;i++){
                String curr=cur.substring(0,i+1);
                if(!set.contains(curr)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(maxLength<cur.length()){
                    maxLength=cur.length();
                    result=cur;
                }else{
                    result=result.compareTo(cur)<0?result:cur;
                }
            }
        }
        return result;
        // Write your code here
    }

}
