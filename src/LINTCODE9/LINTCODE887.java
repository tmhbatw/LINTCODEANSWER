package LINTCODE9;

public class LINTCODE887 {
    /*Description
    * 给定一个表示任意嵌套三元表达式的字符串expressions，计算表达式的结果。
    * 你可以假设给定的表达式是有效的，并且只由数字0-9,?，T和F组成 (T和F分别表示True和False)。
    * */

    public String parseTernary(String expression) {
        System.out.println(expression);
        if(expression.length()==1)
            return expression;
        char cur=expression.charAt(0);
        int index=-1;
        int length=expression.length();
        int time=0;
        for(int i=2;i<length;i++){
            char curr=expression.charAt(i);
            if(curr=='?')
                time++;
            if(curr==':'){
                if(time==0){
                    index=i;
                    break;
                }
                time--;
            }
        }
        System.out.println(index);
        return cur=='T'?parseTernary(expression.substring(2,index)):parseTernary(expression.substring(index+1,length));
        // write your code here
    }
}
