package LINTCODE4;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE331 {
    /*Description
    *拍卖会上有k个参与者，每个人都举了一个牌子，牌子上的数字分别是1-k。为了防止有人举牌子的时候180°旋转导致混淆了牌子上的数字，
    * 需要将一些会导致混淆的数字加上下划线。比如当0、1、6、8、9旋转180度时，它们分别变为0、1、9、8、6。而2、3、4、5、7 旋转 180° 后，
    * 是无法得到任何数字的。易混淆数（Confusing Number）指的是一个数字在整体旋转 180° 以后，能够得到一个和原来不同的数，
    * 且新数字的每一位都应该是有效的、并且还在1-k的范围内。给出正整数 k，请你返回此时易混淆数字的数量。
    * */

    int[] match=new int[]{0,1,0,0,0,0,9,0,8,6};
    public int theConfusingNumbers(int k) {
        int result = 0;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(6);
        q.add(8);
        q.add(9);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur>k)
                continue;
            if(cur%10!=0&&isConfusingNumber(cur,k))
                result++;
            q.add(cur*10);
            q.add(cur*10+1);
            q.add(cur*10+6);
            q.add(cur*10+8);
            q.add(cur*10+9);
        }
        return result;
        // write your code here
    }

    private boolean isConfusingNumber(int num, int k){
        int cur=num;
        int res=0;
        while(cur>0){
            int left=cur%10;
            res=res*10+match[left];
            cur/=10;
        }
        return res!=num&&res<=k;
    }
}
