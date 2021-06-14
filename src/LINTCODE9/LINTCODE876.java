package LINTCODE9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE876 {
    /*Description
    * 给定一个字符串列表，你可以将这些字符串连接到一个循环中，在连入循环之前，你可以选择将其反转。
    * 在所有可能的循环中，你需要在断开循环之后找到字典序最大的字符串。
    * 具体来说，要找到答案，您需要经历两个阶段:
    * 将所有字符串连接到一个循环中，在一个字符串连入循环之前，你可以选择将它反转。但是你需要按照给定的顺序将它们连接起来。
    * 在循环的某个位置断开，得到一个正常的字符串。你的任务是在所有可能得到的字符串中找到字典序最大的一个。
    * 注意，字符串连接顺序以及循环的方向都是从左到右的（即下标增加的方向）。
    * */

    StringBuilder result=new StringBuilder();
    char first;
    public String splitLoopedString(List<String> strs) {
        for(int i=0;i<strs.size();i++){
            String cur=strs.get(i);
            if(reverse(cur).compareTo(cur)>0){
                strs.set(i,reverse(cur));
            }
        }
        strs.sort((o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        for(String cur:strs){
            result.append(cur);
        }
        first=result.charAt(0);
        for(int i=0;i<strs.size();i++){
            String cur=strs.get(i);
            generateS(cur,strs,i);
            generateS(reverse(cur),strs,i);
        }
        return result.toString();
        // write your code here
    }
    private void generateS(String cur,List<String> strs,int i){
        for(int j=0;j<cur.length();j++){
            if(cur.charAt(j)>=first){
                StringBuilder sb=new StringBuilder();
                sb.append(cur.substring(j));
                for(int k=i+1;k<i+strs.size();k++){
                    sb.append(strs.get(k%strs.size()));
                }
                sb.append(cur.substring(0,j));
                if(sb.toString().compareTo(result.toString())>0){
                    result=sb;
                    first=cur.charAt(j);
                }
            }
        }
    }

    private String reverse(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }

}
