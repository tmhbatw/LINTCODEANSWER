package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1153 {
    /*Description
    *给定一些由,隔开的字符串，请将他们按字典序排列。
    * */

    public String sorting(String s) {
        if(s==null||s.length()==0)
            return "";
        String[] ss=s.split(",");
        Arrays.sort(ss);
        StringBuilder sb=new StringBuilder();
        for(String cur:ss)
            sb.append(cur).append(",");
        return sb.toString().substring(0,sb.length()-1);
        // write your code here
    }
}
