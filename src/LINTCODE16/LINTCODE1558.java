package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1558 {
    /*Description
    * 给定一个数列，求一个最长的连续子数列，该数列的所有第i个数都有a[i]>=0、a[i+1]<=0、
    * a[i+2]>=0或a[i]<=0、a[i+1]>=0、a[i+2]<=0，即非负数和非正数交替出现，返回最长的长度。
    * */

    public int getLongest(int[] a) {
        int length=a.length;
        int[] dp1=new int[length+1];
        int[] dp2=new int[length+1];
        int result=0;
        for(int i=0;i<length;i++){
            if(a[i]>0){
                dp1[i+1]=dp2[i]+1;
            }else if (a[i]<0){
                dp2[i+1]=dp1[i]+1;
            }else{
                dp1[i+1]=dp2[i]+1;
                dp2[i+1]=dp1[i]+1;
            }
            result=Math.max(result,Math.max(dp1[i+1],dp2[i+1]));
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));
        return Math.max(dp1[length],dp2[length]);
        // Write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{1,-1,3,-2,4,-4,5,-1,0,1,-1,3,0,2,-1,0,1,-1};
        System.out.println(new LINTCODE1558().getLongest(num));
    }

}
