package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE411 {

    /*Description
    * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个二进制的差异。
    * 给定一个非负整数 n ，表示该代码中所有二进制的总数，请找出其格雷编码顺序。一个格雷编码顺序必须以 0 开始，并覆盖所有的 2n 个整数。
    * */

    /*Solution
    * 找规律递归即可
    * */

    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        if(n==0){
           result.add(0);
           return result;
        }
        List<Integer> last=grayCode(n-1);
        result.addAll(last);
        for(int i=last.size()-1;i>=0;i--){
            result.add(last.get(i)+(1<<n));
        }
        return result;
        // write your code here
    }
}
