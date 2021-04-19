package LINTCODE11;

public class LINTCODE1007 {
    /*Description
    * 给定非负整数nums[i]. Alice 和 Bob 轮流从中删除元素, 每次可以删除一个. 爱丽丝先开始.
    * 若删除后剩余元素按位异或为0, 则该玩家判负. (规定: 单个元素的按位异或是其本身, 空数组的按位异或是0)
    * 或者说, 如果一个玩家的回合开始时所有元素的按位异或为0, 该玩家判胜.
    * 两个人都采取最优决策, 判断 Alice 是否必胜.
    * */

    public boolean xorGame(int[] nums) {
        int sum=0;
        for(int cur:nums)
            sum^=cur;
        return sum==0||nums.length%2==0;
        // write your code here
    }
}
