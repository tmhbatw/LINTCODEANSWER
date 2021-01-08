package LINTCODE19;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1824 {
    /*Description
    * 给定一个字符串，我们想知道满足以下两个条件的子串最多出现了多少次：子串的长度在[minLength,maxLength]之间
    * 子串的字符种类不超过maxUnique写一个函数 getMaxOccurrences ，其返回满足条件的子串最多出现次数。
    * */

    //与子串的最大长度其实无关
    public int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
        int[] num=new int[26];
        for(int i=0;i<minLength-1;i++){
            num[s.charAt(i)-'a']++;
        }
        Map<String,Integer> map=new HashMap<>();
        for(int i=minLength-1;i<s.length();i++){
            num[s.charAt(i)-'a']++;
            if(isTrue(num,maxUnique)) {
                String cur=s.substring(i-minLength+1,i+1);
                map.put(cur,map.getOrDefault(cur,0)+1);
            }
            num[s.charAt(i-minLength+1)-'a']--;
        }
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            result=Math.max(result,(int)entry.getValue());
        }
        return result;
        // write your code here
    }

    private boolean isTrue(int[] num,int maxUnique){
        for(int i=0;i<26;i++){
            if(num[i]!=0)
                maxUnique--;
        }
        return maxUnique>=0;
    }
}
