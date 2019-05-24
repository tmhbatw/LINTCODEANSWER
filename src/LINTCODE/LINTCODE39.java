package LINTCODE;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE39 {
    /*Description
    * Given a rotated sorted array, recover it to sorted array in-place.
    * Challenge
    * In-place, O(1) extra space and O(n) time.
    * */

    /*Solution
    *遍历数组，将当前数字移入数组最后位置，并除去当前数
    * 直到成为一个顺序数组位置
    * */

    public void recoverRotatedSortedArray(List<Integer> nums) {
        int last=nums.get(0);
        while(true){
            if(last<=nums.get(0)){
                last=nums.get(0);
                nums.add(last);
                nums.remove(0);
            }else{
                break;
            }
        }
        // write your code here
    }


}
