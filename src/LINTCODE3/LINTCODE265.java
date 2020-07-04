package LINTCODE3;

public class LINTCODE265 {
    /*Description
    * 给定一个整数数组 A，找到一个具有最大和的连续子数组（子数组最少包含一个元素，
    * 并且 每个元素都必须是非负整数），返回其最大和
    * */

    public int maxNonNegativeSubArray(int[] A) {
        int result=-1;
        int length=A.length;
        for(int i=0;i<A.length;i++){
            if(A[i]<0)
                continue;
            int curSum=A[i];
            while(i+1>length&&A[i+1]>=0){
                curSum+=A[++i];
            }
            result=Math.max(result,curSum);
        }
        return result;
        // write your code here
    }
}
