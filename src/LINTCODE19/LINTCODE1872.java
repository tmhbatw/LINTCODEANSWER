package LINTCODE19;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE1872 {
    /*Description
    *为了装修新房，你需要加工一些长度为正整数的棒材 sticks。
    * 如果要将长度分别为 X 和 Y 的两根棒材连接在一起，你需要支付 X + Y 的费用。 由于施工需要，你必须将所有棒材连接成一根。
    * 返回你把所有棒材 sticks 连成一根所需要的最低费用。注意你可以任意选择棒材连接的顺序
    * */

    public int MinimumCost(List<Integer> sticks) {
        int result=0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int cur:sticks)
            q.add(cur);
        while(q.size()>1){
            int charge=q.poll()+q.poll();
            result+=charge;
            q.add(charge);
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        q.add(3);
        q.add(1);
        System.out.println(q);
    }
}
