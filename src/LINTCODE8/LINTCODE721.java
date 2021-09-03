package LINTCODE8;

import com.sun.tools.internal.xjc.model.CNonElement;

public class LINTCODE721 {
    /*Description
    * 一个数是稀疏数如果这个数的 二进制表示 中没有相邻的 1，给出一个 n ，找出大于或等于 n 的最小的稀疏数。
    * eg. 5 (二进制表示为 101)是稀疏数，但是 6 (二进制表示为 110 ）不是稀疏数
    * */

    public int nextSparseNum(int x) {
        String s=Integer.toBinaryString(x);
        int notMatch=isMatch(s);
        if(notMatch==0)
            return x;
        //判断从哪一位开始不满足要求
        String res=getAddOne(s,notMatch);
        return Integer.parseInt(res,2);
        // write your code here
    }

    private String getAddOne(String s, int x){
        System.out.println(x);
        for(int j=x-1;j>=1;j--){
            if(s.charAt(j)=='0'&&s.charAt(j-1)=='0'){
                String result=s.substring(0,j);
                result += "1";
                for(int i=s.length()-j-1;i>0;i--){
                    result+="0";
                }
                return result;
            }
        }
        String result="1";
        for(int i=0;i<s.length();i++)
            result+="0";
        return result;
    }

    private int isMatch(String s){
        boolean preIsOne=true;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(preIsOne)
                    return i;
                preIsOne=true;
            }else
                preIsOne=false;
        }
        return 0;
    }

    public static void main(String[] args){
        int res=13;
        System.out.println(Integer.toBinaryString(res));
        int result=new LINTCODE721().nextSparseNum(res);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }
}
