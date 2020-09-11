package LINTCODE12;

import java.util.List;

public class LINTCODE1158 {
    /*Description
    * 小明有n*m个花盆，摆列成矩阵状，有c种颜色的花的种子，每一种颜色的花的种子有c[i]个，
    * 所有种子的数量等于花盆的数量，每个花盆只能种一朵花，小明想让每个花盆的相邻上下左右的花盆的花的颜色不能与这个花盆相同，请问能按照他的想法种花吗？
    * */
    public boolean Plantflowers(int n, int m, List<Integer> seeds) {
        int maxNumber=(n*m+1)/2;
        for(int cur:seeds){
            if(cur>maxNumber)
                return false;
        }
        return true;
        // write your code here
    }

}
