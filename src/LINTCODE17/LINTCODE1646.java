package LINTCODE17;

import java.util.*;

public class LINTCODE1646 {
    /*Description
    * 给一个单词s,和一个字符串集合str。这个单词每次去掉一个字母，直到剩下最后一个字母。求验证是否存在一种删除的顺序，这个顺序下所有的单词都在str中。
    * 例如单词是’abc’，字符串集合是{‘a’,’ab’,’abc’},如果删除的顺序是’c’,’b’，那么’abc’,’ab’,’a’都在集合中,就符合条件。输出这个组合是否符合条件.
    * */


    public boolean checkWord(String s, String[] str) {
        Set<String> set=new HashSet<>(Arrays.asList(str));
        Set<String> exist=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        if(set.contains(s)){
            exist.add(s);
            queue.add(s);
        }
        while(!queue.isEmpty()){
            String cur=queue.poll();
            if(cur.length()==1&&set.contains(cur))
                return true;
            for(int i=0;i<cur.length();i++){
                String curr=cur.substring(0,i)+cur.substring(i+1);
                if(exist.contains(curr)){
                    continue;
                }
                if(set.contains(curr)){
                    exist.add(curr);
                    queue.add(curr);
                }
            }
        }
        return false;
        // Write your code here
    }


}
