package LINTCODE16;

import java.util.*;

public class LINTCODE1592 {
    /*Description
    * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
    * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
    * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
    * 返回 words 中与给定模式匹配的单词列表。
    * */

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list=new ArrayList<>();
        int length=pattern.length();
        for(String cur:words) {
            if (cur.length()!=length)
                continue;
            if(isPattern(cur,pattern))
                list.add(cur);
        }
        return list;
        // Write your code here.
    }

    private boolean isPattern(String cur,String pattern){
        Map<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            if(map.containsKey(curr)){
                if(map.get(curr)!=pattern.charAt(i))
                    return false;
            }else{
                char pat=pattern.charAt(i);
                if(set.contains(pat))
                    return false;
                map.put(curr,pat);
                set.add(pat);
            }
        }
        return true;
    }
}
