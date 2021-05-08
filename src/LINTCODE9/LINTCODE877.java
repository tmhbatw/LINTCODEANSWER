package LINTCODE9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE877 {
    /*Description
    * 给定一个有n个整数的数组，判断是否存在满足以下条件的三元组 (i, j, k):
    * 0 < i, i + 1 < j, j + 1 < k < n - 1
    * 子数组 (0, i - 1)， (i + 1, j - 1)， (j + 1, k - 1)和(k + 1, n - 1) 的和相等。
    * 定义子数组(L, R)表示原始数组从元素下标为L到R的那一段。
    * 如果存在这样的三元组，返回 true，否则返回 false。
    * */

    public boolean splitArray(List<Integer> nums) {
        int length = nums.size();
        int[] num=new int[length];
        num[0]=nums.get(0);
        for(int i=1;i<length;i++){
            num[i]=nums.get(i)+num[i-1];
        }
        System.out.println(Arrays.toString(num));
        for(int j=3;j<length-3;j++){
            Set<Integer> set=new HashSet<>();
            for(int i=1;i<j-1;i++){
                if(num[i-1]==num[j-1]-num[i]){
                    set.add(num[i-1]);
                }
            }
            for(int k=j+2;k<length-1;k++){
                if(num[k-1]-num[j]==num[length-1]-num[k]&&set.contains(num[k-1]-num[j]))
                    return true;
            }
        }
        return false;
        // write your code here
    }
}
