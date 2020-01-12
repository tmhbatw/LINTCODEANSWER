package LINTCODE17;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1665 {
    /*Description
    *给出一个十进制数num，现在你需要把它转成二进制数，并返回1的个数和位置。
    * */

    public int[] calculateNumber(int num) {
        int time=0;
        int pos=1;
        List<Integer> list=new ArrayList<>();
        while(num>0){
            if(num%2==1){
                time++;
                list.add(pos);
            }
            pos++;
            num/=2;
        }
        int[] result=new int[list.size()+1];
        result[0]=time;
        for(int i=0;i<list.size();i++){
            result[list.size()-i]=pos-list.get(i);
        }
        return result;
        // Write your code here.
    }
}
