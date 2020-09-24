package LINTCODE9;

import java.util.Arrays;

public class LINTCODE863 {
    /*Description
    * 如果一个树的深度小于5，那么这个树可以用一个三位整数的列表表示。
    * 对于列表中的每一个整数：
    * 百位数表示当前节点的深度D，1 <= D <= 4。
    * 十位数表示当前节点在当前层的位置P，1 <= P <= 8。这个位置相当于是在它在满二叉树中的位置。
    * 个位数表示当前节点的值V，0 <= V <= 9。
    * 给定一个升序的三位整数的列表，它表示一个深度小于5的二叉树。你需要返回从根结点到叶子节点的所有路径的和。
    * */

    public int pathSum(int[] nums) {
        int[][] num=new int[5][9];
        for(int i=0;i<5;i++){
            Arrays.fill(num[i],-1);
        }
        for(int cur:nums){
            int i=cur/100;
            cur%=100;
            int j=cur/10;
            num[i][j]=cur%10;
        }
        return getRes(0,1,1,num);
        // write your code here
    }

    private int getRes(int preSum,int height,int i,int[][] num){
        if(height==4||num[height+1][i*2]==-1&&num[height+1][i*2-1]==-1)
            return preSum+num[height][i];
        int result=0;
        if(num[height+1][i*2]!=-1)
            result+=getRes(preSum+num[height][i],height+1,i*2,num);
        if(num[height+1][i*2-1]!=-1)
            result+=getRes(preSum+num[height][i],height+1,i*2-1,num);
        return result;
    }
}
