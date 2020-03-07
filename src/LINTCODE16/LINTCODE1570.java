package LINTCODE16;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1570 {
    /*Description
    * 从一个二进制流(0/1)里面取出每一位组成二进制串。第i轮可以从流中依次拿i位。每次拿出一位，就把之前的位组成的二进制串往最高位移一位，
    * 再加入当前的位。当拿了j个位（j<=i)的时候，如果当前二进制串的值是可以被3整除的，就输出。
    * */

    public int[] getOutput(String s) {
        List<Integer> list=new ArrayList<>();
        int time1=0;
        int time2=0;
        for(int i=0;i<s.length();i++){
            int temp=time1;
            time1=time2;
            time2=temp;
            if(s.charAt(i)==1){
                time1++;
            }
            System.out.println(time1+" "+time2);
            if((time1*1+time2*2)%3==0)
                list.add(i+1);
        }
        int[] result=new int[list.size()];
        for(int i=0;i<result.length;i++)
            result[i]=list.get(i);
        return result;
        // Write your code here
    }

}
