package LINTCODE4;

public class LINTCODE345 {
    /*Description
    * 因为小千数学加法考试不及格，作为惩罚，她的哥哥给她出了一道数学加法题。给定一个数组A，
    * 找到数组A中所有小于当前位置A[i]的数字，并求出所有小于A[i]的数字之和，保存在B[i]的位置上。小千还是不会这个题目，聪明的你能帮帮小千得到这个新的数组吗？
    * */

    public int[] getSum(int[] arr) {
        int max=0;
        for(int cur:arr)
            max=Math.max(max,cur);
        int[] dp=new int[max+1];
        for(int cur:arr)
            dp[cur]+=cur;
        for(int i=1;i<dp.length;i++)
            dp[i]+=dp[i-1];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                continue;
            arr[i]=dp[arr[i]-1];
        }
        return arr;
        // Write your code here.
    }
}
