package LINTCODE5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE402 {

    /*Solution
    * 给定一个整数数组，请找出一个连续子数组，使得该子数组的和最大。输出答案时
    * ，请分别返回第一个数字和最后一个数字的下标。（如果存在多个答案，请返回字典序最小的）
    * */


    /*Solution
    * 动态规划，额外使用一个数组保存开始坐标即可
    * */

    public List<Integer> continuousSubarraySum(int[] A) {
        if(A.length==0)
            return Collections.emptyList();
        int[] dp=new int[A.length+1];
        int[] start=new int[A.length+1];
        int max=Integer.MIN_VALUE;
        int result=0;
        for(int i=0;i<dp.length-1;i++){
            if(dp[i]>=0){
                dp[i+1]=dp[i]+A[i];
                start[i+1]=start[i];
            }else{
                dp[i+1]=A[i];
                start[i+1]=i;
            }
            if(dp[i+1]>max){
                max=dp[i+1];
                result=i;
            }
        }
        List<Integer> res=new ArrayList<>();
        res.add(start[result+1]);
        res.add(result);
        return res;
        // write your code here
    }
}
