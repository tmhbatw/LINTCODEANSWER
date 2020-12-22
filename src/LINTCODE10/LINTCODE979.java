package LINTCODE10;

import java.math.BigDecimal;

public class LINTCODE979 {
    /*Description
    * 加法数是一个字符串，它包含的数字可以形成一个加法序列。
    * 一个合法的加法序列至少需要包含三个数字。除了前两个数字，序列中后面的每个数字必须是前两个数字的和。
    * */

    public boolean isAdditiveNumber(String num) {
        if(num.length()<3)
            return false;
        int length=num.length();
        for(int i=0;i<length/2;i++){
            BigDecimal cur=new BigDecimal(num.substring(0,i+1));
            for(int j=i+1;j<Math.min((length-i)/2+i+1,length-1);j++){
                BigDecimal second =new BigDecimal(num.substring(i+1,j+1));
                int k=j+1;
                BigDecimal first=new BigDecimal(cur.toString());
                while(k<=length){
                    if(k==length)
                        return true;
                    first=first.add(second);
                    int curLength=first.toString().length();
                    if(length-k<curLength||!num.substring(k,k+curLength).equals(first.toString()))
                        break;
                    k+=curLength;
                    BigDecimal temp=first;
                    first=second;
                    second=temp;
                }
            }
        }
        return false;
        // Write your code here
    }
}
