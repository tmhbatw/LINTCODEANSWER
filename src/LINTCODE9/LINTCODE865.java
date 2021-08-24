package LINTCODE9;

public class LINTCODE865 {
    /*Description
    * 从整数1开始，删除任意整数包含9，像是9, 19, 29...
    * 现在，我们有一串新的整数序列: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
    * 给定正整数n，你需要返回删除之后序列的第n个整数。注意1将会是第一个整数
    * */

    public long newInteger(int n) {
        int l=0;
        int account;
        //首先确定结果的位数
        while((account=getAccountWithout9(l+1))<=n){
            if(account<0)
                break;

            n-=account;
            l++;
        }
        StringBuilder sb=new StringBuilder();


        for(int i=0;i<l;i++){
            int curAccount=get(l-i);
            int add=n/curAccount;
            n%=curAccount;
            char start=(i==0?'1':'0');
            start += add;
            sb.append(start);
        }
        return Long.parseLong(sb.toString());
        // write your code here
    }

    private int get(int length){
        if(length==1)
            return 1;
        int result=9;
        for(int i=0;i<length-2;i++)
            result*=9;
        return result;
    }

    private int getAccountWithout9(int length){
        if(length==1)
            return 1;
        int result=8;
        for(int i=0;i<length-2;i++){
            result*=9;
        }
        return result;
    }

    public static void main(String[] args){
        int test=864564577;
        System.out.println(new LINTCODE865().newInteger(test));
    }
}
