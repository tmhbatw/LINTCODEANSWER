package LINTCODE19;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1877 {
    /*Description
    * 如果删除掉序列中的一个数字，剩下的数字出现次数相同，那么这个序列就叫做超级序列。
    * 给定一个整数数组，找出其中最长的子序列，使得其是一个超级序列。
    * 数组长度小于等于3000，数组中每一个元素小于等于 3000。
    * */

    public int[] longestSuperSequence(int[] nums) {
        int[] num = new int[3001];
        for(int cur:nums)
            num[cur]++;
        int[] time=new int[3001];
        for(int cur:num) {
            time[cur]++;
        }
        int length=nums.length;
        int max = 0;
        int timePerNum = 0;
        int largerThanCurTime = 0;
        for(int i = 3000; i >= 0;i--){
            largerThanCurTime += time[i];
            int curSumTime = largerThanCurTime * i;
            if(curSumTime > max && (i ==1 ||curSumTime < length)){
                max = curSumTime;
                timePerNum = i;
            }
        }
        List<Integer> list=new ArrayList<>();
        boolean flag = true;
        int[] dp=new int[3001];
        for(int cur:nums){
            if(num[cur]>=timePerNum&&dp[cur]<timePerNum){
                list.add(cur);
                dp[cur]++;
            }
            else if (flag){
                flag = false;
                list.add(cur);
            }
        }
        int[] result=new int[list.size()];
        for(int i=0;i<result.length;i++)
            result[i]= list.get(i);
        return result;
        // write your code here
    }
}
