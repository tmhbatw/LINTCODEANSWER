package LINTCODE18;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1796 {
    /*Description
    * 在此挑战中，您将获得一个整数数组，每个数组在数组中都是唯一的，并且整数表示目标差异。
    * 确定数组中元素对的数量，这些元素的差异等于目标差异。
    * 例如，考虑数组[1,3,5]和目标差异2.有两对：[1,3]和[3,5]，它们具有目标差异。您必须返回一个整数计数
    * 具有k的差异内的对的数量。
    * */

    public int KDifference(int[] nums, int target) {
        Set<Integer> set=new HashSet<>();
        for(int cur:nums)
            set.add(cur);
        int result=0;
        for(int num:nums)
            if(set.contains(num-target))
                result++;
        return result;
        // write your code here
    }
}
