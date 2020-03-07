package LINTCODE18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1794 {
    /*Description
    * 给定一个整数数组，您的任务是计算重复数组元素的数量。 重复是被定义为两个或更多相同的元素。
    * 例如，在数组[1, 2, 2, 3, 3, 3]中，两个2是一个重复，三个3是一个重复。你需要返回一个数组，包含所有非唯一（重复）值的数字，且顺序与给定的数组相同。
    * */

    public List<Integer> CountDuplicates(List<Integer> nums) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        Set<Integer> res=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)) {
                set.add(num);
                continue;
            }
            if(!res.contains(num)){
                result.add(num);
                res.add(num);
            }
        }
        return result;
        // write your code here
    }
}
