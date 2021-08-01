package LINTCODE19;

import java.util.Stack;

public class LINTCODE1860 {
    /*Description
    * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 0 组成的子矩阵的个数。
    * */


    public long countSubmatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int[] res=new int[matrix[0].length];
        long result=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    res[j]+=1;
                }else
                    res[j]=0;
            }
            result += getCount(res);
        }
        return result;
        // write your code here
    }

    private long getCount(int[] cur){
        long count =0;
        Stack<int[]> stack=new Stack<>();
        stack.add(new int[]{-1,-1});
        for(int i=0;i<cur.length;i++){
            while(stack.peek()[0]>=cur[i]){
                int[] pop=stack.pop();
                count+=pop[0]*(i-pop[1])*(pop[1]-stack.peek()[1]);
            }
            stack.add(new int[]{cur[i],i});
        }
        while(!stack.isEmpty()){
            int[] pop=stack.pop();
            if(pop[0]==-1)
                break;
            count+=pop[0]*(cur.length-pop[1])*(pop[1]-stack.peek()[1]);
        }
        return count;
    }
}
