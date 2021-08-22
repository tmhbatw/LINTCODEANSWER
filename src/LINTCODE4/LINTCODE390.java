package LINTCODE4;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE390 {
    /*Description
    *给定一个整数矩阵 A, 它有如下特性:
    * 相邻的整数不同
    * 矩阵有 n 行 m 列，n和m不会小于3。
    * 对于所有的 i < n, 都有 A[i][0] < A[i][1] && A[i][m - 2] > A[i][m - 1]
    * 对于所有的 j < m, 都有 A[0][j] < A[1][j] && A[n - 2][j] > A[n - 1][j]
    * 我们定义一个位置 [i,j] 是峰值, 当且仅当它满足:
    * */

    public List<Integer> findPeakII(int[][] A) {
        int l=1,r=A.length-1;
        List<Integer> list=new ArrayList<>();
        while(l<r){
            int mid=(l+r)/2;
            int col=getMaxCol(A,mid);
            if(A[mid+1][col]>A[mid][col]){
                l=mid+1;
            }else if(A[mid-1][col]>A[mid][col]){
                r=mid-1;
            }else{
                list.add(mid);
                list.add(col);
                return list;
            }
        }
        list.add(l);
        list.add(getMaxCol(A,l));
        return list;
        // write your code here
    }

    private int getMaxCol(int[][] A, int row){
        int col=1;
        for(int j=2;j<A[0].length-1;j++){
            if(A[j][row]>A[row][col])
                col=j;
        }
        return col;
    }
}
