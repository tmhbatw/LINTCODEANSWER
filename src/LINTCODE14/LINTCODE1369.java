package LINTCODE14;

import java.util.HashMap;
import java.util.HashSet;

public class LINTCODE1369 {

    /*Description
    *给定一个段落和一组限定词，返回最频繁的非限定单词。已知至少有一个单词是非限定的，并且答案唯一。
    * 限定词都是以小写字母给出，段落中的单词大小写不敏感。结果请返回小写字母。
    * */

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set=new HashSet<>();
        for(String cur:banned)
            set.add(cur.toLowerCase());
        String[] para=paragraph.split(" ");
        HashMap<String,Integer> map=new HashMap<>();
        for(String cur:para){
            cur=cur.toLowerCase();
            char curr=cur.charAt(cur.length()-1);
            if(curr>'z'||curr<'a')
                cur=cur.substring(0,cur.length()-1);
            if(!set.contains(cur)) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int max=Integer.MIN_VALUE;
        String res="";
        for(HashMap.Entry entry:map.entrySet()){
            if((int)entry.getValue()>max) {
                res = (String) entry.getKey();
                max= (int) entry.getValue();
            }
        }
        return res;
    }
}
