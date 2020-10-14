package LINTCODE4;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE336 {
    /*Description
    * 给你一个只含有可见字符（ASCII 码范围 32 至 126）文本文件，文件中可能出现一些重复的单词，你需要对它们进行压缩
    * 压缩规则如下：
    * 如果原文件中的字符不是英文字符，那么保留这些字符。
    * 我们将连续的英文字符视为一个单词，单词的前后不应该还有其它的英文字符。
    * 如果一个单词在它之前的文本中没有出现过，那么保留它。
    * 如果一个单词在它之前出现过，将其替换成前文中它第一次出现是第几个不同单词的编号。
    * */

    public String[] textCompression(String[] lines) {
        Map<String,Integer> map=new HashMap<>();
        int index=1;
        int length=lines.length;
        String[] result=new String[length];
        for(int i=0;i<length;i++){
            String cur=lines[i];
            int curLength=cur.length();
            StringBuilder res=new StringBuilder();
            for(int j=0;j<curLength;j++){
                char curr=cur.charAt(j);
                if(!isLetter(curr)) {
                    res.append(curr);
                    continue;
                }
                StringBuilder letter=new StringBuilder();
                letter.append(curr);
                while(j+1<curLength&&isLetter(cur.charAt(j+1))){
                    letter.append(cur.charAt(j+1));
                    j++;
                }
                String let=letter.toString();
                if(map.containsKey(let))
                    res.append(map.get(let));
                else{
                    map.put(let,index);
                    res.append(let);
                    index++;
                }
            }
            result[i]=res.toString();
        }
        return result;
        // write your code here.
    }

    private boolean isLetter(char cur){
        if(cur<='Z'&&cur>='A'||cur<='z'&&cur>='a')
            return true;
        return false;
    }
}
