package LINTCODE;

import java.util.*;

public class LINTCODE11 {

    /*Description
    * Given a binary search tree and a range [k1, k2], return node values within a given range in ascending order.
    * */

    /*Solution
    * 问题关键点：遍历一棵二叉树并将在范围要求内的数输出
    * 使用deque双排列队列数据结构
    * */
      public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
          //特殊情况处理
          if(root==null)
              return Collections.emptyList();
          List<Integer> list=new ArrayList<>();
          //创建一个deque数据结构用来存储树结构
          Deque<TreeNode> stack=new ArrayDeque<>();
          stack.push(root);
          while(!stack.isEmpty()){
              TreeNode curr=stack.pollLast();
              int val=curr.val;
              if(val<=k2&&val>=k1)
                  list.add(val);
              if(curr.left!=null)
                  stack.push(curr.left);
              if(curr.right!=null)
                  stack.push(curr.right);
          }
          return list;
    }
}
