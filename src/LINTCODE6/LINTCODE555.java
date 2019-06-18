package LINTCODE6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE555 {

    /*Description
    * 实现一个计数型布隆过滤器, 支持以下方法:
    * add(string). 往布隆过滤器中加入一个字符串.
    * contains(string). 检查一个字符串是否在布隆过滤器中.
    * remove(string). 从布隆计数器中删除一个字符串.
    * */

    /*Solution
    * 使用一个hashMap数据结构
    * */

    HashMap<String,Integer> set=new HashMap<>();

    public LINTCODE555(int k) {
        // do intialization if necessary
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        if(contains(word)){
            set.put(word,set.get(word)+1);
        }else{
            set.put(word,1);
        }
        // write your code here
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void remove(String word) {
        if(set.get(word)<=1)
            set.remove(word);
        else{
            set.put(word,set.get(word)-1);
        }
        // write your code here
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        return set.containsKey(word);
        // write your code here
    }
}
