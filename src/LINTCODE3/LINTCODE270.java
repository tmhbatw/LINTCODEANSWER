package LINTCODE3;

public class LINTCODE270 {
    /*Description
    *给一些不包含0和1的数字字符串和一个字典，对于每个数字字符串，每个数字代表一个字母，请返回字典中可以匹配的字母组合的数量。
    * 如果可以用一个数字字符串可以表示出一个单词的前缀，我们认为他们之间是匹配的。
    * 下图的手机按键图，就表示了每个数字可以代表的字母。
    * */

    public class MyTrieTree{
        int val;
        MyTrieTree[] children;
        public MyTrieTree(){
            this.val=0;
            this.children=new MyTrieTree[10];
        }
    }

    int[] changeArray=new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};

    public int[] letterCombinationsII(String[] queries, String[] dict) {
        MyTrieTree root=new MyTrieTree();
        for(String cur:dict)
            addString(cur,root);
        int[] res=new int[queries.length];
        for(int i=0;i<res.length;i++)
            res[i]=getVal(root,queries[i]);
        return res;
        // write your code here
    }

    private int getVal(MyTrieTree root,String cur){
        for(int i=0;i<cur.length();i++){
            int index=cur.charAt(i)-'0';
            if(root.children[index]==null)
                return 0;
            root=root.children[index];
        }
        return root.val;
    }

    private void addString(String cur,MyTrieTree root){
        for(int i=0;i<cur.length();i++){
            int index=changeArray[cur.charAt(i)-'a'];
            if(root.children[index]==null)
                root.children[index]=new MyTrieTree();
            root=root.children[index];
            root.val++;
        }
    }
}
