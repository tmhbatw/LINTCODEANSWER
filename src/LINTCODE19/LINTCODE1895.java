package LINTCODE19;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE1895 {
    /*Description
    *今天有N个面试者需要面试，公司安排了两个面试的城市A和B，每一个面试者都有到A城市的开销costA和到B城市的开销costB。
    * 公司需要将面试者均分成两拨，使得total cost最小。
    * */

    public int TotalCost(int[][] cost) {
        int number=cost.length/2;
        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int oo1=o1[0]-o1[1];
                int oo2=o2[0]-o2[1];
                return oo1-oo2;
            }
        });
        int res=0;
        for(int i=0;i<number;i++){
            res+=cost[i][0];
            res+=cost[i+number][1];
        }
        return res;
        // write your code here
    }
}
