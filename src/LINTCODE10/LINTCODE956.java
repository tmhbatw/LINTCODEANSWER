package LINTCODE10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE956 {
    /*Description
    * 给出一个字符串 str,你需要按顺序提取出该字符串的符号和单词。
    * */

    public String[] dataSegmentation(String str) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int start=i;
            char cur=str.charAt(i);
            if(cur==' ')
                continue;
            if(cur<='z'&&cur>='a'){
                while(i<str.length()-1&&str.charAt(i+1)<='z'&&str.charAt(i+1)>='a')
                    i++;
            }
            res.add(str.substring(start,i+1));
        }
        String[] result=new String[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
        // Write your code here
    }
}
