package LINTCODE1;

import java.util.ArrayList;
import java.util.Arrays;

public class LINTCODE42 {
    /*Description
    *给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
    * 每个子数组的数字在数组中的位置应该是连续的。
    * 返回最大的和。
    * */

    /*Solution
    * 创建两个数组
    * 第一个数组从nums的左边遍历，保存从0到当前下标最大的和
    *第二个数组从nums的右边遍历，保存从nums.size()-1到当前下标最大的连续数组之和与对应的第一数组的和
    * 输出第二个数组的最大值即为所求
    *  */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        //用来获得数组到i下表时这一范围内最大的连续数之和
        int[] left=new int[nums.size()];
        int currmax=nums.get(0),totalmax=nums.get(0);
        left[0]=totalmax;
        for(int i=1;i<nums.size()-1;i++){
            currmax=currmax>0?currmax+nums.get(i):nums.get(i);
            left[i]=totalmax=Math.max(currmax,totalmax);
        }
        System.out.println(Arrays.toString(left));
        //用来加上从后往前遍历的最大和
        currmax=0;
        totalmax=Integer.MIN_VALUE;
        for(int i=nums.size()-2;i>0;i--){
            System.out.println(currmax);
        currmax=currmax>0?currmax+nums.get(i):nums.get(i);
        totalmax=Math.max(left[i-1]+currmax,totalmax);
        System.out.println(totalmax);
    }
        return totalmax;
}




}
