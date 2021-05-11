package LINTCODE4;

public class LINTCODE333 {
    /*Description
    * 给定一组n个仅包含小写字母的字符串，为每个字符串找出能够唯一识别该字符串的最小前缀
    * 即可以识别A串的最小前缀Ap，不会是其他n-1个字符串的前缀
    * */

    //字典树
    public class MyTrieTree{
        int val;
        MyTrieTree[] children;
        public MyTrieTree(){
            this.val=0;
            this.children=new MyTrieTree[26];
        }
    }
    public String[] ShortPerfix(String[] stringArray) {
        MyTrieTree root=new MyTrieTree();
        for(String cur:stringArray){
            addString(root,cur);
        }
        String[] res=new String[stringArray.length];
        for(int i=0;i<stringArray.length;i++){
            res[i]=getPre(root,stringArray[i]);
        }
        return res;
        // write your code here
    }

    private String getPre(MyTrieTree root,String s){
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(root.children[index].val==1)
                return s.substring(i+1);
            root=root.children[index];
        }
        return s;
    }

    private void addString(MyTrieTree root,String s){
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int index=cur-'a';
            if(root.children[index]==null)
                root.children[index]=new MyTrieTree();
            root=root.children[index];
            root.val++;
        }
    }
}
