package LINTCODE18;

import java.util.Arrays;
import java.util.Comparator;

public class LINTCODE1788 {
    /*Description
    * 考虑一个十进制整数数组，我们要根据以下规则重新排列数组：
    * 按二进制表示中的1个数对整数升序排序。
    * 二进制表示中具有相同数量1的元素按照十进制值升序排序。
    * */

    public int[] AscendingBinarySorting(int[] nums) {
        int[][] num=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            num[i]=new int[]{nums[i],getOne(nums[i])};
        }
        Arrays.sort(num, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        for(int i=0;i<nums.length;i++)
            nums[i]=num[i][0];
        return nums;
        // Write your code here
    }

    private int getOne(int cur){
        int result=0;
        while(cur>0){
            result+=cur%2;
            cur/=2;
        }
        return result;
    }
}
