package LINTCODE18;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1726 {
    /*Description
    * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
    * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
    * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
    * 你可以按任意顺序以列表形式返回 A 中所有的通用单词。
    * */

    public List<String> wordSubsets(String[] A, String[] B) {
        int length=B.length;
        int[][] num=new int[length][26];
        for(int i=0;i<length;i++)
            num[i]=getNum(B[i]);
        List<String> result=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int[] cur=getNum(A[i]);
            boolean flag=true;
            for(int j=0;j<length;j++){
                if(!contains(cur,num[j])) {
                    flag=false;
                    break;
                }
            }
            if(flag)
                result.add(A[i]);
        }
        return result;
        // write your code here
    }

    private boolean contains(int[] num1,int[] num2){
        for(int i=0;i<26;i++){
            if(num1[i]<num2[i])
                return false;
        }
        return true;
    }

    private int[] getNum(String cur){
        int[] num=new int[26];
        for(int i=0;i<cur.length();i++)
            num[cur.charAt(i)-'a']++;
        return num;
    }
}
