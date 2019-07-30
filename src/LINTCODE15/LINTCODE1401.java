package LINTCODE15;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1401 {
    /*Description
    * 我们正常的单词不会有连续两个以上相同的字母，如果出现连续三个或以上的字母，
    * 那么这是一个抽搐词。现在给一个单词，从左至右求出所有抽搐字母的起始点和结束点。
    * */

    public int[][] twitchWords(String str) {
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<str.length()-2;i++){
            if(str.charAt(i)==str.charAt(i+1)&&str.charAt(i+1)==str.charAt(i+2)){
                int start=i;
                char cur=str.charAt(i);
                i=i+3;
                while(i<str.length()&&str.charAt(i)==cur)
                    i++;
                list.add(new int[]{start,--i});
            }
        }
        int[][] res=new int[list.size()][2];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
        return res;
        // Write your code here
    }

}
