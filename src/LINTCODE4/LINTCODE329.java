package LINTCODE4;

import java.util.Collections;
import java.util.List;

public class LINTCODE329 {
    /*Description
    * 给定一个正整数数组arr，和一个正整数num
    * 遍历该正整数数组arr，如果当前的num和当前遍历的元素相同，则num变为本身的2倍
    * 现在请你对arr数组重排，使得最终的num最大
    * */

    public long maxNum(List<Integer> arr, int num) {
        Collections.sort(arr);
        long nums=num;
        for(int cur:arr){
            if(nums==cur)
                nums*=2;
        }
        return nums;
        // write your code here
    }
}
