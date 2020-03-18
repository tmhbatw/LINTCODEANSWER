package LINTCODE15;

import java.util.PriorityQueue;

public class LINTCODE1423 {
    /*Description
    * 爱丽丝有一手（hand）由整数数组给定的牌。现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
    * 如果她可以完成分组就返回 true，否则返回 false。
    * */

    public boolean isNStraightHand(int[] hand, int W) {
        int length=hand.length;
        if(length%W!=0)
            return false;
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int num:hand)
            p.add(num);
        while(!p.isEmpty()){
            int cur=p.poll();
            for(int i=1;i<W;i++){
                if(!p.remove(i+cur))
                    return false;
            }
        }
        return true;
        // write your code here
    }

    public static void main(String[] args){
        PriorityQueue<Integer> p=new PriorityQueue<>();
        p.add(1);
        p.add(2);
        p.add(3);
        p.remove(2);
        System.out.println(p);
        System.out.println(p.remove(2));
    }
}
