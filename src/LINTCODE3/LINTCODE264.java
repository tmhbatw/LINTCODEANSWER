package LINTCODE3;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE264 {
    /*Description
    * 给定一个由 2 或 4 组成的数组。如果一个数组的子数组 (子数组是数组中相邻的一组元素且不能为空) 符合以下条件，则称为“通用”:
    * 2 和 4 被连续分组(如[4, 2],[2, 4],[4, 4, 2, 2],[2, 2, 4, 4],[4, 4, 4, 2, 2, 2]等等)。
    * 子数组中 4 的个数等于子数组中 2 的个数。
    * 相同元素但位置不同的子数组视为不同，如数组[4, 2, 4, 2]中有两个[4, 2]子数组。
    * 你需要返回一个整数值，即给定数组中“通用”子数组的数量。
    * */

    public int subarrays(int[] array) {
        List<Integer> list=new ArrayList<>();
        int length=array.length;
        for(int i=0;i<length;i++){
            int time=1;
            while(i<length-1&&array[i+1]==array[i]){
                i++;
                time++;
            }
            list.add(time);
        }
        System.out.println(list);
        int result=0;
        for(int i=1;i<list.size();i++)
            result+=Math.min(list.get(i),list.get(i-1));
        return result;
        // write your code here.
    }
}
