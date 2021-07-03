package LINTCODE4;

import java.util.Arrays;

public class LINTCODE319 {
    /*Description
    * 给定一个长度为N的数组height代表N个人的身高
    * 请你选出一部分人组成方阵(即矩阵的行数与列数相同),并且每一行的人的身高差不超过2。
    * 请问最多能选取多少人参加方阵
    * */

    public int MaxPeopleNumber(int[] height) {
        Arrays.sort(height);
        int l=0,r=((int)Math.sqrt(height.length)+1);
        while(l<r){
            int mid=(l+r+1)/2;
            if(isMatch(height,mid))
                l=mid;
            else
                r=mid-1;
        }
        return l*l;
        // write your code here
    }

    private boolean isMatch(int[] height, int l){
        int count=0;
        int length=height.length;
        for(int i=0;i<length;i++){
            int num=1;
            int first=i;
            while(num<l&&i+1<length&&height[i+1]-height[first]<=2){
                num++;
                i++;
            }
            if(num==l)
                count++;
            else
                i=first;
        }
        return count>=l;
    }

    public static void main(String[] args){
        int[] num=new int[]{};
    }
}
