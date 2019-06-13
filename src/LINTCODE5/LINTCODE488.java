package LINTCODE5;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE488 {
    /*Description
    * 写一个算法来判断一个数是不是"快乐数"。
    * 一个数是不是快乐是这么定义的：对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。如果可以变为1，那么这个数就是快乐数。
    * */

    /*Solution
    * 使用一个set保存出现过的数即可
    * */

    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(n!=1){
            set.add(n);
            int result=0;
            for(int i=0;i<String.valueOf(n).length();i++){
                int curr=n%10;
                result+=curr*curr;
                n/=10;
            }
            n=result;
            if(set.contains(result))
                return false;
            n=result;
        }
        return true;
        // write your code here
    }

}
