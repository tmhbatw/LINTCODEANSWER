package LINTCODE;

import java.util.HashMap;

public class LINTCODE56 {

    /*Description
    * Given an array of integers, find two numbers such that they add up to a specific target number.
    * The function twoSum should return indices of the two numbers such that they add up to the target,
    * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
    * */

    /*Solution
    * 两次遍历,没什么好说的
    * 当然可以创建一个哈希表保存数组中的数
    * */

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return null;
        // write your code here
    }


}
