package LINTCODE8;

public class LINTCODE799 {
    /*Description
    * 给一些不同价值和数量的硬币。找出[1，n]范围内的总值有多少种形成方式？
    * */

    public int backPackVIII(int n, int[] value, int[] amount) {
        boolean[] reached=new boolean[n+1];
        reached[0]=true;
        int res=0;
        for(int i=0;i<value.length;i++){
            int[] countArray=new int[n+1];
            for(int j=value[i];j<=n;j++){
                if(reached[j])
                    continue;
                if(reached[j-value[i]]&&countArray[j-value[i]]<amount[i]){
                    countArray[j]=countArray[j-value[i]]+1;
                    reached[j]=true;
                    res++;
                }
            }
        }
        return res;
        // write your code here
    }
}
