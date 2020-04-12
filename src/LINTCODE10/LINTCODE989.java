package LINTCODE10;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE989 {
    /*Description
    *一个长为 N 且下标从 0 开始的数组 A 包含 从 0 到 N - 1 的所有整数。找到并返回集合 S 的最大长度，
    * 其中S [i] = {A [i]，A [A [i]]，A [A [A [i]]]，...}受到以下规则的约束。
    * 假设 S 中的第一个元素以选择 index = i的元素A [i]开始，S中的下一个元素应该是A [A [i]]，
    * 然后是A [A [A [i]]] ... 通过这个类比，我们在S中出现重复元素之前就停止添加。
    * */

    public int arrayNesting(int[] nums) {
        int result=0;
        Set<Integer> set=new HashSet<>();
        int preSize=0;
        for(int i=0;i<nums.length;i++){
            int cur=i;
            while(!set.contains(cur)){
                set.add(cur);
                cur=nums[cur];
            }
            result=Math.max(result,set.size()-preSize);
            preSize=set.size();
        }
        return result;
        // Write your code here
    }
}
