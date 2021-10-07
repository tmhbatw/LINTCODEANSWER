package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1019 {
    /*Description
    * 给定一个数组A，我们可以根据一个非负整数K将它旋转，使得数组变为A [K]，A [K + 1]，
    * A [K + 2]，... A [A.length - 1 ]，A [0]，A [1]，...，A [K-1]。 之后，任何小于或等于其索引的元素都值1分。
    * 例如，如果我们有[2,4,1,3,0]，我们使得K = 2，并进行旋转，它变为[1,3,0,2,4]。
    * 得分为3，因为1> 0 [0点]，3> 1 [0点]，0 <= 2 [1点]，2 <= 3 [1点]，4 <= 4 [1点]。
    * 在所有可能的旋转中，返回与我们可以获得最高分相对应的旋转指数K. 如果有多个相等的最高分，则返回最小的K.
    * */

    public int bestRotation(int[] A) {
        int length=A.length;

        //dp[i]表示左移i位时，大于的数值
        int[] dp=new int[length+1];

        for(int i=0;i<A.length;i++){
            //表示只有A[i]放在位置0到val-1之间的位置时，A[i]能贡献1分
            int val=A[i];
            if(val==0)
                continue;
            //这种情况需要左移
            if(i>=val-1){
                //开始的位置是(i-pos-1),结束的位置是i；
                dp[i-val+1]++;
                dp[i+1]--;
            }else{
                dp[0]++;
                dp[i+1]--;
                dp[length]--;
                dp[length-(val-1-i)]++;
            }
            //这种情况需要左移加右移
        }
        int val=dp[0];
        int result=0;
        for(int i=1;i<length;i++){
            dp[i]+=dp[i-1];
            if(dp[i]<val){
                val=dp[i];
                result=i;
            }
        }
        return result;
        // Write your code here
    }
}
