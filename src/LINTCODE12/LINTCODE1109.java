package LINTCODE12;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1109 {
    /*Description
    * 在Dota2的世界中，有两个党派：Radiant和Dire。
    * Dota2参议院由来自两党的参议员组成。现在，参议院想要对Dota2游戏的变化做出决定。对此变化的投票是基于回合的。
    * 在每一回合中，每位参议员都可以行使以下两项权利之一：
    * 禁止一位参议员的权利：一个参议员可以让另一位参议员在这次以及随后的所有回合中失去所有投票权。
    * 宣布胜利：如果这位参议员发现仍然有投票权的参议员都来自同一方，他可以宣布胜利并做出关于比赛变化的决定。
    * 给出代表每个参议员所属党派的字符串。字符“R”和“D”分别代表Radiant方和Dire方。然后，如果有n个参议员，则给定字符串的大小将为n。
    * 基于回合的过程从给定顺序的第一个参议员到最后一个参议员开始。此程序将持续到投票结束。在这个过程中，所有失去投票权的参议员都将被跳过。
    * 假设每个参议员足够聪明并且将为自己的政党发挥最佳策略，你需要预测哪一方最终宣布胜利并使Dota2比赛进行改变。输出应为Radiant或Dire。
    * */

    public String predictPartyVictory(String senate) {
        Queue<Integer> queueD=new LinkedList<>();
        Queue<Integer> queueR=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='D')
                queueD.add(i);
            else
                queueR.add(i);
        }
        int size=senate.length();
        while(!queueD.isEmpty()&&!queueR.isEmpty()){
            int curD=queueD.poll();
            int curR=queueR.poll();
            if(curD<curR){
                queueD.add(curD+size);
            }else
                queueR.add(curR+size);
        }
        return queueD.isEmpty()?"R":"D";
        // write your code here
    }
}
