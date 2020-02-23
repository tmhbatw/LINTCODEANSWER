package LINTCODE14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1390 {
    /*Description
    * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
    * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
    * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
    * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
    * */

    public int minimumLengthEncoding(String[] words) {
        List<List<String>> list=new ArrayList<>();
        for(int i=1;i<=7;i++)
            list.add(new ArrayList<>());
        for(String cur:words){
            list.get(cur.length()-1).add(cur);
        }
        HashSet<String> set=new HashSet<>();
        List<String> curList=list.get(6);
        int result=0;
        for(String cur:curList){
            result+=8;
            for(int j=0;j<7;j++){
                set.add(cur.substring(j));
            }
        }
        System.out.println(set);
        for(int i=5;i>=0;i--){
            List<String> cur=list.get(i);
            for(String curr:cur){
                if(set.contains(curr))
                    continue;
                result+=i+2;
                for(int j=0;j<=i;j++){
                    set.add(curr.substring(j));
                }
            }
        }
        return result;
        //
    }
}
