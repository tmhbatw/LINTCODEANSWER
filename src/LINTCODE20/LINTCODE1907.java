package LINTCODE20;

public class LINTCODE1907 {
    /*Description
    * 给定一个正数数组，清算出的让所有元素相同的最小步数。
    * 每一步你可以选择一个元素，使得其他元素全部+1。
    * */

    public long arrayGame(int[] arr) {
        int min=Integer.MAX_VALUE;
        for(int cur:arr)
            min=Math.min(min,cur);
        long result=0;
        for(int cur:arr)
            result+=cur-min;
        return result;
        // write your code here
    }
}
