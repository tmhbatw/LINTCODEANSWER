package LINTCODE13;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1299 {
    /*Description
    *你正在和你的朋友玩 猜数字 (Bulls and Cows)游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，
    * 告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
    * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A表示公牛，用 B表示奶牛。
    * 请注意秘密数字和朋友的猜测数都可能含有重复数字
    * */

    public String getHint(String secret, String guess) {
        int Bulls=0;
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<secret.length();i++){
            char cur1=secret.charAt(i);
            char cur2=guess.charAt(i);
            if(cur1==cur2)
                Bulls++;
            else{
                map1.put(cur1, map1.getOrDefault(cur1,0)+1);
                map2.put(cur2,map2.getOrDefault(cur2,0)+1);
            }
        }
        int Cows=0;
        for(Map.Entry entry:map1.entrySet()){
            char number= (char) entry.getKey();
            Cows+=Math.min(map1.get(number),map2.getOrDefault(number,0));
        }
        return Bulls+"A"+Cows+"B";
    }
}
