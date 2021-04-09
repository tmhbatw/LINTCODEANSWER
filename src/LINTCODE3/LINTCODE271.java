package LINTCODE3;

public class LINTCODE271 {
    /*Description
    * 将一个前缀表达式转换成后缀表达式。
    * */

    /*Solution
    * 基于讲一个前缀表达式转换成二叉树（前序遍历则为前缀表达式，后序遍历则为后缀表达死）
    * */

    public static void main(String[] args){
        String test=new String("- a + b c");
       System.out.println(new LINTCODE271().prefixNotationToPostfixNotation(test));
    }

    String[] c;
    StringBuilder result;
    int index=0;
    public String prefixNotationToPostfixNotation(String str) {
        if(str.length()==0)
            return "";
        c=str.split(" ");
        result=new StringBuilder();
        TreeNode node=getNode();
        postOrder(node);
        return result.substring(1);
        // write your code here.
    }

    private TreeNode getNode(){
        if(index==c.length)
            return null;

        TreeNode node=new TreeNode(c[index]);
        index++;
        if(c[index-1].equals("+")||c[index-1].equals("-")||c[index-1].equals("/")||c[index-1].equals("*")){
            node.left=getNode();
            node.right=getNode();
        }
        return node;
    }

    private void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            result.append(" "+node.val);
        }
    }

    class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;
        public TreeNode(String val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
}
