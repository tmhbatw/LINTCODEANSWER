package LINTCODE2;

public class LINTCODE188 {
    /*Description
    * 给定一个数字，在数字的任意位置插入一个5，使得插入后的这个数字最大
    * */

    public int InsertFive(int a) {
        if(a==0)
            return 50;
        String s=String.valueOf(a);
        int result=0;
        int index=0;
        if(a>0){
            for(;index<s.length();index++){
                int cur=s.charAt(index)-'0';
                if(cur<5)
                    break;
                result=result*10+cur;
            }
            result=result*10+5;
            for(;index<s.length();index++)
                result=result*10+s.charAt(index)-'0';
            return result;
        }
        index++;
        for(;index<s.length();index++){
            int cur=s.charAt(index)-'0';
            if(cur>5)
                break;
            result=result*10+cur;
        }
        result=result*10+5;
        for(;index<s.length();index++)
            result=result*10+s.charAt(index)-'0';
        return -result;
        // write your code here
    }
}
