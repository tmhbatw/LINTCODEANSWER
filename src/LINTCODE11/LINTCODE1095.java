package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1095 {
    /*Description
    * 给定一个非负整数, 你可以选择交换它的两个数位. 返回你能获得的最大的合法的数.
    * */

    public int maximumSwap(int num) {
        char[] c=String.valueOf(num).toCharArray();
        for(int i=0;i<c.length;i++){
            char cur=c[i];
            int index=i;
            for(int j=i+1;j<c.length;j++){
                if(c[j]<=c[i])
                    continue;
                if(c[j]>=cur) {
                    cur = c[j];
                    index=j;
                }
            }
            if(cur>c[i]){
                char temp=c[i];
                c[i]=c[index];
                c[index]=temp;
                return Integer.parseInt(new String(c));
            }
        }
        return num;
        // Write your code here
    }
}
