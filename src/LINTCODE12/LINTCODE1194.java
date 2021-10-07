package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1194 {
    /*Description
    * 你有n台超级洗衣机。最初，每台洗衣机都有一些衣服或是空的。
    * 对于每一次移动，您可以选择任意m台（1≤m≤n）洗衣机，并将每台洗衣机的一件衣服同时传递给相邻的洗衣机
    * 给定一个整数数组表示每个洗衣机中从左到右的衣服数量，您应该找到最小移动次数，使得所有洗衣机中具有相同数量的衣服。
    * 如果无法执行此操作，请返回-1。
    * */

    public int findMinMoves(int[] machines) {
        int length=machines.length;
        int sum= Arrays.stream(machines).sum();

        if(sum%length!=0)
            return -1;

        sum /= length;
        int result=0;
        int absent=0;
        for(int i=0;i<length;i++){
            if(absent<0){
                machines[i]-=absent;
                absent = 0;
            }
            if(machines[i]<sum)
                absent += sum-machines[i];
            else{
                result=Math.max(result,Math.max(absent,machines[i]-sum));
                absent -= machines[i]-sum;
            }
        }
        return result;
        // Write your code here
    }
}
