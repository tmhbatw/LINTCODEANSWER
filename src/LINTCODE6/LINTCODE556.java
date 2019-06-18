package LINTCODE6;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE556 {

    /*Description
    * 实现一个标准型布隆过滤器, 支持一下方法:
    * StandardBloomFilter(k), 构造方法, 你需要创建k个hash方法
    * add(string). 往布隆过滤器中加入一个字符串.
    * contains(string). 检查字符串是否在过滤器中
    * */

    /*Solution
    * 借助数据结构可以较好的完成题目要求
    * */
    Set<String> set=new HashSet<>();

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        set.add(word);
        // write your code here
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        return set.contains(word);
        // write your code here
    }
}
