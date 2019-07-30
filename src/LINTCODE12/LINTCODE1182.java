package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1182 {

    /*Description
    * 给定一个字符串和一个整数k，你需要反转从字符串开头算起的每2k个字符的前k个字符。
    * 如果剩下少于k个字符，则反转所有字符。 如果小于2k但大于或等于k个字符，则反转前k个字符并将另一个保留为原始字符。
    * */

    public String reverseStringII(String s, int k) {
        int start=0;
        StringBuffer sb=new StringBuffer();
        while(start+k+k<=s.length()){
            StringBuffer sbb=new StringBuffer(s.substring(start,start+k)).reverse();
            sb.append(sbb);
            sb.append(s.substring(start+k,start+k+k));
            start=start+k+k;
        }
        if(s.length()-start<=k){
            sb.append(new StringBuffer(s.substring(start,s.length())).reverse());
        }else{
            sb.append(new StringBuffer(s.substring(start,start+k)).reverse());
            sb.append(s.substring(start+k,s.length()));
        }
        return sb.toString();
        // Write your code here.
    }

}
