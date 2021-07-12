package LINTCODE13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1297 {
    /*Description
    * 给定一个整数数组nums，返回一个新的counts数组。counts[i]表示：nums[i]右侧比它小的数的个数。
    * */

    class TreeNode{
        int val;
        int small;
        int time;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            this.small=1;
            this.time=1;
            this.left=null;
            this.right=null;
        }
    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        TreeNode root=new TreeNode(Integer.MAX_VALUE);
        for(int i=nums.length-1;i>=0;i--){
            int res=0;
            TreeNode node=root;
            while(true){
                if(node.val==nums[i]) {
                    node.small++;
                    node.time++;
                    res+=node.small-node.time;
                    break;
                }
                if(node.val<nums[i]){
                    res+=node.small;
                    if(node.right==null) {
                        node.right = new TreeNode(nums[i]);
                        break;
                    }
                    node=node.right;
                }else{
                    node.small++;
                    if(node.left==null){
                        node.left=new TreeNode(nums[i]);
                        break;
                    }
                    node = node.left;
                }
            }
            result.add(res);
        }
        Collections.reverse(result);
        return result;
        // write your code here
    }


}
