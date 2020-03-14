package LINTCODE15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE1494 {
    /*Description
    * 如果出现以下情况，序列X_1，X_2，...，X_n就像斐波纳契一样：n> = 3
    * 对于所有i + 2 <= n，有X_i + X_ {i + 1} = X_ {i + 2}
    * 给定形成序列的正整数的阵列A严格增加，找到A的最长的斐波那契样子序列的长度。如果不存在，则返回0。
    * （回想一下，通过从A中删除任意数量的元素（包括不删除）来从另一个序列A导出子序列，
    * 而不改变其余元素的顺序。例如，[3,5,8]是[3,4,5,6,7,8]的子序列。 ）
    * */

    public int lengthofLongestFibonacciSubsequence(int[] A) {
        Set<Integer> set=new HashSet<>();
        for(int cur:A)
            set.add(cur);
        int result=2;
        for(int i=0;i<A.length;i++){

            for(int j=i+1;j<A.length;j++){
                int num1=A[i];
                int num2=A[j];
                int curTime=2;
                while(set.contains(num1+num2)){
                    int temp=num2;
                    num2+=num1;
                    num1=temp;
                    curTime++;
//                    System.out.println(num1+"   "+num2+" "+curTime);
                }
                result=Math.max(curTime,result);
            }
        }
        return result;
        // Write your code here.
    }
}
