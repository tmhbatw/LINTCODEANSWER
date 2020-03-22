package LINTCODE17;

import java.util.Arrays;

public class LINTCODE1634 {
    /*Description
    * 给定一个密文，和一个解密规则如下：对密文中的每个字母做变换，不同的字母不能变化到同一个字母。
    * 例如banana ->xyzyzy这是一个有效的转换，但banana不可以变成xyyyyy，因为这样就没法解密回来。
    * 现在输入一个很长的字符串，判断该字符串是否存在子串可符合以上的加密解密规则。如果存在，返回字符串"yes"，否则返回字符串"no".
    * */

    public String getAns(String s, String word) {
        char[] str=s.toCharArray();
        char[] w=word.toCharArray();
        int wLength=w.length;
        for(int i=0;i<s.length()-wLength+1;i++){
            int[] num=new int[26];
            Arrays.fill(num,-1);
            int ss=i,ww=0;
            while(ww<wLength){
                int sCur=str[ss]-'a',wCur=w[ww]-'a';
                if(num[sCur]==wCur&&num[wCur]==sCur) {
                    ss++;
                    ww++;
                    continue;
                }
                if(num[sCur]==-1&&num[wCur]==-1){
                    ss++;
                    ww++;
                    num[sCur]=wCur;
                    num[wCur]=sCur;
                }else
                    break;
            }
            if(ww==wLength)
                return "yes";
        }
        return "no";
        // Write a code here
    }
}
