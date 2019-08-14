package LINTCODE8;

public class LINTCODE761 {
    /*Description
    * 给一 非负 整数数组. 取数组中的一部分元素, 使得它们的和大于数组中其余元素的和, 求出满足条件的元素数量最小值
    * */

    public int minElements(int[] arr) {
        if(arr.length<=1)
            return arr.length;
        int sum=0;
        for(int num:arr)
            sum+=num;
        int target=sum/2+1;
        int curSum=0;
        int index=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            curSum+=arr[i];
            if(curSum<target)
                continue;
            while(curSum-arr[index]>=target){
                curSum-=arr[index++];
            }
            result=Math.min(result,i-index+1);
        }
        return result;
        // write your code here
    }
}
