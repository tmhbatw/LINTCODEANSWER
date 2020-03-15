package LINTCODE17;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1627 {
    /*Description
    * 给定一个很长的字符串s，只包括正常英文单词，单词用单个空格隔开，同时给你一个正整数k。请把字符串切分为若干行，
    * 且行数最少，要求1：只能在单词之间换行，同一个单词不能被分开；要求2：切分后每行不能超过k个字符。
    * */

    public String[] wordSegmentation(String s, int k) {
        String[] list=s.split(" ");
        int index=0;
        int length=list.length;
        List<String> res=new ArrayList<>();
        for(int i=0;i<length;i++){
            StringBuilder sb=new StringBuilder(list[i]);
            while(i<length-1&&sb.length()+list[i+1].length()+1<=k) {
                sb.append(" ").append(list[i + 1]);
                i++;
            }
            res.add(sb.toString());
        }
        String[] result=new String[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
        // Write your code here
    }
}
