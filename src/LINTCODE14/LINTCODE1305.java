package LINTCODE14;

public class LINTCODE1305 {
    /*Description
    * 把一个非负整数转成英文单词的形式。给定的输入一定比2^31-1小。
    * */

    int[] number=new int[]{1000000000,1000000,1000,100};
    String[] s=new String[]{"Billion","Million","Thousand","Hundred"};
    String[] numSmall=new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] numBig=new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    public String numberToWords(int num) {
        if(num<=20)
            return numSmall[num];
        if(num<100){
            if(num%10==0)
                return numBig[num/10-2];
            return numBig[num/10-2]+" "+numSmall[num%10];
        }
        if(num<1000) {
            int big=num/100;
            int left=num%100;
            if(left==0)
                return numberToWords(big)+" "+s[3];
            return numberToWords(big)+" "+s[3]+" "+numberToWords(left);
        }
        if(num<1000000){
            int big=num/1000;
            int small=num%1000;
            if(small==0)
                return numberToWords(big)+" "+s[2];
            return numberToWords(big)+" "+s[2]+" "+numberToWords(small);
        }
        if(num<1000000000){
            int big=num/1000000;
            int small=num%1000000;
            if(small==0)
                return numberToWords(big)+" "+s[1];
            return numberToWords(big)+" "+s[1]+" "+numberToWords(small);
        }
        int big=num/1000000000;
        int small=num%1000000000;
        if(small==0)
            return numberToWords(big)+" "+s[0];
        return numberToWords(big)+" "+s[0]+" "+numberToWords(small);
        // Write your code here
    }

    public static void main(String[] args){
        int number=(int)(Math.pow(2,32)-1);
        System.out.println(number);
    }
}
