package LINTCODE1;

public class LINTCODE43 {
    /*Description
    * 给定一个整数数组和一个整数 k，找出 k 个不重叠子数组使得它们的和最大。每个子数组的数字在数组中的位置应该是连续的。
    * 返回最大的和。
    * */

    /*Solution
    * 经典的动态规划问题
    *创建两个二维数组分别保存包含当前数字的以及最大的整数和
    * */


    public int maxSubArray(int[] nums, int k) {
        int[][] currMax=new int[k+1][nums.length+1];
        int[][] totalMax=new int[k+1][nums.length+1];
        for(int i=1;i<k+1;i++){
            currMax[i][i-1]=Integer.MIN_VALUE;
            for(int j=i;j<nums.length+1;j++){
                currMax[i][j]=Math.max(totalMax[i-1][j-1],currMax[i][j-1])+nums[j-1];
                if(i==j)
                    totalMax[i][j]=currMax[i][j];
                else {
                    totalMax[i][j] = Math.max(currMax[i][j], totalMax[i][j - 1]);
                }
            }
        }
        return totalMax[k][nums.length];
        // write your code here
    }


//递归实现，时间复杂度超标
//    public static int maxSubArray(int[] nums, int k) {
//        List<Integer> list=new ArrayList<>();
//        list.add(Integer.MIN_VALUE);
//        int res=0;
//        recursion(list,res,nums,0,1,k);
//        System.out.println(res);
//        return list.get(0);
//    }
//    private static void recursion(List<Integer> result,int res,int[] nums,int start,int part,int k){
//        if(part==k){
//            res+=maxSearch(nums,start,nums.length);
//            if(result.get(0)<res){
//                result.add(0,res);
//            }
//            return;
//        }
//        for(int i=start;i<(nums.length-k+part);i++){
//            recursion(result,res+maxSearch(nums,start,i+1),nums,i+1,part+1,k);
//        }
//    }
//
//    private static int maxSearch(int[] nums,int n,int m){
//        int max=nums[n],curmax=nums[n];
//        for(int i=n+1;i<m;i++){
//            curmax=curmax>0?curmax+nums[i]:nums[i];
//            max=Math.max(curmax,max);
//        }
//        return max;
//    }

}
