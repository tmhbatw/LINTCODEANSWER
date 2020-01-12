package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1594 {
    /*Description
    * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
    * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
    * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
    * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
    * */

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0;
        for(int cur:A)
            sumA+=cur;
        int sum=sumA;
        for(int cur:B)
            sum+=cur;
        int diff=sum/2-sumA;
        int[] result=new int[2];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(B[j]-A[i]==diff) {
                    result[0] = A[i];
                    result[1]=B[j];
                    return result;
                }
            }
        }
        return result;
        // Write your code here.
    }
}
