package LINTCODE11;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE1001 {
    /*Description
    * 给定一个整数数组，代表一行小行星。对于每个小行星，绝对值表示其大小，符号表示其方向（正意义右，负意义左）。
    * 每个小行星以相同的速度移动。
    * 返回所有碰撞发生后小行星的状态。 如果两颗小行星相遇，则较小的小行星会爆炸。
    * 如果两者的大小相同，则两者都会爆炸。 沿同一方向移动的两颗小行星永远不会相遇。
    * */

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> q=new Stack<>();
        List<Integer> result=new ArrayList<>();
        for(int cur:asteroids){
            if(cur<0){
                int abs=-cur;
                while(!q.isEmpty()&&q.peek()<abs){
                    q.pop();
                }
                if(q.isEmpty())
                    result.add(cur);
                else if(q.peek()==abs)
                    q.pop();
            }else{
                q.add(cur);
            }
        }
        int[] res=new int[result.size()+q.size()];
        for(int i=0;i<result.size();i++)
            res[i]=result.get(i);
        for(int i=res.length-1;i>=result.size();i--)
            res[i]=q.pop();
        return res;
        // write your code here
    }
}
