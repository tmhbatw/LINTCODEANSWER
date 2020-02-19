package LINTCODE16;

import datastructure.TreeNode;
import datastructure.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1530 {
    /*Description
    * 设计了一种算法，将一棵n叉树编码为一棵二叉树，并对二叉树进行解码，得到原始的n叉树。
    * n叉树是一棵有根树，其中每个节点的子树不超过n个。 类似地，二叉树是一棵有根树，其中每个节点的子树不超过2个。
    * 编码/解码算法的工作方式不受限制。 您只需要确保一个n叉树可以被编码为一个二叉树，并且这个二叉树可以被解码为原始的n叉树结构。
    * */

    /*Solution
    * 把父节点的除第一个节点外的其他节点置于第一个节点右侧
    * */

    public UndirectedGraphNode decode(TreeNode root) {
        if(root==null)
            return null;
        UndirectedGraphNode result=new UndirectedGraphNode(root.val);
        if(root.left==null)
            return result;
        List<UndirectedGraphNode> list=result.neighbors;
        TreeNode left=root.left;
        list.add(decode(left));
        TreeNode right=left.right;
        while(right!=null){
            list.add(decode(right));
            right=right.right;
        }
        return result;
        // write your code here
    }

    /**
     * @param root: N-ary tree
     * @return: binary tree
     */
    public TreeNode encode(UndirectedGraphNode root) {
        TreeNode result= encode(root,new ArrayList<>());
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(result);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                System.out.print(cur.val);
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
            System.out.println("");
        }
        return result;
        // write your code here
    }

    private TreeNode encode(UndirectedGraphNode root,List<UndirectedGraphNode> list){
        TreeNode res=new TreeNode(root.label);
        List<UndirectedGraphNode> neighbors=root.neighbors;
        if(neighbors.size()>=1){
            UndirectedGraphNode left=neighbors.get(0);
            neighbors.remove(0);
            res.left=encode(left,neighbors);
        }
        TreeNode cur=res;
        while(list.size()!=0){
            cur.right=encode(list.get(0), new ArrayList<UndirectedGraphNode>());
            list.remove(0);
            cur=cur.right;
        }
        return res;
    }
}
