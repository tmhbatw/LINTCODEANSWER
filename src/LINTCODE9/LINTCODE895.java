package LINTCODE9;

import java.util.Arrays;

public class LINTCODE895 {
    /*Description
    *给定一个长为n的数组Ages, 其中第i个元素表示第i个人的年龄。求这个n个人，发送的好友请求的总数。其中，
    * 如果Age(B) <= (1/2)Age(A) + 7, A不会给B发请求
    * 如果Age(B) > Age(A)， A不会给B发请求
    * 如果Age(B) < 100 and Age(A) > 100, A不会给B发请求
    * 不满足1，2，3，则A会给B发请求。
    * */
    public int friendRequest(int[] ages) {
        int result=0;
        for(int j=0;j<ages.length;j++){
            int A=ages[j];
            for(int i=0;i<ages.length;i++){
                if(i==j)
                    continue;
                if(send(A,ages[i]))
                    result++;
            }
        }
        return result;
        // Write your code here
    }

    private boolean send(int A,int B){
        if(A>100&&B<100||B<=A/2+7||B>A)
            return false;
        return true;
    }
}
