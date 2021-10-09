package LINTCODE15;

import java.util.Arrays;

public class LINTCODE1441 {
    /*Description
    * 给定一个长度为n 的数组a 和一个正整数k ，从数组中选择四个数，
    * 要求四个数的乘积小于等于k ，求方案总数。
    * */

    public long numofplan(int n, int[] a, int k) {
        int[] sum=new int[k+1];
        int[] num=new int[k+1];
        for(int i=0;i<n;i++){
            if(a[i]>k)
                continue;
            num[a[i]]++;
            for(int j=i+1;j<n;j++){
                long curSum= (long) a[i] *a[j];
                if(curSum<=k)
                    sum[(int) curSum]++;
            }
        }
        for(int i=1;i<=k;i++) {
            sum[i] += sum[i - 1];
            num[i] += num[i-1];
        }
        long result=0;
        for(int i=0;i<n;i++){
            if(a[i]>k)
                continue;
            for(int j=i+1;j<n;j++){
                int curResult=0;
                long curSum=(long)a[i]*a[j];
                if(curSum<=k){
                    curResult+=sum[(int) (k/curSum)];
                }
                curResult-=num[(int) (k/curSum/a[i])]+(k/curSum/a[i]>=a[i]?-1:0);
                curResult-=num[(int)(k/curSum/a[j])]+(k/curSum/a[j]>=a[j]?-1:0);
                if(curSum<=Math.sqrt(k))
                    curResult++;
                result+=curResult;
            }
        }
        return result/6;
        // Write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{2,4,9,4,3};
        System.out.println(new LINTCODE1441().numofplan(5,num,300));
    }
}
