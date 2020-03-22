package LINTCODE19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1859 {
    /*Description
    * 给定一个由N个整数组成的数组A，一次移动，我们可以选择此数组中的任何元素并将其替换为任何值。
    * 数组的振幅是数组A中的最大值和最小值之间的差。
    * 返回通过执行最多三次替换之后数组A的最小振幅
    * */

    public int MinimumAmplitude(int[] A) {
        int length=A.length;
        if(length <= 4) {
            return 0;
        }
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int res = A[length - 4] - A[0];
        res = Math.min(res, A[length - 3] - A[1]);
        res = Math.min(res, A[length - 2] - A[2]);
        res = Math.min(res, A[length - 1] - A[3]);
        return res;
    }

    public static void main(String[] args){
        int[] num=new int[]{-4,20,-16,-48,-47,50,-18,-27,-14,-45,-33,-32,-19,-40,1,40,43,-29
                ,16,-43,19,-49,36,-37,-14,-2,46,-19,45,-14,-26,8,-34,42,2,43,-18,-41,36,-7,38,
                37,43,-43,21,23,14,-19,12,10,5,-31,-20,-10,-18,44,45,0,9,-4,39,39,40,-39,48,
                -47,-20,-26,50,7,31,36,-18,29,24,30,-8,16,-39,-33,-41,-9,18,-9,30,19,-14,-16,3,
                -35,-10,31,-2,17,39,14,-17,42,-27,13};
    }




}
