package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1891 {

    /*Description
    * 有n个城市，给出邻接矩阵arr代表任意两个城市的距离。arr[i][j]代表从城市i到城市j的距离。Alice在周末制定了一个游玩计划，
    * 她从所在的0号城市开始，游玩其他的1~n-1个城市，最后回到0号。Alice想知道她能完成游玩计划需要行走的最小距离。
    * 返回这个最小距离。除了城市0之外每个城市只能经过一次。
    * */

    int result=Integer.MAX_VALUE;

    public int travelPlan(int[][] arr) {
        int number=arr.length;
        boolean[] reached=new boolean[number];
        reached[0]=true;
        function(arr,reached,0,1,0);
        return result;
        // Write your code here.
    }

    private void function(int[][] arr,boolean[] reached,int curSum,int curNumber,int curIndex){
        int length=reached.length;
        if(curNumber==length){
            result=Math.min(result,arr[curIndex][0]+curSum);
            return;
        }
        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            boolean[] curReached=reached.clone();
            curReached[i]=true;
            function(arr,curReached,curSum+arr[curIndex][i],curNumber+1,i);
        }
    }

}
