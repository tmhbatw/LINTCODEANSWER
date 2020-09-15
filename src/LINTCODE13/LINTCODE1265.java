package LINTCODE13;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1265 {
    /*Description
    * 有一个从1到n的排序整数列表。从左到右，然后删除第一个数字和每隔一个数字删一个，直到到达列表末尾。
    * 再次重复上一步，但这次从右到左，从剩余的数字中删除最右边的数字和每隔一个数字删一个。
    * 我们继续重复这些步骤，从左到右，从右到左交替，直到剩下一个数字。
    * 找到长度为 n 的列表剩下的最后一个数字
    * */

    public int lastRemaining(int n) {
        if(n==1)
            return 1;
        return 2*(n/2-lastRemaining(n/2)+1);
    }


    //笨比强行转化算法
/*    public int lastRemaining(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        int number=list.size();
        int step=1;
        while(number!=1){
            int last=number-1;
            if(step%2==1&&number%2==0){
                last--;
            }
            for(int j=last;j>=0;j-=2)
                list.remove(j);
            step++;
            number=list.size();
        }
        return list.get(0);
        // write your code here
    }*/
}
