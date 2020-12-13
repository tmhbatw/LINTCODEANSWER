package LINTCODE20;

import java.util.Arrays;

public class LINTCODE1909 {
    /*Description
    * 打车派单场景, 假定有N个订单，待分配给N个司机。每个订单在匹配司机前，会对候选司机进行打分，打分的结果保存在N*N的矩阵score，
    * 其中score[i][j]代表订单i派给司机j的分值。
    * 假定每个订单只能派给一位司机，司机只能分配到一个订单。求最终的派单结果，使得匹配的订单和司机的分值累加起来最大，并且所有订单得到分配。
    * */

    private int max=0;
    private int[] result;
    public int[] orderAllocation(int[][] score) {
        int time=score.length;
        result=new int[time];
        recursion(score,new boolean[time],0,new int[time],0);
        return result;
        // write your code here
    }

    private void recursion(int[][] score,boolean[] reached,int index,int[] curRes,int curMax){
        int length=score.length;
        if(index==length){
            if(curMax>max){
                result=curRes;
                max=curMax;
            }
            return;
        }
        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            boolean[] curReached=reached.clone();
            curReached[i]=true;
            int[] cur=curRes.clone();
            cur[index]=i;
            recursion(score,curReached,index+1,cur,curMax+score[index][i]);
        }
    }

}
