package LINTCODE11;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LINTCODE1030 {
    /*Description
    * 一个排序过的列表A，其中包含了1以及其他一些质数。然后，
    * 对于所有列表中p < q 的组合，我们进行除法操作，得到一个分数：p/q。
    * 请问，在所有的除法操作中，第K小的分数是哪个？ 将这个分数用一个数组的形式返回，
    * 即answer[0] = p， answer[1] = q。
    * */

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double l=0,r=1;
        int[] res=new int[2];
        Arrays.sort(A);
        while(l<r){
            double mid=(l+r)/2;
            res=new int[]{0,1};
            int count=getCount(A,res,mid);
            if(count<K){
                l = mid;
            }else if(count>K){
                r = mid;
            }else{
                break;
            }
        }
        return res;
        // write your code here
    }

    private int getCount(int[] A,int[] res, double mid){
        int count = 0;
        for(int i=0;i<A.length-1;i++){
            if(A[A.length-1]*mid<A[i])
                continue;
            int l=i+1,r=A.length-1;
            while(l<r){
                int m = (l+r+1)/2;
                if(A[m]*mid>A[i]){
                    r=m-1;
                }else
                    l=m;
            }
            count+=A.length-l;
            if(res[0]*A[l]-res[1]*A[i]<0){
                res[0]=A[i];
                res[1]=A[l];
            }
        }
        return count;
    }
}
