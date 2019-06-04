package LINTCODE2;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE168 {
/*Description
* 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。每次吹气球i可以得到的分数为 nums[left] * nums[i] * nums[right]，
* left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。要求吹爆所有气球，得到最多的分数。
* */

/*Solution
* 递归尝试一下 果不其然超时了
* 尝试一下动态规划
* 创建一个dp数组其中dp[i][j]用来存储从第i位到第j位的最大值
* 它的值等于依次尝试最后打i到j中的第k个气球，其值一定为num[i-1]*num[j+1]*num[k]+dp[i][k-1]+dp[k+1][j];
* 因此，一定要优先遍历比较短的长度（i到j的距离），确定了距离之后，再确定左右位置（i与j的值）然后遍历即可
*
* 动态规划;找到递推关系之前，优先要确定我们先实现什么
* */


    public int maxCoins(int[] nums) {
        int n=nums.length;
        nums=change(nums);
        int[][] dp=new int[nums.length][nums.length];
        for(int len=1;len<=n;len++){
            for (int left = 1; left <= n - len + 1; ++left) {
                int right = left + len - 1;
                for (int k = left; k <= right; ++k) {
                    dp[left][right] = Math.max(dp[left][right], nums[left - 1] * nums[k] * nums[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];
        // write your code here
    }

    private static int[] change(int[] nums){
        int[] num=new int[nums.length+2];
        num[0]=0;
        int index=1;
        for(int i=0;i<nums.length;i++){
            num[index++]=nums[i];
        }
        return num;
    }
    public static void main(String[] args){
        int[] nums={1,2,3,4};
        nums=change(nums);
        System.out.println(Arrays.toString(nums));
    }


/*    private int max=0;

    public int maxCoins(int[] nums) {
        List<Integer> num=new ArrayList<>();
        num.add(1);
        for(int i=0;i<nums.length;i++)
            num.add(nums[i]);
        recursion(0,num);
        return max;
        // write your code here
    }

    private void recursion(int res,List<Integer> num){
        if(num.size()==2){
            max=Math.max(res,max);
            return;
        }
        for(int i=1;i<num.size()-1;i++){
            res+=num.get(i-1)*num.get(i)*num.get(i+1);
            List<Integer> nums=new ArrayList<>();
            nums.addAll(num);
            nums.remove(i);
            recursion(res,nums);
        }
    }*/
}
