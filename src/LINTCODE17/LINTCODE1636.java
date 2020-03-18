package LINTCODE17;

import java.util.Arrays;

public class LINTCODE1636 {
    /*Description
    * 为了防止乘客在旅途中过于无聊，LQ航空公司决定在航班飞行过程中播放2部电影。由于飞机起降过程中不能播放电影，LQ航空公司必须保证两部电影加起来的时长小于等于飞行时长减去30分钟，
    * 同时又希望两部电影总长度尽量长。现在给定t代表航班飞行时长(分钟)，一个dur[]数组代表所有电影的时间长度，请从小到大分别输出两部电影的时长，如果有多组总时长一样的，
    * 选取包含单独最长的电影组。题目保证有解。
    * */

    public int[] aerial_Movie(int t, int[] dur) {
        t-=30;
        Arrays.sort(dur);
        int left=0,right=dur.length-1;
        int sum=0;
        int[] result=new int[2];
        while(left<right){
            int curSum=dur[left]+dur[right];
            if(curSum>t){
                right--;
                continue;
            }
            if(curSum>sum){
                sum=curSum;
                result[0]=dur[left];
                result[1]=dur[right];
            }
            left++;
        }
        return result;
        // Write your code here
    }
}
