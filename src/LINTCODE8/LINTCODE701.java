package LINTCODE8;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import datastructure.TreeNode;

public class LINTCODE701 {
    /*Description
    *给定一个有根的二分搜索树和两个数字min和max，修整这个树使得所有的数字在这个新的树种都是在min和max之间
    * （包括min和max）。然后这个所得的树仍然是合法的二分搜索树。
    * */

    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        while(root!=null&&(root.val<minimum||root.val>maximum)) {
            while (root != null && root.val < minimum)
                root = root.right;
            while (root != null && root.val > maximum)
                root = root.left;
        }
        if(root==null)
            return null;
        deleteBig(root,root.right,maximum);
        deleteSmall(root,root.left,minimum);
        return root;
        // write your code here
    }

    private void deleteBig(TreeNode father,TreeNode cur,int maximum){
        if(cur==null)
            return;
        if(cur.val>maximum){
            father.right=cur.left;
            deleteBig(father,cur.left,maximum);
        }else{
            deleteBig(cur,cur.right,maximum);
        }
    }

    private void deleteSmall(TreeNode father,TreeNode cur,int minimum){
        if(cur==null)
            return;
        if(cur.val<minimum){
            father.left=cur.right;
            deleteSmall(father,cur.right,minimum);
        }else{
            deleteSmall(cur,cur.left,minimum);
        }
    }
}
