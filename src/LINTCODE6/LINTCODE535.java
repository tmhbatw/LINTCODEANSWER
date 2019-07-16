package LINTCODE6;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE535 {
    /*Description
    * 在上次打劫完一条街道之后和一圈房屋之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子组成的区域比较奇怪，聪明的窃贼考察地形之后，
    * 发现这次的地形是一颗二叉树。与前两次偷窃相似的是每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警。
    * 算一算，如果今晚去打劫，你最多可以得到多少钱，当然在不触动报警装置的情况下。
    * */

    /*Solution
    * 递归回溯试一下
    * 以一个数组作为递归函数的返回值
    * 数组用来保存包含当前节点以及不包含当前节点的值
    * */

    public int houseRobber3(TreeNode root) {
        int[] result=recursion(root);
        return Math.max(result[0],result[1]);
        // write your code here
    }

    private int[] recursion(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] result=new int[2];
       int[] left=recursion(root.left);
        int[] right=recursion(root.right);
        result[0]=root.val+left[1]+right[1];
        result[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return result;
    }



}
