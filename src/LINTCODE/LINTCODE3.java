package LINTCODE;

public class LINTCODE3 {
    /*Description
    Count the number of k's between 0 and n. k can be 0 - 9.
    * */

    /*Solution
     暴力遍历每一个数字可以获得答案
    * */
    public int digitCounts(int k, int n) {
        int result=0;
        char temp=String.valueOf(k).charAt(0);
        for(int i=0;i<n;++i){
            String ii=String.valueOf(i);
            for(int j=0;j<ii.length();++j){
                if(ii.charAt(j)==temp)
                    ++result;
            }
        }
        return result;
    }

}
