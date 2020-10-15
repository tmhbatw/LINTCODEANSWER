package LINTCODE16;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1527 {
    /*Description
    * 根据一款叫做雀魂的麻将游戏，简化了游戏规则，具体如下：
    * 1.总共有36张牌，每张牌是1~9。每个数字4张牌。
    * 2.如果取出14张牌满足如下条件，即算作和牌：
    * ①14张牌中有2张相同数字的牌，称为雀头。
    * ②除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。
    * 注：顺子的意思是递增的连续3个数字牌（例如234,567等），刻子的意思是相同数字的3个数字牌（例如111,777）。
    * 从36张牌中抽取了13张牌，那么在剩下的23张牌中再取一张牌，取到哪几种数字牌可以和牌？
    * */


    public List<Integer> getTheNumber(int[] cards) {
        int[] card=new int[10];
        for(int cur:cards)
            card[cur]++;
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=9;i++){
            if(card[i]==4)
                continue;
            int[] curCard=card.clone();
            curCard[i]++;
            if(judge1(curCard))
                result.add(i);
        }
        if(result.isEmpty())
            result.add(0);
        return result;
        // write your code here
    }

    private boolean judge1(int[] card){
        for(int i=1;i<10;i++){
            if(card[i]>=2){
                int[] curCard=card.clone();
                curCard[i]-=2;
                if(judge2(curCard))
                    return true;
            }
        }
        return false;
    }

    private boolean judge2(int[] card){
        for(int i=1;i<10;i++){
            if(card[i]==3||card[i]==0)
                continue;
            if(card[i]==4)
                card[i]-=3;
            if(i>=8||card[i+1]!=card[i]||card[i+2]!=card[i])
                return false;
            card[i+1]-=card[i];
            card[i+2]-=card[i];
        }
        return true;
    }
}
