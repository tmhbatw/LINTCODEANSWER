package LINTCODE12;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1179 {
    /*Description
    * 一个班中有N 个学生。他们中的一些是朋友，一些不是。他们的关系传递。例如，如果A是B的一个直接朋友，
    * 而B是C的一个直接朋友，那么A是C的一个间接朋友。我们定义朋友圈为一组直接和间接朋友。
    * 给出一个N*N 矩阵M表示一个班中学生的关系。如果m〔i〕〔J〕＝1，那么第i个学生和第j个学生是直接朋友，否则不是。你要输出朋友圈的数量。
    * */

    public int findCircleNum(int[][] M) {
        int length=M.length;
        int[] dp=new int[length];
        for(int i=0;i<length;i++)
            dp[i]=i;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(M[i][j]==1)
                    dp[getType(dp,j)]=getType(dp,i);
            }
        }
        Set<Integer> set=new HashSet<>();
        for(int num:dp)
            set.add(getType(dp,num));
        return set.size();
        // Write your code here
    }

    private int getType(int[] dp,int index){
        if(dp[index]!=index)
            return getType(dp,dp[index]);
        return index;
    }
}
