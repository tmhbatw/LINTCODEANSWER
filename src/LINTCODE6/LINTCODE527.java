package LINTCODE6;

import datastructure.TreeNode;
import datastructure.TrieNode;

import java.util.Map;

public class LINTCODE527 {
    /*Description
    * 序列化和反序列化一个trie（前缀树，请在网上搜索更多细节）。
    * 您可以指定自己的序列化算法，线上法官只关心您是否能够成功地反序列化您自己的序列化函数的输出。
    * 您只需要实现这两个函数序列化和反序列化。我们将运行以下代码段
    * */

    class Solution {
        /**
         * This method will be invoked first, you should design your own algorithm
         * to serialize a trie which denote by a root node to a string which
         * can be easily deserialized by your own "deserialize" method later.
         */
        StringBuilder sb=new StringBuilder();
        public String serialize(TrieNode root) {
            if(root==null)
                return "<>";
            sb.append("<");
            for(Map.Entry<Character, TrieNode> entry:root.children.entrySet()){
                sb.append(entry.getKey());
                serialize(entry.getValue());
            }
            sb.append(">");
            return sb.toString();
            // Write your code here
        }

        /**
         * This method will be invoked second, the argument data is what exactly
         * you serialized at method "serialize", that means the data is not given by
         * system, it's given by your own serialize method. So the format of data is
         * designed by yourself, and deserialize it here as you serialize it in
         * "serialize" method.
         */
        public TrieNode deserialize(String data) {
            if(data.equals(""))
                return null;
            TrieNode root=new TrieNode();
            if(data.length()==2)
                return root;
            for(int i=1;i<data.length()-1;i++){
                char cur=data.charAt(i);
                if(cur!='<'&&cur!='>'){
                    char key=cur;
                    int count=1;
                    int start=i+1;
                    int end=start+1;
                    while(count!=0){
                        char next=data.charAt(end++);
                        if(next=='<')
                            count++;
                        if(next=='>')
                            count--;
                    }
                    TrieNode val=deserialize(data.substring(start,end));
                    root.children.put(key,val);
                    i=end-1;
                }
            }
            return root;
            // Write your code here
        }
    }
}
