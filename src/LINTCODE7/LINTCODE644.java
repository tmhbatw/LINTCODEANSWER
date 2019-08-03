package LINTCODE7;

import java.util.HashMap;

public class LINTCODE644 {
    /*Description
    *一个镜像数字是指一个数字旋转180度以后和原来一样(倒着看)。例如，数字"69"，"88"，和"818"都是镜像数字。
    * 写下一个函数来判断是否这个数字是镜像的。数字用字符串来表示。
    * */

    public boolean isStrobogrammatic(String num) {
        if(num.length()==0)
            return false;
        HashMap<Character,Character> map=new HashMap<>();
        map.put('6','9');
        map.put('8','8');
        map.put('1','1');
        map.put('9','6');
        map.put('0','0');
        for(int i=0;i<num.length()/2+1;i++){
            char cur=num.charAt(i);
            if(!map.containsKey(cur)||num.charAt(num.length()-1-i)!=map.get(cur))
                return false;
        }
        return true;
        // write your code here
    }
}
