package LINTCODE10;

public class LINTCODE903 {
    /*Description
    * 假设你有一个长度为n的数组，数组的所有元素初始化为0，并且给定k个更新操作。
    * 每个更新操作表示为一个三元组：[startIndex, endIndex, inc]。
    * 这个更新操作给子数组 A[startIndex ... endIndex]（包括startIndex和endIndex）中的每一个元素增加 inc。
    * 返回执行k个更新操作后的新数组。
    * */

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] dp=new int[length+1];
        for(int[] cur:updates){
            dp[cur[0]]+=cur[2];
            dp[cur[1]+1]-=cur[2];
        }
        int[] result=new int[length];
        result[0]=dp[0];
        for(int i=1;i<length;i++){
            result[i]=result[i-1]+dp[i];
        }
        return result;
        // Write your code here
    }
}
