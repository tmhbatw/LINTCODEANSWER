package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1329 {
    /*Description
    * 有一个长度为n的序列a，在序列上进行q次操作。
    * 每次操作有一个查询的数字bi，将序列中所有大于等于bi的数字减一。
    * 返回每次操作后有多少数字被减一。
    * */


    /*Solution
    * 线段数可以很轻易的构造出来
    * */
    TreeNode root = null;

    public int[] sequenceMaintenance(int n, int q, int[] a, int[] b) {
        int[] result = new int[q];
        Arrays.sort(a);
        constructTreeNode(a,0,n-1);
        //print(root);
        for(int i=0;i<q;i++){
            result[i]=getCount(b[i],root);
        }
        return result;
        // write your code here
    }

    public void print(TreeNode root){
        if(root==null)
            return ;
        System.out.println(root.val+" "+root.num+" ");
        print(root.left);
        print(root.right);
    }

    private int getCount(int k, TreeNode root){
        if(root==null)
            return 0;
        //  System.out.println(k+" "+root.val+" "+root.add+" "+root.num);
        if(k>root.val-root.add){
            return getCount(k+root.add,root.right);
        }else{
            root.add +=1;
            return root.num + getCount(k, root.left);
        }
    }

    public void constructTreeNode (int[] a, int start, int end){
        if(start>end)
            return ;
        int mid = (start+end)/2;
        if(root==null){
            root=new TreeNode(a[mid],1,0);
        }else{
            addTreeNode(a[mid],root);
        }

        constructTreeNode(a,start,mid-1);
        constructTreeNode(a,mid+1,end);
    }

    private void addTreeNode(int val, TreeNode root){
        if(val==root.val){
            root.num += 1;
        }else if(val <root.val){
            if(root.left==null){
                root.left = new TreeNode (val,1,0);
            }else{
                addTreeNode(val, root.left);
            }
        }else{
            root.num+=1;
            if(root.right==null){
                root.right = new TreeNode(val, 1, 0);
            }else{
                addTreeNode(val, root.right);
            }
        }
    }

    class TreeNode {
        int val;
        int num;
        int add;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, int num ,int add){
            this.val = val;
            this.num = num;
            this.add = add;
            this.left = null;
            this.right=null;
        }
    }
}
