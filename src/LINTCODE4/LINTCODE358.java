package LINTCODE4;

public class LINTCODE358 {
    /*Description
    * 在一条直的马路上，有 nn 棵树，每棵树有一个坐标，代表它们距离马路起点的距离。
    * 如果每相邻的两棵树之间的间隔不小于 dd，那么我们认为这些树是美观的。
    * 请计算出最少移除多少棵树，可以让这些树变得美观。
    * */

    public int treePlanning(int[] trees, int d) {
        int pre=trees[0];
        int result=0;
        for(int i=1;i<trees.length;i++){
            if(trees[i]-pre<d){
                result++;
            }else
                pre=trees[i-1];
        }
        return result;
        // write your code here.
    }
}
