package LINTCODE5;

public class LINTCODE420 {

    /*Description
    * 报数指的是，按照其中的整数的顺序进行报数，然后得到下一个数。
    * */

    /*Solution
    * 递归
    * */

    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String last=countAndSay(n-1);
        char curr=last.charAt(0);
        int count=1;
        String result="";
        for(int i=1;i<last.length();i++){
            if(curr== last.charAt(i)){
                count++;
                continue;
            }
            result+=count+""+curr;
            curr=last.charAt(i);
            count=1;
        }
        result+=count+""+curr;
        return result;
        // write your code here
    }
}
