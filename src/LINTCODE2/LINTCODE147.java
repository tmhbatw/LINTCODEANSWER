package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE147 {
    /*Description
    * 水仙花数的定义是，这个数等于他每一位上数的幂次之和 见维基百科的定义
    * 比如一个3位的十进制整数153就是一个水仙花数。因为 153 = 13 + 53 + 33。
    * 而一个4位的十进制数1634也是一个水仙花数，因为 1634 = 14 + 64 + 34 + 44。
    * 给出n，找到所有的n位十进制水仙花数。
    * */

    /*Solution
    * 枚举遍历
    * */

    public List<Integer> getNarcissisticNumbers(int n) {
        List<Integer> result=new ArrayList<>();
        int start=1,end=10;
        for(int i=0;i<n-1;i++){
            start*=10;end*=10;
        }
        if(n==1)
            start=0;
        for(int i=start;i<end;i++){
            int curr=i,count=0;
            for(int j=0;j<n;j++){
                count+=(int)(Math.pow(curr%10,n));
                curr/=10;
            }
            if(count==i)
                result.add(i);
        }
        return result;
        // write your code here
    }
}
