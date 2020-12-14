package LINTCODE12;

public class LINTCODE1113 {
    /*Description
    *解一个给定的方程，以"x=#value"的格式返回x的值。方程仅仅包含'+'运算、'-'运算、变量x和它的系数。
    * 如果没有解，返回"No solution"。
    * 如果有无穷解，返回"Infinite solutions"。
    * 如果恰有一个解，此题确保该解为整数。
    * */

    private final String INFINITE="Infinite solutions";
    private final String NO_SOLUTION="No solution";
    public String solveEquation(String equation) {
        String[] expression=equation.split("=");
        int[] leftParameter=getParameter(expression[0]);
        int[] rightParameter=getParameter(expression[1]);
        int parameter=leftParameter[0]-rightParameter[0];
        int value=rightParameter[1]-leftParameter[1];
        if(parameter==0&&value==0)
            return INFINITE;
        if(parameter==0)
            return NO_SOLUTION;
        return "x="+value/parameter;
        // write your code here
    }

    private int[] getParameter(String expression){
        int parameter=0,value=0;
        int index=0;
        int length=expression.length();
        boolean positive=true;
        while(index<length){
            char cur=expression.charAt(index);
            index++;
            switch (cur){
                case '+':
                    positive=true;
                    break;
                case '-':
                    positive=false;
                    break;
                case 'x':
                    parameter+=positive?1:-1;
                    break;
                default:
                    int curr=cur-'0';
                    while(index<length&&isNumber(expression.charAt(index))){
                        curr=curr*10+(expression.charAt(index)-'0');
                        index++;
                    }
                    if(index<length&&expression.charAt(index)=='x'){
                        index++;
                        parameter+=positive?curr:-curr;
                    }
                    else{
                        value+=positive?curr:-curr;
                    }
            }
        }
        return new int[]{parameter,value};
    }

    private boolean isNumber(char cur){
        if(cur<='9'&&cur>='0')
            return true;
        return false;
    }
}
