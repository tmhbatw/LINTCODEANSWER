package LINTCODE15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LINTCODE1484 {
    /*Description
    * 给出一个字符串s，表示小说的内容，再给出一个list表示这些单词不参加统计，求字符串中出现频率最高的单词(如果有多个，返回字典序最小的那个)
    * */

    public String frequentWord(String s, Set<String> excludewords) {
        Map<String,Integer> map=new HashMap<>();
        int length=s.length();
        int max=0;
        String result="";
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur<='Z'&&cur>='A'||cur<='z'&&cur>='a'){
                StringBuilder sb=new StringBuilder();
                sb.append(cur);
                while(i<length-1&&(s.charAt(i+1)<='z'&&s.charAt(i+1)>='a'||s.charAt(i+1)<='Z'&&s.charAt(i+1)>='A')){
                    i++;
                    sb.append(s.charAt(i));
                }
                String curr=sb.toString();
                if(!excludewords.contains(curr)){
                    int time=map.getOrDefault(curr,0)+1;
                    if(time>max){
                        max=time;
                        result=curr;
                    }
                    if(time==max&&curr.compareTo(result)<0)
                        result=curr;
                    map.put(curr,time);
                }
            }
        }
        return result;
        // Write your code here
    }
}
