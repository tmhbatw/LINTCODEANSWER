package LINTCODE17;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1616 {
    /*Description
    * 给定一个整数数组和正整数 K，找到最小的连续子数组使得子数组的和>=K，
    * 返回子数组的长度。如果没有与条件匹配的子数组，则返回-1
    * */

    public int smallestLengthII(int[] nums, int k) {
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{0,-1});
        int sum=0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum-list.get(0)[0]>=k) {
                int l = 0, r = list.size();
                while (l < r) {
                    int mid = l + (r - l+1) / 2;
                    if (sum - list.get(mid)[0] >= k) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                res=Math.min(res,i-list.get(l)[1]);
            }
            while(!list.isEmpty()&&list.get(list.size()-1)[0]>=sum){
                list.remove(list.size()-1);
            }
            list.add(new int[]{sum,i});
        }
        return res==Integer.MAX_VALUE?-1:res;
        // Write your code here
    }
}
