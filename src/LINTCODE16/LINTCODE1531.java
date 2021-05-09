package LINTCODE16;

public class LINTCODE1531 {
    /*Description
    * 有一些单词中有拼写错误，请编写一个程序，能够自动校对单词的拼写，并且返回正确值。校对的规则如下：
    * 如果有三个相同的字符连在一起，一定是拼写错误，去掉其中一个，如：ooops−>oops。
    * 如果有两对一样的字符(AABB的形式)连在一起,，一定是拼写错误，去掉第二对中的一个字符，如：helloo−>hello。
    * 以上两条规则要优先从左往右处理，如：aabbcc 中 aabb 和 bbcc 都是拼写错误，应该优先考虑修复aabb，结果是aabcc。
    * */

    public String automaticProofreadingProgram(String str) {
        StringBuilder sb=new StringBuilder();
        int preCount=0;
        int length=str.length();
        for(int i=0;i<length;i++){
            int count=1;
            char cur=str.charAt(i);
            while(i<length-1&&str.charAt(i+1)==cur){
                i++;
                count++;
            }
            if(preCount==2){
                count=1;
            }else{
                count=Math.min(count,2);
            }
            preCount=count;
            while(count-->0)
                sb.append(cur);
        }
        return sb.toString();
        // Write your code here.
    }
}
