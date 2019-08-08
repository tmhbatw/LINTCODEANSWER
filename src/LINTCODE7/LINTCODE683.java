package LINTCODE7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LINTCODE683 {
    /*Description
    * 给出一个单词表和一条去掉所有空格的句子，根据给出的单词表添加空格, 返回可以构成的句子的数量,
    * 保证构成的句子中所有的单词都可以在单词表中找到.
    * */

    public int wordBreak3(String s, Set<String> dict) {
        s=getUpper(s);
        Iterator ii=dict.iterator();
        dict=new HashSet<>();
        while(ii.hasNext()){
            String cur= (String) ii.next();
            dict.add(getUpper(cur));
        }
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                String cur=s.substring(j,i+1);
                if(dict.contains(cur))
                    dp[i+1]+=dp[j];
            }
        }
        return dp[s.length()];
        // Write your code here
    }

    private static String getUpper(String cur){
        String res="";
        for(int i=0;i<cur.length();i++){
            char curr= (cur.charAt(i)<='Z'&&cur.charAt(i)>='A')? (char) (cur.charAt(i) - 'A' + 'a') :cur.charAt(i);
            res+=curr;
        }
        return res;
    }
}
