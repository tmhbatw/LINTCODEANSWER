package LINTCODE14;

public class LINTCODE1350 {
    /*Description
    * 给定一个正整数，返回相应的列标题，如Excel表中所示。
    * */

    /*Solution
    * 其实就是转化为26进制
    * */

    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            char cur;
            if(n%26==0){
                n=n/26-1;
                cur='Z';
            }else{
                cur=(char)(n%26-1+'A');
                n/=26;
            }
            sb.append(cur);
        }
        return sb.reverse().toString();
        // write your code here
    }
}
