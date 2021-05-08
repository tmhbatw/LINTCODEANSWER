package LINTCODE8;

public class LINTCODE743 {
    /*Description
    *给一非负整数 N, 找到小于等于 N 的最大的 单调递增数. (回想一下, 当且仅当每对相邻的数字
    * x 和 y 满足 x <= y 时, 这个整数才是单调递增数)
    * */

    public int monotoneDigits(int num) {
        int length=(num+"").length();
        int[] res=new int[length];
        for(int i=length-1;i>=0;i--){
            res[i]=num%10;
            num/=10;
        }
        for(int i=0;i<length-1;i++){
            if(res[i]>res[i+1]){
                while(i>=1&&res[i-1]==res[i]){
                    i--;
                }
                res[i]=res[i-1];
                for(int j=i+1;j<length;j++){
                    res[j]=9;
                }
                break;
            }
        }
        int result=0;
        for(int i=0;i<length;i++){
            result=result*10+res[i];
        }
        return result;
        // write your code here
    }
}
