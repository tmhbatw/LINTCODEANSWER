package LINTCODE8;

import java.util.*;

public class LINTCODE772 {
    /*Description
    * 给一字符串数组, 将 错位词(指相同字符不同排列的字符串) 分组
    * */

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return Collections.emptyList();
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String cur:strs){
            String sort=sortStr(cur);
            if(!map.containsKey(sort)){
                List<String> list=new ArrayList<>();
                list.add(cur);
                result.add(list);
                map.put(sort,list);
            }else{
                List<String> list=map.get(sort);
                list.add(cur);
                map.put(sort,list);
            }
        }
        return result;
        // write your code here
    }
    public String sortStr(String cur){
        char[] curr=cur.toCharArray();
        Arrays.sort(curr);
        return new String(curr);
    }
}
