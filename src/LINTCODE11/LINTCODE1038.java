package LINTCODE11;

import java.util.HashSet;

public class LINTCODE1038 {
    /*Description
    * 给定字符串J代表是珠宝的石头类型，而S代表你拥有的石头.S中的每个字符都是你拥有的一个石头. 你想知道你的石头有多少是珠宝.
    * J中的字母一定不同，J和S中的字符都是字母。 字母区分大小写，因此"a"和"A"是不同的类型.
    * */

    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<J.length();i++){
            set.add(J.charAt(i));
        }
        int result=0;
        for(int i=0;i<S.length();i++){
            if(set.contains(S.charAt(i)))
                result++;
        }
        return result;
        // Write your code here
    }
}
