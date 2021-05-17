package LINTCODE23;

import java.text.DecimalFormat;

public class LINTCODE2283 {
    /*Description
    * 给出圆形的半径 r，请计算圆型的周长并将计算结果保留两位有效数字通过 System.out.printf 语句输出。
    * */

    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        DecimalFormat df=new DecimalFormat("#.00");
        double rr=r*Math.PI;
        System.out.println(df.format(rr));
        // write your code here
        // please print the perimeter of the circle
    }

    public final class Solution {
        final String SENTENCES="TO BE OR NOT TO BE";

        String name;

        public final void test(String name){
            System.out.println(name+" said: "+SENTENCES);
        }
        // write your code here
    }

}
