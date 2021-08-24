package LINTCODE13;

public class LINTCODE1213 {
    /*description
    * 对于整数n，我们说k（>=2）是一个良进制基当且仅当n用k进制表示时，数字全为1。
    * 给定一个表示n的字符串，以字符串的形式返回最小良进制基。
    * */

    public String smallestGoodBase(String n) {
        long num=Long.parseLong(n);
        int maxLength=Long.toBinaryString(num).length();
        for(int i=maxLength;i>=2;i--){
            long cur;
            if((cur=match(num,i))!=0){
                return cur+"";
            }
        }
        return (num-1)+"";
        // write your code here
    }

    private long match(long num,int length){
        long l=2L,r=Long.MAX_VALUE;
        while(l<r){
            long mid=l+(r-l)/2;
            int big=getBig(mid,length,num);
            if(big==0)
                return mid;
            if(big>0)
                r=mid-1;
            if(big<0)
                l=mid+1;
        }
        return 0;
    }

    private int getBig(long cur, int length, long num){
        long res=1;
        long base=cur;
        for(int i=1;i<length;i++){
            res+=base;
            if(res<0||res>num)
                return 1;
            base*=cur;
        }
        return res==num?0:-1;
    }

    public static void main(String[] args) {
        String text ="1000000000000000000";
        System.out.println(new LINTCODE1213().smallestGoodBase(text));
    }

}
