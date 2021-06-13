package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1232 {
    /*Description
    * 在二维空间中有许多球形气球。 对于每个气球，提供的输入是水平直径的起点和终点坐标。
    * 由于它是水平的，因此y坐标无关紧要，因此直径的起点和终点的x坐标就足够了。 起点总是小于终点。 最多将有10^4个气球。
    * 可以沿x轴从不同点垂直向上发射箭头。 如果xstart≤x≤xend，则坐标为xstart和xend的气球被在x处发射的箭头戳爆。
    *  可以发射的箭头数量没有限制。 一次射击的箭头一直无限地向上移动。 问题是要找到戳破所有气球的最小发射箭头数。
    *    * */

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(o1,o2)->o1[1]-o2[1]);
        int pre=Integer.MIN_VALUE;
        int result=0;
        for(int[] cur:points){
            if(cur[0]<=pre)
                continue;
            result++;
            pre=cur[1];
        }
        return result;
        // Write your code here
    }
}
