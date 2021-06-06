package LINTCODE17;

public class LINTCODE1624 {
    /*Description
    *两个二进制串的距离是去掉最长公共前缀的长度之和。比如: 1011000和1011110的最长公共前缀是1011，
    * 距离就是 len("000"+"110") = 3 + 3 = 6 . 现在给一个二进制串的集合, 求两个二进制串的最大距离.
    * */

    class MyTreeNode{
        int length;
        MyTreeNode[] children;
        public MyTreeNode(int length){
            this.length=0;
            this.children=new MyTreeNode[2];
        }
    }

    int result=0;
    public int getAns(String[] s) {
        MyTreeNode root=new MyTreeNode(0);
        for(String cur:s)
            insert(root,cur,0);
        for(String cur:s){
            getDiff(root,cur,0);
            System.out.println(result);
        }
        return result;
        // Write your code here
    }

    private void getDiff(MyTreeNode root,String cur,int index){
        if(cur.length()==index) {
            result=Math.max(root.length-1,result);
            return;
        }
        int i=cur.charAt(index)-'0';
        if(root.children[1-i]!=null){
            result=Math.max(result,root.children[1-i].length+cur.length()-index);
        }
        getDiff(root.children[i],cur,index+1);
    }

    private void insert (MyTreeNode root,String s, int index){
        int curLength=s.length()-index;
        if(curLength==0)
            return;
        int i=s.charAt(index)-'0';
        if(root.children[i]==null)
            root.children[i]=new MyTreeNode(curLength);
        root.children[i].length=Math.max(root.children[i].length,curLength);
        insert(root.children[i],s,index+1);
    }
}
