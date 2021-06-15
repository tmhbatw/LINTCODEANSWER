package LINTCODE15;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1466 {
    /*Description
    * 商场里有n个礼盒,m个商品,你有k元钱，每个商品和礼盒都有一个对应的价值val[i]和费用cost[i]，
    * 对于每个商品,只有在购买了其对应的礼盒belong[i]后才能购买之。
    * 给出n,m,大小为n+m的数组val,cost和belong,输出在花费不超过k的情况下能得到的商品和礼盒的最大价值
    * */

    public int getAns(int n, int m, int k, int[] val, int[] cost, int[] belong) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int i=n;i<m+n;i++){
            list.get(belong[i]).add(i);
        }
        int[] dp=new int[k+1];
        for(int i=0;i<n;i++){
            int[] curDp=new int[k+1];
            for(int j=k;j>=cost[i];j--)
                curDp[j]=dp[j-cost[i]]+val[i];
            for(int idx:list.get(i)){
                for(int j=k;j>=cost[i]+cost[idx];j--){
                    curDp[j]=Math.max(curDp[j],curDp[j-cost[idx]]+val[idx]);
                }
            }
            for(int j=0;j<=k;j++)
                dp[j]=Math.max(dp[j],curDp[j]);
        }
        return dp[k];
        // Write your code here
    }
}
