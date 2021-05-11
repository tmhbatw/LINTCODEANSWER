package LINTCODE9;

import java.util.Arrays;

public class LINTCODE884 {
    /*Description
    * 现在，给你一个由字符'D'和'I'构成的加密签名。'D'表示两个数字是递减关系，'I'表示两个数字是递增关系。
    * 我们的加密签名是由一个特殊的整数数组生成的。这个数组含有从1到n（n是加密签名的长度加1）的所有数字，并且每个数字只出现一次。
    * 举例来说，加密签名"DI"可以有数组[2,1,3]或者[3,1,2]生成，但是不能由数组[3,2,4]或者[2,1,3,4]生成。[3,2,4]和[2,1,3,4]都不能生成"DI"这个特定的加密签名。
    * 找到能够生成输入加密签名的[1, 2, ... n]的最小字典序的排列。
    * */

    public int[] findPermutation(String s) {
        int[] res=new int[s.length()+1];
        int length=s.length();
        int cur=1;
        int index=0;
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)=='D')
                break;
            res[index++]=cur++;
        }
        for(;i<s.length();i++){
            if(s.charAt(i)=='I'){
                if(i==length-1||(i<length-1&&s.charAt(i+1)=='I')) {
                    res[index++] = cur++;
                }
            }else{
                int count=1;
                while(i<length-1&&s.charAt(i+1)=='D') {
                    count++;
                    i++;
                }
                cur+=count;
                for(int j=0;j<=count;j++){
                    res[index++]=cur-j;
                }
                cur++;
            }
        }
        if(index<=s.length())
            res[index]=cur;
        return res;
        // write your code here
    }

    public static void main(String[] args){
        String s="IDIDDIDDIDDDDDIIDDIDIIIDDDIDIDDDDID";
        System.out.println(Arrays.toString(new LINTCODE884().findPermutation(s)));
    }
}
