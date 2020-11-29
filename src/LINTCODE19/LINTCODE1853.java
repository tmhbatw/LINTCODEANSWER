package LINTCODE19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1853 {
    /*Description
    * Twitter正在测试一种名为Pigeon的新工作处理服务。
    * Pigeon可以用任务实际持续时间的两倍处理任务，并且每个任务都有一个权重。
    * 此外，Pigeon在一个小时内只能服务一个有限的持续时间（最大运行时间）。
    * 给定Pigon服务的最大运行时间，任务的实际运行时间和权重，确定Pigon服务在一小时内可以实现的最大总权重。
    * 输入包括以下参数：
    * n: 任务数量
    * weights: 每个任务的权重
    * tasks: 每个任务实际持续时间
    * p: Pigeon一小时的最大运行时间
    * */

    public int maxWeight(int n, int[] weights, int[] tasks, int p) {
        int[] dp=new int[p+1];
        for(int i=0;i<n;i++){
            int time=tasks[i]*2;
            int weight=weights[i];
            for(int j=p;j>=0;j--){
                if(j>=time){
                    dp[j]=Math.max(dp[j-time]+weight,dp[j]);
                }
            }
        }
        return dp[p];
        // write your code here
    }
}
