package LINTCODE14;

public class LINTCODE1312 {
    /*Description
    * 给定整数n，计算出现在小于等于n的所有非负整数中的数字1的总数。
    * */


    //像密码锁一样
    public int countDigitOne(int n) {
        if(n<=0)
            return 0;
        if(n<10)
            return 1;
        int result =0;
        String num=String.valueOf(n);

        //个位上的1
        result += n/10+(n%10==0?0:1);

        //最大位上的1
        if(num.charAt(0)>'1')
            result+=Math.pow(10,num.length()-1);
        else
            result+=Integer.parseInt(num.substring(1))+1;

        System.out.println(result);
        for(int i=1;i<num.length()-1;i++){
            int pre=Integer.parseInt(num.substring(0,i));
            int post=Integer.parseInt(num.substring(i+1));
            result +=(pre)*Math.pow(10,num.length()-1-i);
            switch (num.charAt(i)){
                case '0':
                    break;
                case '1':
                    result+=post+1;
                    break;
                default:
                    result+=Math.pow(10,num.length()-1-i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        int test=100;
        System.out.println(new LINTCODE1312().countDigitOne(test));
    }
}
