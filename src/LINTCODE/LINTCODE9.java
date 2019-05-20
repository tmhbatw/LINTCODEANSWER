package LINTCODE;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE9 {

    /*Description
    * 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：
   * 如果这个数被3整除，打印fizz.
    * 如果这个数被5整除，打印buzz.
    * 如果这个数能同时被3和5整除，打印fizz buzz.
    * 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
    * Challenge
    *使用尽量少的if
    * */

    /*Solution
    * 使用一次嵌套的三目运算符解决问题
    * */

    public List<String> fizzBuzz(int n) {
        List<String> result=new ArrayList<>();
        for(int i=1;i<=n;i++){
            int s=i%15;
            result.add(s==0?"fizz buzz":s%3==0?"fizz":s%5==0?"buzz":String.valueOf(i));
        }
        return result;
    }
}
