package LINTCODE12;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1163 {
    /*Description
    *给定长度为偶数的整数数组，该数组中不同的数字代表不同种类的糖果， 每个数字表示一种糖果。
    * 您需要将这些糖果平均分配给弟弟和妹妹。 返回妹妹可以获得的糖果种类的最大数量。
    * */

    public int distributeCandies(int[] candies) {
        Set<Integer> set=new HashSet<>();
        for(int cur:candies)
            set.add(cur);
        return Math.min(set.size(),candies.length/2);
        // write your code here
    }
}
