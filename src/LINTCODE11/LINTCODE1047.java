package LINTCODE11;

import java.util.*;

public class LINTCODE1047 {
    /*Description
    * 特殊的二进制序列是具有以下两个性质的二进制序列：0 的数量与 1 的数量相等。
    * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
    * 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。
    * （两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
    * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
    * */


    public String makeLargestSpecial(String S) {
        System.out.println(S);
        if(S.length()==0)
            return null;
        List<String> res=new ArrayList<>();
        int index=0;
        int start=0;
        for(int i=0;i<S.length();i++){
            index+=S.charAt(i)=='1'?1:-1;
            if(index==0){
                System.out.println(start+1+" "+i);
                System.out.println(S.substring(start+1,i));
                res.add('1'+makeLargestSpecial(S.substring(start+1,i)+'0'));
                start=i+1;
            }
        }
        Collections.sort(res);
        StringBuilder sb=new StringBuilder();
        for(int i=res.size()-1;i>=0;i--)
            sb.append(res.get(i));
        return sb.toString();
        // write your code here
    }

    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        list.add("1100");
        list.add("10");
        list.add("111000");
        list.add("11011000");
        list.add("11110000");
        Collections.sort(list);
        System.out.println(list);
    }
}
