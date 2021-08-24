package LINTCODE9;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE829 {
    /*Description
    * 给定一个pattern和一个字符串str，查找str是否遵循相同的模式。
    * 这里遵循的意思是一个完整的匹配，在一个字母的模式和一个非空的单词str之间有一个双向连接的模式对应。
    * (如果a对应s，那么b不对应s。例如，给定的模式= "ab"， str = "ss"，返回false）。
    * */

    boolean result=false;
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character,String> map1=new HashMap<>();
        Map<String,Character> map2=new HashMap<>();
        dfs(pattern,str,0,0,map1,map2);
        return result;
        // write your code here
    }

    public void dfs(String pattern, String str, int index1, int index2, Map<Character,String> map,Map<String,Character> map2){
        if(result)
            return;
        if(index1==pattern.length()&&index2==str.length()){
            result=true;
            return;
        }
        if(index1==pattern.length()||index2==str.length())
            return;
        char cur=pattern.charAt(index1);
        if(map.containsKey(cur)){
            String curr=map.get(cur);
            if(str.length()-index2<curr.length()||!str.startsWith(curr, index2)||map2.getOrDefault(curr,' ')!=cur)
                return;
            dfs(pattern,str,index1+1,index2+curr.length(),map,map2);
        }else{
            for(int j=index2+1;j<=str.length();j++){
                String curr=str.substring(index2,j);
                if(map2.containsKey(curr))
                    continue;
                map.put(cur,curr);
                map2.put(curr,cur);
                dfs(pattern,str,index1+1,j,map,map2);
                map.remove(cur);
                map2.remove(curr);
            }
        }
    }
}
