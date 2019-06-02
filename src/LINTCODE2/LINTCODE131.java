package LINTCODE2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE131 {

    /*Description
    *水平面上有 N 座大楼，每座大楼都是矩阵的形状，可以用一个三元组表示 (start, end, height)，分别代表其在x轴上的起点，终点和高度。大楼之间从远处看可能会重叠，求出 N 座大楼的外轮廓线。
    * 外轮廓线的表示方法为若干三元组，每个三元组包含三个数字 (start, end, height)，代表这段轮廓的起始位置，终止位置和高度。
    * */

    /*Solution
    *可以将建筑物形状保存在一个数组中，但是会超时
    * 于是选择动态规划，创建一个数组保存某一区间内的最大高度，然后输出即可依然超时
    *第三种方法：建立一个高度小根堆以及点小根堆，其中点小根堆的排序方式为先左后右先低后高
    * 小根堆用来保存建筑物的左边的边以及右边的边，左边的边高度为负
    * 因此每当读取出一个负数高的边时，将值输入高度小根堆中，当一个正数到达时，输出这个高度
    * 高度小根堆最顶堆即保存当前线段的最大高度
    * 将边界线输出即可
    * */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> result=new ArrayList<>();
        //用来保存建筑物信息
        PriorityQueue<Point> queue=new PriorityQueue<>((o1, o2) -> {
            if(o1.pos!=o2.pos)
                return o1.pos-o2.pos;
            return o1.height-o2.height;
        });
        //用来保存当前位置的最高高度,最低高度为0
        PriorityQueue<Integer> height=new PriorityQueue<>(Comparator.reverseOrder());
        height.add(0);
        for(int i=0;i<buildings.length;i++){
            queue.add(new Point(buildings[i][0],-buildings[i][2]));
            queue.add(new Point(buildings[i][1],buildings[i][2]));
        }
        int start=0,hei=0;
        while(!queue.isEmpty()){
            Point point=queue.poll();
            if(point.height<0){
                height.add(-point.height);
            }else{
                height.remove(point.height);
            }
            int currheight=height.peek();
            if(start==0){
                if(currheight!=0) {
                    start = point.pos;
                    hei=currheight;
                }
                continue;
            }else{
                if(currheight==hei)
                    continue;
                List<Integer> res=new ArrayList<>();
                res.add(start);
                res.add(point.pos);
                res.add(hei);
                result.add(res);
                if(currheight==0){
                    start=0;
                    hei=0;
                }else{
                    start=point.pos;
                    hei=currheight;
                }
            }
        }
        return result;
        // write your code here
    }
    class Point{
        int pos;
        int height;
        public Point(int pos,int height){
            this.pos=pos;
            this.height=height;
        }

    }


/*    public List<List<Integer>> buildingOutline(int[][] buildings) {
        int width=0;
        for(int i=0;i<buildings.length;i++){
            width=Math.max(width,buildings[i][1]);
        }
        int[] dp=new int[width+1];
        for(int i=0;i<buildings.length;i++){
            for(int j=buildings[i][0];j<buildings[i][1];i++){
                dp[j]=Math.max(dp[j],buildings[i][2]);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        int start=0;
        int height=0;
        for(int i=0;i<dp.length;i++){
            if(start==0){
                if(dp[i]==0)
                    continue;
                else{
                    start=i;
                    height=dp[i];
                }
            }
            else{
                if(dp[i]==height)
                    continue;
                List<Integer> res=new ArrayList<>();
                res.add(start);
                res.add(i);
                res.add(height);
                result.add(res);
                if(dp[i]==0){
                    start=0;
                    height=0;
                }else{
                    start=i;
                    height=dp[i];
                }

            }

        }
        return result;

        // write your code here
    }*/




/*    public List<List<Integer>> buildingOutline(int[][] buildings) {

        List<List<Integer>> result=new ArrayList<>();


        //构建一个数组用来保存重叠房屋的信息,首先找到数组的大小
        int height=0;
        int width=0;
        for(int i=0;i<buildings.length;i++){
            height=Math.max(height,buildings[i][2]);
            width=Math.max(width,buildings[i][1]);
        }
        boolean[][] dp=new boolean[height+2][width+2];

        //将建筑物信息读入数组中
        for(int i=0;i<buildings.length;i++){
            for(int w=buildings[i][0];w<buildings[i][1];w++){
                for(int h=1;h<=buildings[i][2];h++)
                    dp[h][w]=true;
            }
        }


        //将图中的数据输出即可
        int start=-1;
        height=-1;
        for(int i=0;i<dp[0].length;i++){
            int currheight=0;
            for(int j=1;j<dp.length;j++){
                if(!dp[j][i])
                    break;
                currheight++;
            }
            if(height==-1){
                if(currheight==0)
                    continue;
                height=currheight;
                start=i;
            }else {
                if(height==currheight)
                    continue;
                else {
                    List<Integer> res=new ArrayList<>();
                    res.add(start);
                    res.add(i);
                    res.add(height);
                    result.add(res);
                    if(currheight!=0){
                        height=currheight;
                        start=i;
                    }else{
                        height=-1;
                        start=-1;
                    }

                }

            }
        }
        return result;

    }*/
}
