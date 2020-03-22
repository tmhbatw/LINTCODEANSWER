package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1809 {
    /*Description
    *给定数组A和长度K，返回最大长度为K的连续子数组，例如A = [6,6,2,9,7,6]，K = 5，总共将出现两个
    * 子数组a = [6,6,2,9,7]，b = [6,2,9,7,6]，第一个数组大于第二个数组，因为它们在索引为1时不相等且a [1] > b [1]。因此返回第一个数组。
    * */

    public int[] LargestContinguousSubarray(int[] A, int K) {
        int length=A.length;
        if(K>length)
            return new int[0];
        int[] result= Arrays.copyOfRange(A,0,K);
        for(int i=1;i<length-K+1;i++){
            int[] cur=Arrays.copyOfRange(A,i,i+K);
            if(compare(result,cur))
                result=cur;
        }
        return result;
        // write your code here
    }

    private boolean compare(int[] result,int[] cur){
        for(int i=0;i<result.length;i++){
            if(result[i]!=cur[i]){
                return result[i]<cur[i];
            }
        }
        return false;
    }

}
