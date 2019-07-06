package LINTCODE5;

public class LINTCODE478 {
    /*Description
    * 给出两个整数 a , b ,以及一个操作符 opeator
    * +, -, *, /
    * */

    public int calculate(int a, char operator, int b) {
        switch (operator){
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
            case '/':return a/b;
        }
        return 0;
        // write your code here
    }
}
