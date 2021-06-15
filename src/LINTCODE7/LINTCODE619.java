package LINTCODE7;

import java.util.List;

public class LINTCODE619 {
    /*Description
    * 这题是 二叉树的最长连续子序列II 的后续。
    * 给出一棵 k叉树，找到最长连续序列路径的长度.
    * 路径的开头跟结尾可以是树的任意节点。
    * */

    public class MultiTreeNode {
        int val;
        List<MultiTreeNode> children;
        MultiTreeNode(int x) { val = x; }
    }

    public class Point{
        int val;
        int longConsecutiveNum;
        int shortConsecutiveNum;
        public Point(int v,int l ,int s){
            this.val=v;
            this.longConsecutiveNum = l;
            this.shortConsecutiveNum = s;
        }
    }

    int result=0;
    public int longestConsecutive3(MultiTreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return result;
        // Write your code here
    }

    private Point dfs(MultiTreeNode root){
        int val=root.val;
        int l = 0;
        int s = 0;
        if(root.children==null||root.children.size()==0)
            return new Point(val,1,1);
        for(MultiTreeNode child : root.children){
            Point cur=dfs(child);
            if(cur.val==val+1)
                l=Math.max(l,cur.longConsecutiveNum);
            if(cur.val==val-1)
                s=Math.max(s,cur.shortConsecutiveNum);
        }
        result=Math.max(result,l+s+1);
        return new Point(val,l+1,s+1);
    }
}
