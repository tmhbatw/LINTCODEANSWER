package LINTCODE4;

import java.util.Arrays;

public class LINTCODE357 {
    /*Description
    *给定一个字符串 s
    * 我们令一个字符串的权值为一个字符串的最长对称前后缀长度。
    * 请求出 s 的所有子串的权值的总和。
    * 例如，"abcxyzcba" 的最长对称前后缀的长度为
    * 3，因为 “abc” 和 “cba” 对称。
    * */

    public static void main(String[] args){
        System.out.println(new LINTCODE357().suffixQuery("babcxyba"));
    }
    public long suffixQuery(String s) {
        int length=s.length();
        long result=0;
        boolean[][] reached=new boolean[length][length];
        for(int i=0;i<length;i++){
            char first=s.charAt(i);
            for(int j=i+1;j<length;j++){
                if(reached[i][j])
                    continue;
                if(first==s.charAt(j)){
                    int left=i+1,right=j-1;
                    while(left<right){
                        if(s.charAt(left)==s.charAt(right)){
                            reached[left][right]=true;
                            left++;
                            right--;
                        }
                        else
                            break;
                    }
                    if(left<right){
                        result+=getVal(1,left-i,left-i);
                    }else if(left==right)
                        result+=getVal(1,j-i+1,(j-i+2)/2)-1;
                    else
                        result+=getVal(2,j-i+1,(j-i+1)/2);

                }
                reached[i][j]=true;
            }
        }
        return result+s.length();
        // write your code here
    }

    private int getVal(int start,int end,int count){
        return (start+end)*count/2;
    }
}
