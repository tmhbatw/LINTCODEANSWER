package LINTCODE18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1728 {
    /*Description
    * 给定一副牌，每张牌上都写着一个整数。
    * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
    * 每组都有 X 张牌。
    * 组内所有的牌上都写着相同的整数。
    * 仅当你可选的 X >= 2 时返回 true。
    * */

    public boolean hasGroupsSizeX(List<Integer> deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int cur:deck){
            int time=map.getOrDefault(cur,0);
            map.put(cur,time+1);
        }
        int result=map.get(deck.get(0));
        for(Map.Entry cur:map.entrySet()){
            result=getDivisor(result, (Integer) cur.getValue());
        }
        return result!=1;
        // write your code here
    }

    private int getDivisor(int a,int b){
        int big=Math.max(a,b);
        int small=Math.min(a,b);
        while(big%small!=0){
            int temp=small;
            small=big%small;
            big=small;
        }
        return small;
    }
}
