package LINTCODE4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE371 {
    /*Description
    *Print numbers from 1 to the largest number with N digits by recursion.
    * */

    /*Solution
    * 普通的递归会造成排序出现错误
    * 我们可以采用递归获取n-1的结果，给每一个数字*10+0到9中的数字即可
    * */

    public List<Integer> numbersByRecursion(int n) {
        List<Integer> result=new ArrayList<>();
        if(n==1){
            for(int i=1;i<=9;i++)
                result.add(i);
            return result;
        }else{
            List<Integer> last=numbersByRecursion(n-1);
            result.addAll(last);
            for(int i = (int) Math.pow(10,n-1)-1; i<last.size(); i++){
                for(int j=0;j<=9;j++){
                    result.add(last.get(i)*10+j);
                }
            }
            return result;
        }
        // write your code here
    }
    private void recursion(List<Integer> result,int n,int start){
        if (n > 0) {
            for(int i=0;i<=9;i++){
                if(start*10+i==0)
                    continue;
                result.add(start*10+i);
                recursion(result,n-1,start*10+i);
            }

        }
    }
}
