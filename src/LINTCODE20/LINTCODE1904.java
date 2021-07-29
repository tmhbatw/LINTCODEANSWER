package LINTCODE20;

import java.util.List;

public class LINTCODE1904 {
    /*Description
    * 在n个桶里放着一些小球，在一开始，第i个桶中的小球有A[i]个。
    * 你还将得到每个桶的容纳上限W，也就是说，第i个桶中存放的小球不能超过W[i]个。
    * 你每次可以从任意一个桶中拿走一个球，或者在任意一个桶中放置一个球。
    * 你最多执行k次操作，在小于等于k次操作后，你将进行如下计算：
    * 求出每一对相邻的桶（第0个桶和第1个桶，第1个桶和第2个桶，...，第n-2个桶和第n-1个桶）的绝对差值。
    * 你的任务是最小化这些绝对差值中最大值的平方，并将最后的答案返回。
    * */

    public int getAns(int n, int k, List<Integer> A, List<Integer> W) {
        if(n<=1)
            return 0;
        int l=0,r=100;
        while(l<r){
            int mid=(l+r)/2;
            if (isMatch(A, W, mid,k)){
                r=mid;
            }else{
                l= mid+1;
            }
        }
        return l*l;
        // write your code here
    }

    private boolean isMatch(List<Integer> A, List<Integer> W, int mid, int kk){
        int[][] time=new int[A.size()][101];
        for(int i=0;i<=W.get(0);i++)
            time[0][i]=Math.abs(i-A.get(0));
        for(int i=1;i<A.size();i++){
            for(int j=0;j<=W.get(i);j++){
                int min=Integer.MAX_VALUE;
                for(int k=Math.max(0,j-mid);k<=Math.min(W.get(i-1),j+mid);k++)
                    min=Math.min(min,time[i-1][k]);
                if(min==Integer.MAX_VALUE){
                    time[i][j]=min;
                    continue;
                }
                time[i][j]=Math.abs(j-A.get(i))+min;
            }
        }
        // System.out.println(mid);
        // for(int i=0;i<A.size();i++){
        //     for(int j=0;j<=W.get(i);j++){
        //         System.out.print(time[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int j=0;j<=W.get(W.size()-1);j++){
            if(time[W.size()-1][j]<=kk)
                return true;
        }

        return false;
    }
}
