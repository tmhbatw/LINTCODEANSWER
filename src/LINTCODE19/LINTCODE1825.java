package LINTCODE19;

public class LINTCODE1825 {
    /*Description
    *给定一个正整数k，你需要使用以下两种操作，将0变为k：
    * 对操作数加一
    * 对操作数乘二
    * 你需要写一个函数，返回使0变为k的最少操作数
    * */

    public int numberChange(int k) {
        if(k==0)
            return 0;
        if(k==1)
            return 1;
        int[] result=new int[k+1];
        result[1]=1;
        for(int i=2;i<=k;i++){
            result[i]=result[i-1]+1;
            if(i%2==0)
                result[i]=Math.min(result[i],result[i/2]+1);
        }
        return result[k];
        // write your code here
    }
}
