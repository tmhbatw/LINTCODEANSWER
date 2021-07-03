package LINTCODE16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1507 {
    /*Description
    * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
    * 如果没有和至少为 K 的非空子数组，返回 -1 。
    * */

    public int shortestSubarray(int[] A, int K) {
        int result=Integer.MAX_VALUE;
        List<int[]> q=new ArrayList();
        int curSum=0;
        q.add(new int[]{0,-1});
        for(int i=0;i<A.length;i++){
            curSum+=A[i];
            if(curSum-q.get(0)[0]>=K){
                int l=0,r=q.size()-1;
                while(l<r){
                    int mid = l+(r-l+1)/2;
                    if(curSum-q.get(mid)[0]>=K)
                        l=mid;
                    else
                        r=mid-1;
                }
                result=Math.min(result,i-q.get(l)[1]);
            }
            for(int j=q.size()-1;j>=0;j--){
                if(q.get(j)[0]<curSum)
                    break;
                q.remove(j);
            }
            q.add(new int[]{curSum,i});
        }
        return result==Integer.MAX_VALUE?-1:result;
        // Write your code here.
    }
}
