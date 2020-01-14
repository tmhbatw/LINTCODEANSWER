package LINTCODE11;

import java.util.HashSet;

public class LINTCODE1013 {
    /*Description
    * 摩尔斯电码定义了一种标准编码，把每个字母映射到一系列点和短划线，例如：a -> .-，b -> -...，c ->-.-.。
    * 现在给定一个单词列表，每个单词中每个字母可以写成摩尔斯编码。 例如，cab可以写成-.-.-....-，（把c,a,b的莫尔斯编码串接起来）。 我们称之为一个词的转换。
    * 返回所有单词中不同变换的数量。
    * */

    public int uniqueMorseRepresentations(String[] words) {
        String[] change=new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set=new HashSet<>();
        for(String cur:words){
            StringBuilder res=new StringBuilder();
            for(int i=0;i<cur.length();i++){
                res.append(change[cur.charAt(i)-'a']);
            }
            set.add(res.toString());
        }
        return set.size();
        // Write your code here
    }
}
