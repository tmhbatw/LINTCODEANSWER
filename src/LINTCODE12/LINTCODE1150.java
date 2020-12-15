package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1150 {
    /*Description
    * 给定表示分数加法和减法表达式的字符串，你需要以字符串格式返回计算结果。 最终结果应该是不可简化的分数。
    * 如果您的最终结果是整数，例如2，则需要将其更改为具有分母1的分数格式。因此，在这种情况下，2应转换为2/1。
    * */

    public String fractionAddition(String expression) {
        int[] result=new int[]{0,1};
        boolean positive=true;
        int length=expression.length();
        for(int i=0;i<length;i++){
            char cur=expression.charAt(i);
            switch (cur){
                case ' ':
                    break;
                case '+':
                    positive=true;
                    break;
                case '-':
                    positive=false;
                    break;
                default:
                    int cur1=cur-'0';
                    while(expression.charAt(i+1)!='/'){
                        char curr=expression.charAt(++i);
                        if(curr!=' '){
                            cur1=cur1*10+curr-'0';
                        }
                    }
                    i++;
                    int cur2=0;
                    while(i<length-1&&expression.charAt(i+1)!='+'&&expression.charAt(i+1)!='-'){
                        char curr=expression.charAt(++i);
                        if(curr!=' ')
                            cur2=cur2*10+curr-'0';
                    }
                    result=getRes(result,new int[]{cur1,cur2},positive);
            }
        }
        return result[0]+"/"+result[1];
        // write your code here
    }

    private int[] getRes(int[] cur1,int[] cur2,boolean positive){
        if(cur1[0]==0&&cur2[0]==0)
            return new int[]{0,1};
        if(cur1[0]==0)
            return positive?cur2:new int[]{-cur2[0],cur2[1]};
        if(cur2[0]==0)
            return cur1;
        int denominator=cur1[1]*cur2[1];
        int member=cur1[0]*cur2[1]+(positive?cur2[0]*cur1[1]:-cur2[0]*cur1[1]);
        if(member==0)
            return new int[]{0,1};
        int divisor=getDivisor(Math.abs(denominator),Math.abs(member));
        return new int[]{member/divisor,denominator/divisor};
    }

    private int getDivisor(int i1,int i2){
        int max=Math.max(i1,i2);
        int min=Math.min(i1,i2);
        int mod=max%min;
        if(mod==0)
            return min;
        return getDivisor(min,mod);
    }
}
