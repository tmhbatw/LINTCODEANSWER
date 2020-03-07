package LINTCODE19;

public class LINTCODE1815 {
    /*Description
    * 一个烟雾警报器会监测len秒内的烟雾值，如果这段时间烟雾值平均值大于k那么警报器会报警。
    * 现在给你n个数代表刚开始工作n秒内警报器监测的烟雾值（警报器从第len秒开始判断是否报警），问警报器在这段时间内会报警几次？
    * */

    public long solve(int n, int k, int len, int[] num) {
        long K=k;
        K*=len;
        long curSum=0;
        for(int i=0;i<len-1;i++)
            curSum+=num[i];
        long result=0;
        for(int i=len-1;i<n;i++){
            curSum+=num[i];
            if(curSum>K) {
                System.out.println(curSum+" "+K);
                result++;
            }
            curSum-=num[i-len+1];
        }
        return result;
        //
    }

    public static void main(String[] args){
        long a=49933;
        long b=89187;
        System.out.println(a*89187);
    }
}
