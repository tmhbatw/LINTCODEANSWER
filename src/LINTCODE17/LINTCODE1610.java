package LINTCODE17;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1610 {
    /*Description
    * 给定一个0,1开头的斐波那契数列和一个整数n ，找到比n 更大和更小的第一个数字，然后返回这些数字。
    * */

    public int[] getNumbers(int n) {
        if(n<0)
            return new int[0];
        if(n==0)
            return new int[]{1};
        if(n==1)
            return new int[]{1};
        int[] result=new int[2];
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(1);
        while(true){
            int size=list.size();
            int cur=list.get(size-1)+list.get(size-2);
            if(cur>n){
                result[1]=(int)cur;
                if(list.get(size-1)==n)
                    result[0]=list.get(size-2);
                else
                    result[0]=list.get(size-1);
                return result;
            }
            list.add(cur);
        }
        // Write your code here
    }
}
