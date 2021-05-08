package LINTCODE4;

public class LINTCODE330 {
    /*Description
    * 给你一个数字N,返回最大的比N小的且每一位是连续递增的数字
    * */

    public long getIncreasingNumber(long N) {
        int length=(N+"").length();
        int[] num=new int[length];
        for(int i=length-1;i>=0;i--){
            num[i]= (int) (N%10);
            N/=10;
        }
        for(int i=0;i<length-1;i++){
            if(num[i]>=num[i+1]){
                while(i>=0&&num[i]>=num[i+1]){
                    num[i]=Math.max(0,num[i]-1);
                    i--;
                }
                for(int j=length-1;j>=i+1;j--){
                    num[j]=9-(length-1-j);
                }
                for(int j=i;j>=0;j--){
                    num[j]=Math.min(9-(length-1-j),num[j]);
                }
                break;
            }
            if(i==length-1){
                for(int j=length-1;j>=1;j--){
                    num[j]=9-(length-1-j);
                }
                num[0]=0;
            }
        }
        long result=0;
        for(int i=0;i<length;i++){
            result=result*10+num[i];
        }
        return result;
        // write your code here
    }
}
