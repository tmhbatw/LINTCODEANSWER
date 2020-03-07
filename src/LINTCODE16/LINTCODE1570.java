package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1570 {
    /*Description
    *两个人在一个矩阵中选数字，每个人都最优的去选择数字，被选过的列就不能再被选了，返回最后两个人的分数差
    * */

    public int MatrixGame(int[][] grids) {
        if(grids.length==0)
            return 0;
        int[] res=new int[grids[0].length];
        for(int j=0;j<grids[0].length;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<grids.length;i++){
                max=Math.max(max,grids[i][j]);
            }
            res[j]=max;
        }
        boolean flag=true;
        Arrays.sort(res);
        int result=0;
        for(int j=res.length-1;j>=0;j--){
            result+=flag?res[j]:-res[j];
            flag=!flag;
        }
        return result;
        // write your code here
    }
}
