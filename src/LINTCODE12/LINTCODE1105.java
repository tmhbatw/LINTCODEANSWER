package LINTCODE12;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE1105 {
    /*Description
    * 按照以下规则在 m*n 二维字符串数组中打印二叉树：
    * 行号m应该等于给定二叉树的高度。
    * 列号n始终为奇数。
    * 根节点的值（以字符串格式）应该放在它可以放入的第一行的正中间。根节点所属的列和行将剩余空间分成两部分（左下部分和右下部分）。
    * 您应该在左下部分打印左子树，并在右下部分打印右子树。左下部和右下部应具有相同的大小。即使一个子树为空，而另一个子树不为空，
    * 你也不需要打印空子树，但仍然需要留出与另外一个子树一样大的空间。但是，如果两个子树都为空，那么您不需要为它们留出空间。
    * 每个未使用的空格应包含一个空字符串""。
    * 按照相同的规则打印所有子树。
    * */

    public List<List<String>> printTree(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        int m=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            m++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
            }
        }
        int n=getWidth(root);
        int[][] res=new int[m][n];
        for(int[] cur:res)
            Arrays.fill(cur,-100);
        List<List<String>> result=new ArrayList<>();
        readData(root,res,0,n-1,0);
        changeForm(res,result);
        return result;
        // Write your code here
    }

    private void readData(TreeNode root,int[][] res,int start,int end,int row){
        if(root==null)
            return ;
        int mid=(start+end)/2;
        res[row][mid]=root.val;
        readData(root.left,res,start,mid-1,row+1);
        readData(root.right,res,mid+1,end,row+1);
    }

    private void changeForm(int[][] res,List<List<String>> result){
        for(int i=0;i<res.length;i++){
            List<String> curRes=new ArrayList<>();
            for(int j=0;j<res[0].length;j++){
                if(res[i][j]==-100)
                    curRes.add("");
                else
                    curRes.add(String.valueOf(res[i][j]));
            }
            result.add(curRes);
        }
    }

    private int getWidth(TreeNode cur){
        if(cur==null)
            return 0;
        return 2*Math.max(getWidth(cur.left),getWidth(cur.right))+1;
    }
}
