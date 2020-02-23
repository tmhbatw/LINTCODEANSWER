package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1207 {
    /*Description
    * 在LOL中，有一个叫做“提莫”的英雄，他的攻击能够让敌人艾希进入中毒状态。现在给定提莫的攻击时间点的升序序列，以及每次提莫攻击时的中毒持续时间，输出总的艾希中毒态的时间。
    * 假定提莫在每一个具体的时间片一开始就发动攻击，而且艾希立刻中毒。
    * */

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Arrays.sort(timeSeries);
        int length=timeSeries.length;
        int result=0;
        for(int i=0;i<length;i++){
            int curMax=timeSeries[i]+duration;
            result+=duration;
            while(i<length-1&&timeSeries[i+1]<curMax) {
                i++;
                curMax=timeSeries[i]+duration;
                result+=timeSeries[i]-timeSeries[i-1];
            }
        }
        return result;
        // Write your code here
    }
}
