package LINTCODE5;

import java.util.HashMap;

public class LINTCODE473 {
    class WordDictionary {

        /*Description
         * 设计一个包含下面两个操作的数据结构：addWord(word), search(word)
         * addWord(word)会在数据结构中添加一个单词。而search(word)则支持普通的单词查询或是只包含.和a-z的简易正则表达式的查询。
         * 一个 . 可以代表一个任何的字母。
         * */

        /*Solution
         * 与471题单词树的思路基本相似，只不过判断单词的时候需要在搜查到"."字符时进行机递归处理
         * */

        boolean isWord=false;
        HashMap<Character,WordDictionary> map=new HashMap<>();
        boolean exist=false;


        public void addWord(String word) {
            WordDictionary curr=this;
            for(int i=0;i<word.length();i++){
                if(!curr.map.containsKey(word.charAt(i)))
                    curr.map.put(word.charAt(i),new WordDictionary());
                curr=curr.map.get(word.charAt(i));
            }
            curr.isWord=true;
            // write your code here
        }

        /*
         * @param word: A word could contain the dot character '.' to represent any one letter.
         * @return: if the word is in the data structure.
         */
        public boolean search(String word) {
            exist =false;
            recursion(this,word,0);
            return exist;
            // write your code here
        }

        public void recursion(WordDictionary dic,String word, int start){
            if(exist)
                return;
            if(start==word.length()&&dic.isWord){
                exist=true;
                return;
            }
            if(start==word.length())
                return;
            if(word.charAt(start)!='.'){
                if(!dic.map.containsKey(word.charAt(start)))
                    return;
                recursion(dic.map.get(word.charAt(start)),word,start+1);
            }else{
                for(HashMap.Entry entry:dic.map.entrySet()){
                    recursion((WordDictionary) entry.getValue(),word,start+1);
                }
            }
        }
}
