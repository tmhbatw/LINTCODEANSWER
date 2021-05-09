package LINTCODE13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1269 {
    /*Description
    *有 n 个人正在玩丢手绢。编号为0,1...n−1。
    * 一开始，每个人手上都拿着一块自己手绢。接下来的每一轮，第 i 个人会把当前手里的手绢丢给一个固定的人toi。
    * 当有人重新拿到自己的手绢时，游戏就会结束。请求出游戏会在第几轮结束。
    * */

    public int gameTurns(List<Integer> to) {
        if(to.isEmpty())
            return 0;
        int length=to.size();
        int result=Integer.MAX_VALUE;
        boolean[] r=new boolean[length];
        for(int i=0;i<length;i++){
            boolean[] reached=new boolean[length];
            int count=0;
            int curIndex=i;
            while(!reached[curIndex]){
                reached[curIndex]=true;
                count++;
                curIndex=to.get(curIndex);
            }
            if(curIndex==i) {
                result = Math.min(result, count);
            }
        }
        return result;
        // write your code here,
    }
}
