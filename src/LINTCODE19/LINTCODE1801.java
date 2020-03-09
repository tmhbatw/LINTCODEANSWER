package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1801 {
    /*Description
    *给定一个数组a，和一个目标值k，我们假定一个集合是合法的，需要满足如下两个条件：
    * 1、集合非空
    * 2、设集合中的元素最小值为min，最大值为max，要求min+max<=k
    * 现在，请问有多少个集合满足条件。输出满足的集合个数。 由于这个个数可能会很大，所以你只需要返回对1000000007取模的结果。
    * */

    public int theSumofLegalSet(int[] a, int k) {
        int mod=1000000007;
        int[] dp=new int[10001];
        dp[0]=1;
        for(int i=1;i<10001;i++)
            dp[i]=dp[i-1]*2%mod;
        Arrays.sort(a);
        int result=0;
        int length=a.length;
        for(int i=0;i<length;i++){
            if(a[i]*2>k)
                break;
            if(i==length-1||a[i]+a[i+1]>k) {
                result += 1;
                continue;
            }
            int left=i+1;
            int right=length-1;
            int mid=0;
            int target=k-a[i];
            while(left<=right){
                mid=left+(right-left)/2;
                if(a[mid]<=target&&(mid==length-1||a[mid+1]>target))
                    break;
                if(a[mid]<target)
                    left=mid+1;
                else
                    right=mid-1;
            }
            result+=dp[mid-i];
            result%=mod;
        }
        return result%mod;
        // Write your code here.
    }
}
