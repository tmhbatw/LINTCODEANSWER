package LINTCODE17;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1648 {
    /*Description
    * 给定字符串s，按字典顺序返回s的最后一个子字符串。
    * */

    public String maxSubstring(String s) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++)
            list.add(i);
        int diff=-1;
        while(list.size()!=1){
            diff++;
            List<Integer> nextList=new ArrayList<>();
            char cur='a';
            for(int index:list){
                if(index+diff>=s.length())
                    continue;
                char curr=s.charAt(index+diff);
                if(curr>cur){
                    nextList=new ArrayList<>();
                    cur=curr;
                }
                if(curr==cur){
                    nextList.add(index);
                }
            }
            list=nextList;
        }
        return s.substring(list.get(0));
    }
}
