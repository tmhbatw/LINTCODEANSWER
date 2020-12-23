package LINTCODE4;

import java.util.Arrays;

public class LINTCODE339 {
    /*Description
    * 给定一个长度为N的整数数组arr
    * 返回一个长度为N的整数答案数组ans
    * ans[i]表示删除arr数组第i个数后，arr数组的中位数
    * */

    /*Solution
    * 注意：N为偶数
    * */
    public int[] getMedian(int[] arr) {
        int[] cur=arr.clone();
        Arrays.sort(cur);
        int length=arr.length;
        int median1=cur[length/2-1];
        int median2=cur[length/2];
        int[] result=new int[length];
        for(int i=0;i<length;i++){
            if(arr[i]<=median1)
                result[i]=median2;
            else
                result[i]=median1;
        }
        return result;
        // write your code here
    }
}
