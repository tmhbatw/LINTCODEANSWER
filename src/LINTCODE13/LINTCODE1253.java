package LINTCODE13;

public class LINTCODE1253 {
    /*Description
    * 给定一个整数，写一个函数将其转换为16进制。对于负整数，需要使用二进制补码
    * */

    public String toHex(int num) {
        if(num==0)
            return "0";
        long cur=num;
        if(num<0){
            cur-=Integer.MIN_VALUE;
            cur-=Integer.MIN_VALUE;
        }
        char[] change=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result="";
        while(cur>0){
            int curr= (int) (cur%16);
            result=change[curr]+result;
            cur/=16;
        }
        return result;
        // Write your code here
    }




    public static void main(String[] args){
        long cur=Integer.MIN_VALUE;
        cur=cur*2;
        System.out.println(cur);
    }
}
