package LINTCODE15;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1433 {
    /*Description
    * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
    * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
    * （请注意，转换不包括向任何方向旋转。）
    * 最大可能的重叠是什么？
    * */

    public int largestOverlap(int[][] A, int[][] B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    for(int m=0;m<B.length;m++){
                        for(int n=0;n<B[0].length;n++){
                            if(B[m][n]==1) {
                                int cur = ((m - i)) * 100 + (n - j);
                                map.put(cur, map.getOrDefault(cur, 0) + 1);
                            }
                        }
                    }
                }
            }
        }
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            result=Math.max(result,(int)entry.getValue());
        }
        return result;
        // Write your code here.
    }
}
