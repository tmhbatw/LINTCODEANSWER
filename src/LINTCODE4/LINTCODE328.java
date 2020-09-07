package LINTCODE4;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE328 {
    /*Description
    *给出一个字符串，均为大写字母，将这个字符串划分成尽可能多的部分，
    * 使每种字母只会出现一个部分中。返回一个数组包含每个部分的长度。
    * */

    public List<Integer> splitString(String s) {
        int[] lastIndex=new int[26];
        int length=s.length();
        for(int i=0;i<length;i++)
            lastIndex[s.charAt(i)-'A']=i;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<length;i++){
            int start=i;
            int curLastIndex=lastIndex[s.charAt(i)-'A'];
            while(i<curLastIndex){
                curLastIndex=Math.max(curLastIndex,lastIndex[s.charAt(++i)-'A']);
            }
            result.add(i-start+1);
        }
        return result;
        // write your code here.
    }
}
