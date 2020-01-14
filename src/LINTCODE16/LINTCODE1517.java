package LINTCODE16;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1517 {
    /*Description
    *给定一个由N个整数构成的数组A和一个整数K，
    * 从所有长度为K的A的连续子数组中返回最大的连续子数组。
    * 如果两个数组中的第一个不相等元素在A中的值大于B中的值，则我们定义子数组A大于子数组B。
    * 例如,A=[1,2,4,3]，B=[1,2,3,5].
    * A大于B，因为A [2]> B [2]。
    * */

    public int[] largestSubarray(int[] A, int K) {
        int start=0;
        for(int i=1;i<=A.length-K;i++){
            for(int j=0;j<K;j++){
                if(A[j+start]<A[i+j]){
                    start=i;
                    break;
                }else if(A[j+start]>A[i+j])
                    break;
            }
        }
        int[] result=new int[K];
        for(int i=0;i<K;i++)
            result[i]=A[start+i];
        return result;
        // Write your code here.
    }
}
