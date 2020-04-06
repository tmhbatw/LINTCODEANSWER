package LINTCODE6;

import java.util.*;

public class LINTCODE559 {
    /*Description
    * 通过<字符串，值>的集合来建立树结构，每个结点保存前10大的数值。
    * */
    public class TrieNode {
        public NavigableMap<Character, TrieNode> children;
        public List<Integer> top10;
        public TrieNode() {
            children = new TreeMap<Character, TrieNode>();
            top10 = new ArrayList<Integer>();
        }
     }

    public class TrieService {

        private TrieNode root = null;

        public TrieService() {
            root = new TrieNode();
        }

        public TrieNode getRoot() {
            // Return root of trie root, and
            // lintcode will print the tree struct.
            return root;
        }

        // @param word a string
        // @param frequency an integer
        public void insert(String word, int frequency) {
            TrieNode cur=root;
            int n=word.length();
            for(int i=0;i<n;i++){
                char curr=word.charAt(i);
                if(!cur.children.containsKey(curr)){
                    cur.children.put(curr,new TrieNode());
                }
                cur=cur.children.get(curr);
                add(cur.top10,frequency);
            }
            // Write your cod here
        }

        private void add(List<Integer> list,int time){
            list.add(time);
            Collections.sort(list,Comparator.reverseOrder());
            if(list.size()==11)
                list.remove(10);
        }
    }
}
