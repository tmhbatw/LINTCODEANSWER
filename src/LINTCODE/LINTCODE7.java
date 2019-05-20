package LINTCODE;

import java.util.ArrayDeque;
import java.util.Deque;

public class LINTCODE7 {

    /*Description
    * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and
    * reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
    * */


    /*Definition of TreeNode:
    */
      public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
             this.val = val;
              this.left = this.right = null;
         }
      }


      /*Solution
      * 本题目的在于遍历一颗二叉树以及将一个字符串转化为一颗固定顺序的二叉树
      * 本题目我将使用deque—及双端队列这一数据结构
      * （PS:双端队列可以从数据结构的两端插入或者获取对象，更适合本题的接替过程）
      * */

    public String serialize(TreeNode root) {
        if(root==null){
            return "{}";
        }
        String result="{";                       //创建一个结果字符串用来储存返回结果
        Deque<TreeNode> stack=new ArrayDeque<>();//创建一个双端队列对象
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pollLast();
            if(curr.val==0) {
                result +="#,";
                continue;
            }
            //将二叉树的左右非空子节点压回stack;
            if (curr.left != null) {
                stack.push(curr.left);
            } else {
                stack.push(new TreeNode(0));
            }
            if (curr.right != null) {
                stack.push(curr.right);
            } else {
                stack.push(new TreeNode(0));
            }
            result+=curr.val+",";
        }
        while(result.charAt(result.length()-2)=='#')
            result=result.substring(0,result.length()-2);
        return result.substring(0,result.length()-1)+"}";
        // write your code here
    }
    public TreeNode deserialize(String data) {
        //如果出现“{}”这一特殊情况的处理方法
        if(data.length()==2)
            return null;
        String[] datas=data.substring(1,data.length()-1).split(",");
        //创建一颗根节点树,并将它弹入我们的deque中
        TreeNode root=new TreeNode(Integer.parseInt(datas[0]));
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        int flag=1;//创建一个flag值用来指示、判别是否遍历完成所有的树的节点
        while(flag<datas.length){
            TreeNode curr=stack.pollLast();
            TreeNode left=datas[flag].equals("#")?null:new TreeNode(Integer.parseInt(datas[flag]));
            flag++;
            curr.left=left;
            if(left!=null)
                stack.push(left);
            if(flag==datas.length)
                break;
            TreeNode right=datas[flag].equals("#")?null:new TreeNode(Integer.parseInt(datas[flag]));
            flag++;
            curr.right=right;
            if(right!=null)
                stack.push(right);
        }
        return root;
    }




}
