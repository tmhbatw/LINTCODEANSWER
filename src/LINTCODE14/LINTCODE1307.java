package LINTCODE14;

public class LINTCODE1307 {
    /*Description
    * 给定一组数字，验证它是否是二叉搜索树的正确的前序遍历序列。
    * 您可以假设序列中的每个数字都是唯一的。
    * */

    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder,0,preorder.length-1);
        // write your code here
    }

    private boolean verifyPreorder(int[] preorder,int start,int end){
        if(start>=end)
            return true;
        int val=preorder[end];
        int leftIndex=start;
        for(;leftIndex<end;leftIndex++){
            if(preorder[leftIndex]>val)
                break;
        }
        int rightIndex=leftIndex;
        for(;rightIndex<end;rightIndex++){
            if(preorder[rightIndex]<val)
                return false;
        }
        return verifyPreorder(preorder,start,leftIndex-1)
                &&verifyPreorder(preorder,leftIndex,end-1);
    }
}
