package LINTCODE13;

public class LINTCODE1217 {
    /*Description
    * 两个整数之间的汉明距离是相应位不同的位置数。
    * 现在你的工作是找到所有给定数字对之间的总汉明距离。
    * */

    public int totalHammingDistance(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++){
            int time0=0;
            int time1=0;
            for(int num:nums){
                int cur=(num>>i)&1;
                if(cur==1)
                    time1++;
                else
                    time0++;
            }
            result+=time0*time1;
        }
        return result;
        // Write your code here
    }
}
