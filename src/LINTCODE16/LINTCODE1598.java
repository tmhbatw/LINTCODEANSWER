package LINTCODE16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE1598 {
    /*Description
    * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
    * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
    * 返回所有不常用单词的列表。
    * 您可以按任何顺序返回列表。
    * */

    /*Solution
    * hash记数
    * */

    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String cur : a)
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        for (String cur : b)
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        List<String> result = new ArrayList<>();
        for (HashMap.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1) {
                result.add((String) entry.getKey());
            }
        }
        String[] res=new String[result.size()];
        for(int i=0;i<res.length;i++)
            res[i]=result.get(i);
        return res;
        // Write your code here.
    }
}
