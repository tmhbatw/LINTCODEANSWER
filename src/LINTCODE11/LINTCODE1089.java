package LINTCODE11;

public class LINTCODE1089 {
    /*Description
    * 给定一个只包含三种类型字符的字符串：'（'，'）'和 '*'， 编写一个函数来检查该字符串是否有效。 我们通过以下规则定义字符串的有效性：
    * 1.任何左括号 '('必须有一个相应的右括号')'。
    * 2.任何右括号 ')' 必须有一个相应的左括号'('。
    * 3.左括号'(' 必须在相应的右括号 ')' 之前。
    * 4.*可以被视为单个右括号'）'或单个左括号'（'或空字符串。
    * 5.空字符串也有效。
    * */

    public boolean checkValidString(String s) {
        int minLeft=0,maxLeft=0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                    maxLeft++;
                    minLeft++;
                    break;
                case ')':
                    maxLeft--;
                    if(maxLeft==-1)
                        return false;
                    minLeft--;
                    minLeft=Math.max(0,minLeft);
                    break;
                default:
                    minLeft--;
                    maxLeft++;
                    minLeft=Math.max(minLeft,0);
            }
        }
        return minLeft==0;
        // Write your code here
    }
}
