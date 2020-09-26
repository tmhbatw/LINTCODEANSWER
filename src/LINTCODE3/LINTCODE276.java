package LINTCODE3;

public class LINTCODE276 {
    /*Description
    *你参加了另一个祖玛游戏，它的游戏规则是这样的：
    * 有一个珍珠序列，每个珍珠上都有一个英文字符。
    * 每 k 个有相同的字符的珍珠排列在一起，它们就会被消除。
    * 消除后分开的两部分序列会合并在一起。
    * 请求出不断消除过后，剩下珍珠序列是怎么样的。
    * */

    public String zumaGaming(String s, int k) {
        int length=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            int time=1;
            while(i<length-1&&s.charAt(i+1)==cur){
                i++;time++;
            }
            time%=k;
            if(time<k)
                sb.append(s.substring(i-time+1,i+1));
        }
        System.out.println(sb.toString());
        if(sb.length()==length)
            return sb.toString();
        return zumaGaming(sb.toString(),k);
        // write your code here.
    }


}
