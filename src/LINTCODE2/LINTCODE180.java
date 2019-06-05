package LINTCODE2;

import datastructure.Interval;

public class LINTCODE180  {
    /*Description
    * Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary representation that is passed in as a string.
    * If the fractional part of the number can not be represented accurately in binary with at most 32 characters, return ERROR.
    * */

    /*Solution
    * 使用一个double来表示小数点后的数
    * double*2，如果大于1则当前位置为1，否则为0
    * 如果32位之后double仍然不为0，那么说明无法转化
    * */
    public String binaryRepresentation(String n) {
        if(n.length()==0)
            return null;
        String sign=""+((n.charAt(0)=='+'||n.charAt(0)=='-')?n.charAt(0):"");
        n=sign.length()==0?n:n.substring(1,n.length());
        String[] num=n.split("\\.");
        String pre=Integer.toBinaryString(Integer.parseInt(num[0]));
        String next="";
        if(num.length==1)
            return sign+pre;

        else{
            double decimal=Double.parseDouble("0."+num[1]);

            if(decimal==0)
                return sign+pre;
            for(int i=0;i<32;i++){
                System.out.println(decimal);
                decimal*=2;
                next+=decimal>1?"1":"0";
                decimal-=1;
                if(decimal==0)
                    break;
            }
            if(decimal!=0)
                return "ERROR";

        }
        return sign+pre+"."+next;
        // write your code here
    }

    public static void main(String[] args){
        Long a= Long.valueOf(Integer.MAX_VALUE)*Long.valueOf(Integer.MAX_VALUE);
        System.out.println(a);
        double s=0.5;
        for(int i=0;i<31;i++){
            s*=0.5;
            System.out.println(s);
        }

    }
}
