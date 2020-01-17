package LINTCODE13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1204 {
    /*Description
    * 给定一个单词列表，返回可以在美国键盘的一行上使用字母表键入的单词，
    * */

    public String[] findWords(String[] words) {
        List<String> res=new ArrayList<>();
        for(String cur:words){
            int line=getLine(cur.charAt(0));
            boolean temp=true;
            for(int i=1;i<cur.length();i++){
                if(getLine(cur.charAt(i))!=line) {
                    temp=false;
                    break;
                }
            }
            if(temp)
                res.add(cur);
        }
        String[] result=new String[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;

        // write your code here
    }

    private int getLine(char cur){
        if(cur<='Z'&&cur>='A')
            cur= (char) (cur+32);
        if(cur=='q'||cur=='w'||cur=='e'||cur=='r'||cur=='t'||cur=='y'||cur=='u'||cur=='i'||cur=='o'||cur=='p')
            return 1;
        if(cur=='a'||cur=='s'||cur=='d'||cur=='f'||cur=='g'||cur=='h'||cur=='j'||cur=='k'||cur=='l')
            return 2;
        return 3;
    }
}
