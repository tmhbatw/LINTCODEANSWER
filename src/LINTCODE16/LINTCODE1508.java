package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1508 {
    /*Description
    * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
    * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
    * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
    * 返回尽可能高的分数。
    * */
    public int matrixScore(int[][] A) {
        for(int[] cur:A){
            if(cur[0]==0)
                reverse(cur);
        }
        int length=A[0].length;
        int time=A.length;
        int result= (int) (Math.pow(2,length-1)*time);
        for(int i=1;i<A[0].length;i++){
            int times=0;
            for(int j=0;j<A.length;j++){
                if(A[j][i]==1)
                    times++;
            }
            result+=Math.max(time-times,times)*Math.pow(2,length-i-1);
        }
        return result;
        // Write your code here.
    }

    private void reverse(int[] cur){
        for(int i=0;i<cur.length;i++)
            cur[i]=cur[i]==0?1:0;
    }


}
