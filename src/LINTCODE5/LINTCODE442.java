package LINTCODE5;

import java.util.HashMap;

public class LINTCODE442{

/*Description
*Implement a Trie with insert, search, and startsWith methods.
* */

/*Solution
* 可以创建一个哈希表用来保存子树的信息
* 可以用一个boolean值保存是否存在
* */


    public HashMap<Character,LINTCODE442> map=new HashMap<>();
    boolean isWord=false;

    public LINTCODE442() {
        // do intialization if necessary
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        HashMap curr=map;
        for(int i=0;i<word.length();i++){
            if(!curr.containsKey(word.charAt(i)))
                curr.put(word.charAt(i),new LINTCODE442());
            LINTCODE442 cur= (LINTCODE442) curr.get(word.charAt(i));
            if(i==word.length()-1)
                cur.isWord=true;
            curr=cur.map;
        }
        // write your code here
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        LINTCODE442 curr=this;
        for(int i=0;i<word.length();i++){

            if(!curr.map.containsKey(word.charAt(i)))
                return false;
            curr=curr.map.get(word.charAt(i));
        }
        if(curr.isWord)
            return true;
        return false;
        // write your code here
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        LINTCODE442 curr=this;
        for(int i=0;i<prefix.length();i++){
            if(!curr.map.containsKey(prefix.charAt(i)))
                return false;
            curr=curr.map.get(prefix.charAt(i));
        }
        return true;
        // write your code here
    }
}
