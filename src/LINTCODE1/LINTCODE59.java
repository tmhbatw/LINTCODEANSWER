package LINTCODE1;

import java.util.Arrays;

public class LINTCODE59 {
    /*Description
    * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
    * Challenge
    * O(n^2) 时间, O(1) 额外空间。
    * */

    /*Solution
    * 一次循环+两边向中间取两数之和法
    * */

    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        int result=numbers[0]+numbers[1]+numbers[2];
        for(int i=0;i<numbers.length;i++){
            int m=i+1,n=numbers.length-1;
            while(m<n){
                if(numbers[m]+numbers[n]==target-numbers[i]){
                    return target;
                }else if(numbers[m]+numbers[n]>target-numbers[i]){
                    result=Math.abs(numbers[m]+numbers[n]+numbers[i]-target)<Math.abs(result-target)?numbers[m]+numbers[n]+numbers[i]:result;
                    n--;
                }else{
                    result=Math.abs(numbers[m]+numbers[n]+numbers[i]-target)<Math.abs(result-target)?numbers[m]+numbers[n]+numbers[i]:result;
                    m++;
                }
            }
        }
        return result;
        // write your code here
    }
}
