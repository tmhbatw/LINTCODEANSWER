package LINTCODE14;

public class LINTCODE1385 {
    /*Description
    *8是小九的幸运数字，小九想知道在1~n的数中有多少个数字含有8。
    * */

    public int luckyNumber(int n) {
        int result=0;
        for(int i=0;i<n;i++){
            String cur=String.valueOf(i);
            for(int j=0;j<cur.length();j++){
                if(cur.charAt(j)=='8'){
                    result++;
                    break;
                }
            }
        }
        return result;
        // Write your code here
    }
}
