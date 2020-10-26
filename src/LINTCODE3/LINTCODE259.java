package LINTCODE3;

public class LINTCODE259 {
    /*Description
    * 现在给你一个正整数数组A和一个正整数k。
    * 希望你求出最大的因数d满足：
    * upper(a_0/d)+upper(a_1/d)+...+upper(a_{n-1}/d) >= k
    * 题目保证有解。
    * */

    public int FindDivisor(int[] A, int k) {
        int left=0,right=Integer.MAX_VALUE;
        while(left<=right){
            int mid=(right-left)/2+left;
            int cur=upperSum(A,mid);
            System.out.println(cur+" "+mid);
            if(cur>=k&&upperSum(A,cur-1)<k){
                return mid;
            }
            if(cur<k){
                right=mid-1;
            }else
                left=mid+1;
        }
        return left;
        //
    }

    private int upperSum(int[] num,int d){
        int result=0;
        for(int a:num)
            result+=upper(a,d);
        return result;
    }

    private int upper(int a, int d){
        return (a-1)/d+1;
    }
}
