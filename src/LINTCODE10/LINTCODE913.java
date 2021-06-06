package LINTCODE10;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE913 {
    /*Description
    * 翻转游戏：给定一个只包含两种字符的字符串：+和-，你和你的小伙伴轮流翻转"++"变成"--"。
    * 当一个人无法采取行动时游戏结束，另一个人将是赢家。编写一个函数判断是否能够保证先手胜利。
    * */

    Map<String,Boolean> map=new HashMap<>();
    public boolean canWin(String s) {
        char[] c=s.toCharArray();
        return canWin(c);
        // write your code here
    }


    public boolean canWin(char[] c){
        if(map.containsKey(new String(c)))
            return map.get(c);

        for(int i=0;i<c.length-1;i++){
            if(c[i]=='+'&&c[i+1]=='+'){
                c[i]='-';
                c[i+1]='-';
                if(!canWin(c)){
                    c[i]='+';
                    c[i+1]='+';
                    map.put(new String(c),true);
                    //System.out.println(Arrays.toString(c)+" "+true);
                    return true;
                }
                c[i]='+';
                c[i+1]='+';
            }
        }
        map.put(new String(c),false);
        //System.out.println(Arrays.toString(c)+" "+false);
        return false;
    }
}
