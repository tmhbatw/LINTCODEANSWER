package LINTCODE11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE1045 {
    /*Description
    * 给出一个由小写字母组成的字符串S。需要将这个字符串分割成尽可能多的部分，
    * 使得每个字母最多只出现在一个部分中，并且返回每个部分的长度。
    * */

    public List<Integer> partitionLabels(String S) {
        if(S.length()==0){
            List<Integer> list=new  ArrayList<Integer>();
            list.add(0);
            return list;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i),i);
        }
        List<Integer> result=new ArrayList<>();
        int pre=-1;
        int last=map.get(S.charAt(0));
        for(int i=0;i<S.length();i++){
            if(last==i) {
                result.add(last - pre);
                pre=last;
                if(i!=S.length()-1)
                    last=map.get(S.charAt(i+1));
            }
            last=Math.max(last,map.get(S.charAt(i)));
        }
        return result;
        // Write your code here
    }
}
