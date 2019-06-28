package LINTCODE5;

import datastructure.Point;

import javax.lang.model.type.ArrayType;
import java.util.*;

public class LINTCODE434 {
    /*Description
    *给定 n, m, 分别代表一个二维矩阵的行数和列数, 并给定一个大小为 k 的二元数组A. 初始二维矩阵全0.
    * 二元数组A内的k个元素代表k次操作, 设第i个元素为 (A[i].x, A[i].y), 表示把二维矩阵中下标为A[i].x行A[i].y列的元素由海洋变为岛屿.
    *  问在每次操作之后, 二维矩阵中岛屿的数量. 你需要返回一个大小为k的数组.
    * */

    /*Solution
    * 每添加一个点需要判断它是否与周围的岛屿练成了一片
    * */




    int[][] near=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        if(operators==null||operators.length==0)
            return Collections.emptyList();
        List<Integer> result=new ArrayList<>();
        int currResult=0;
        int[] judge=new int[n*m];
        for(int i=0;i<judge.length;i++)
            judge[i]=-1;
        for(Point point:operators){
            int currIndex=point.x*m+point.y;
            if(judge[currIndex]==-1){
                judge[currIndex]=currIndex;
                currResult++;
            }

            for(int[] curNear:near){
                int x=point.x+curNear[0],y=point.y+curNear[1];
                int nearIndex=x*m+y;
                if(x<0||x>=n||y<0||y>=m||judge[nearIndex]==-1)
                    continue;
                if(getNumber(judge,currIndex)!=getNumber(judge,nearIndex)){
                    judge[getNumber(judge,nearIndex)]=getNumber(judge,currIndex);
                    currResult--;
                }
            }
            result.add(currResult);

        }
        return result;
    }

    private int getNumber(int[] nums,int index){
        return nums[index]==index?index:getNumber(nums,nums[index]);
    }
}
