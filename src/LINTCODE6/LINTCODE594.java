package LINTCODE6;

import java.util.Arrays;
import java.util.Scanner;

public class LINTCODE594 {
    /*Description
    * 实现时间复杂度为 O(n + m)的方法 strStr。
    * strStr 返回目标字符串在源字符串中第一次出现的第一个字符的位置.
    * 目标字串的长度为 m , 源字串的长度为 n . 如果目标字串不在源字串中则返回 -1。
    * */

    public int strStr2(String source, String target) {
        if(source==null||target==null)
            return -1;
        if(target.length()==0)
            return 0;
        int[] next=f(target);
        int i=-1,j=-1;
        while(i<source.length()){
            if(j==-1||source.charAt(i)==target.charAt(j)){
                i++;
                j++;
                if(j==target.length())
                    return i-j;
            }else{
                j=next[j];
            }
        }
        return -1;
        // write your code here
    }

    private int[] f(String target){
        int[] next=new int[target.length()];
        int k=-1;
        next[0]=-1;
        int j=0;
        while(j<target.length()-1){
            if(k==-1||target.charAt(k)==target.charAt(j)){
                next[++j]=++k;
            }else{
                k=next[k];
            }
        }
        return next;
    }

    public static void main(String[] args){
        String s="aabaabac";
        System.out.println(Arrays.toString(new LINTCODE594().f(s)));
    }
}
