package LINTCODE12;

public class LINTCODE1139 {
    /*Description
    * 给定一个长度为n的数组a，它有个子数组。请计算这些子数组的和，
    * 然后按照升序排列，并返回排序后第k个数。
    * */

    public long thekthSubarray(int[] a, long k) {
        int length=a.length;
        long[] sum=new long[length+1];
        for(int i=0;i<length;i++)
            sum[i+1]=sum[i]+a[i];
        long l=0,r=Long.MAX_VALUE-1;
        while(l<r){
            long mid=l+(r-l+1)/2;
            System.out.println(mid);
            if(isMatch(sum, mid, k))
                l = mid;
            else
                r = mid -1;
        }
        return l;
        // wrrite your code here
    }

    private boolean isMatch(long[] sum,long mid, long k){
        long count=0;
        for(int i=1;i<sum.length;i++){
            if(sum[i]-sum[i-1]>=mid)
                continue;
            int l=i,r=sum.length-1;
            while(l<r){
                int m=l+(r-l+1)/2;
                if(sum[m]-sum[i-1]<mid)
                    l=m;
                else
                    r=m-1;
            }
            count+=l-i+1;
        }
        return count<k;
    }

    public static void main(String[] args){
        int[] num=new int[]{2,3,1,4};
        long k =6L;
        System.out.println(new LINTCODE1139().thekthSubarray(num,k));
    }
}
