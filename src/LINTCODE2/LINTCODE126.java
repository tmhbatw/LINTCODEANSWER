package LINTCODE2;

import datastructure.TreeNode;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE126 {

    /*Description
    * 给出一个没有重复数字的整数数组，在此数组上建立最大树，其定义如下：
    * 根是数组中最大的数
    * 左子树和右子树元素分别是被父节点元素切分开的子数组中的最大值
    * 利用给定的数组构造最大树。
    * */

    public TreeNode maxTree(int[] A) {
        if(A==null||A.length==0)
            return null;
        int n=A.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<A.length;i++){
            int[] pre = null;
            while(!stack.isEmpty()&&stack.peek()[0]<A[i]){
                int[] cur=stack.pop();
                if(pre!=null){
                    right[cur[1]]=pre[1];
                }
                pre = cur;
            }
            if(pre!=null){
                left[i]=pre[1];
            }
            stack.add(new int[]{A[i],i});
        }
        int[] pre = null;
        while(!stack.isEmpty()){
            int[] cur=stack.pop();
            if(pre!=null){
                right[cur[1]] = pre[1];
            }
            pre = cur;
        }
        TreeNode node=getNode(A,left,right,pre[1]);
        return node;
        // write your code here
    }

    private TreeNode getNode(int[] A, int[] left,int[] right, int index){
        TreeNode[] node=new TreeNode[A.length];
        for(int i=0;i<A.length;i++){
            node[i]=new TreeNode(A[i]);
        }
        for(int i=0;i<left.length;i++){
            if(left[i]!=-1){
                node[i].left=node[left[i]];
            }
            if(right[i]!=-1){
                node[i].right=node[right[i]];
            }
        }
        return node[index];
    }
    
}
