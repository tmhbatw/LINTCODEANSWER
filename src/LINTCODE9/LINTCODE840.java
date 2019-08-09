package LINTCODE9;

public class LINTCODE840 {
    /*description
    * 给定一个整数数组 nums, 然后你需要实现两个函数:
    * update(i, val) 将数组下标为i的元素修改为val
    * sumRange(l, r) 返回数组下标在
    * [l,r]区间的元素的和
    * */

    /*Solution
    * 可以建立一颗数组树
    * */

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums=nums;
        }

        public void update(int i, int val) {
            nums[i]=val;
        }

        public int sumRange(int i, int j) {
            int res=0;
            for(int ii=i;ii<=j;ii++)
                res+=nums[ii];
            return res;
        }
    }
}
