package LINTCODE16;

import java.util.List;

public class LINTCODE1564 {
    /*Description
    * 给定一个包含若干个区间的List数组, 区间的长度是 1000, 例如 [500,1500], [2100,3100].
    * 给定一个 number ,请问number是否在这些区间内.返回 True 或 False.
    * */

    public String isInterval(List<List<Integer>> intervalList, int number) {
        for(List<Integer> list:intervalList){
            if(number<=list.get(1)&&number>=list.get(0))
                return "True";
        }
        return "False";
        // Write your code here
    }
}
