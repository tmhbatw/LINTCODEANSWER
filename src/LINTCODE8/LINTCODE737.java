package LINTCODE8;

import java.util.HashSet;

public class LINTCODE737 {
    /*Description
    * 给一矩阵, 找到矩阵中每一行都出现的元素. 你可以假设矩阵中只有一个满足条件的元素.
    * */

    public int FindElements(int[][] Matrix) {
        HashSet<Integer> last=new HashSet<>();
        for(int i=0;i<Matrix[0].length;i++){
            last.add(Matrix[0][i]);
        }
        for(int i=1;i<Matrix.length;i++){
            HashSet<Integer> cur=new HashSet<>();
            for(int j=0;j<Matrix[0].length;j++){
                if(last.contains(Matrix[i][j]))
                    cur.add(Matrix[i][j]);
            }
            last=cur;
        }
        return last.iterator().next();
        // write your code here
    }
}
