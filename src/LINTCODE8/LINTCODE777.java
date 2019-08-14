package LINTCODE8;

public class LINTCODE777 {
    /*Description
    *给出一个正整数 num,写一个函数，要求当这个当num为完全平方数时函数返回True，否则返回False
    * */

    public boolean isPerfectSquare(int num) {
        int index=1;
        int add=3;
        while(true){
            if(num==index)
                return true;
            if(num<index||index>index+add)
                return false;
            index+=add;
            add+=2;
        }
        // write your code here
    }
}
