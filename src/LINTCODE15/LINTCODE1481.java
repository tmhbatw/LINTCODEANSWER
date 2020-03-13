package LINTCODE15;

import java.util.*;

public class LINTCODE1481 {
    /*Description
    *给出一个字符串 s，找出所有的不同的长度为 k 的它的子串，并将结果按照字典序排序
    * */

    public List<String> uniqueSubstring(String s, int k) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++)
            set.add(s.substring(i,i+k));
        List<String> list=new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        return list;
        // Write your code here
    }
}
