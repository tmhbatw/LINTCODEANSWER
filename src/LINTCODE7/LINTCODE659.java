package LINTCODE7;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE659 {
    /*Description
    *设计一个将字符串列表编码为字符串的算法。 已经编码的字符串之后会通过网络发送同时也会被解码回到原始的字符串列表。
    * 请实现 encode 和 decode
    * */

    class Solution {
        /*
         * @param strs: a list of strings
         * @return: encodes a list of strings to a single string.
         */
        public String encode(List<String> strs) {
            StringBuffer sb=new StringBuffer();
            for(String cur:strs){
                sb.append(cur+":;");
            }
            if(sb.length()==0)
                return "";
            return sb.substring(0,sb.length()-2).toString();
            // write your code here
        }

        /*
         * @param str: A string
         * @return: dcodes a single string to a list of strings
         */
        public List<String> decode(String str) {
            String[] strs=str.split(":;");
            List<String> result=new ArrayList<>();
            for(String cur:strs)
                result.add(cur);
            return result;
            // write your code here
        }
    }
}
