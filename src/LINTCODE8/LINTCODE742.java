package LINTCODE8;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE742 {
    /*Description
    * 一个数字整除数是指一个可以被其中包含的每个数字整除的数.
    * 举个例子, 128是一个数字整除数, 因为 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    * 并且, 数字整除数不允许包含数字 0.
    * 给出数字取值的上下限, 输出一个包含所有数字整除数的列表, 包括边界.
    * */

    public static void main(String[] args){
        int cur=Integer.MAX_VALUE;
        System.out.println(new LINTCODE742().isMatch(cur));
    }

    public List<Integer> digitDivideNums(int lower, int upper) {
        List<Integer> result=new ArrayList<>();
        if(upper==Integer.MAX_VALUE)
            upper--;
        for(int i=lower;i<=upper;i++){
            if(isMatch(i))
                result.add(i);
        }
        return result;
        // write your code here
    }

    private boolean isMatch(int cur){
        int curr=cur;
        while(curr>0){
            int last=curr%10;
            curr/=10;
            if(last==0)
                return false;
            if(cur%last!=0)
                return false;
        }
        return true;
    }
}
