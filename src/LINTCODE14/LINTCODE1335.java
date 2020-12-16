package LINTCODE14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1335 {
    /*Description
    *所有DNA由一系列缩写为A，C，G和T的核苷酸组成，例如：“ACGAATTCCG”。 在研究DNA时，有时识别DNA中的重复序列是非常必要的。
    * 编写一个函数来查找DNA分子中，长度为10个字母的，不止一次出现的序列（子串）。
    * */

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Long> set=new HashSet<>();
        Set<Long> res=new HashSet<>();
        List<String> result=new ArrayList<>();
        if(s==null||s.length()<10)
            return result;
        Long number=0L;
        for(int i=0;i<9;i++){
            char cur=s.charAt(i);
            number=number*10+getVal(cur);
        }
        for(int i=9;i<s.length();i++){
            number=number*10+getVal(s.charAt(i));
            if(set.contains(number))
                res.add(number);
            else
                set.add(number);
            number%=1000000000;
        }
        for(Long curr:res)
            result.add(getRes(curr));
        return result;
        // write your code here
    }

    private int getVal(char cur){
        switch (cur){
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            default:
                return 4;
        }
    }

    private char getChar(int cur){
        switch (cur){
            case 1:
                return 'A';
            case 2:
                return 'C';
            case 3:
                return 'G';
            default:
                return 'T';
        }
    }

    private String getRes(Long cur){
        StringBuilder sb=new StringBuilder();
        while(cur!=0){
            char curr=getChar((int)(cur%10));
            cur/=10;
            sb.append(curr);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        long cur= 9999999999L;
        System.out.println(cur+" "+(int)cur);
    }

}
