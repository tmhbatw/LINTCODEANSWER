package LINTCODE12;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE1066 {
    /*Description
    *二叉树序列化的一种方法是使用先序遍历。 当我们遇到非空节点时，我们记录节点的值。如果是一个空节点，我们使用诸如#的标记值。
    * 例如，上面的二叉树可以序列化为字符串”9,3,4,#,#,1,#,#,2,#,6,#,#”，其中#表示空节点。
    * 给定一个用逗号分隔的字符串，验证它是否是二叉树序列化正确的前序遍历。 找到一个不需要重建树的算法。
    * 字符串中的每个逗号分隔的值必须是整数或表示空指针的字符“#”。
    * 您可以假设输入格式始终符合要求，例如它永远不能包含两个连续的逗号，例如“1,,3”。
    * */

    public boolean isValidSerialization(String preorder) {
        if(preorder.length()==0)
            return true;
        String[] preorderList=preorder.split(",");
        int number=0;
        if(!preorderList[0].equals("#"))
            number++;
        for(int i=1;i<preorderList.length;i++){
            if(!preorderList[i].equals("#"))
                number++;
            else
                number--;
            if(number<0)
                return false;
        }
        return number==0;
        // write your code here
    }

    public static void main(String[] args){
        TreeNode node=new TreeNode(2);
    }
}
