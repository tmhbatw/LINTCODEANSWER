package LINTCODE16;

public class LINTCODE1502 {
    /*Description
    * 求出大于或等于N的最小素数回文。
    * 如果只有除数是1和它本身，并且它大于1，则数字是素数。
    * 例如，2,3,5,7,11和13是素数。
    * 如果数字从左到右从右到左读取相同，则它是一个回文。
    * 例如，12321是回文。
    * */

    public int primePalindrome(int N) {
        while(true){
            if(isPalindromeNumber(N)&&!isPrime(N))
                return N;
            N++;
        }
        // Write your code here.
    }

    private boolean isPalindromeNumber(int cur){
        char[] c=String.valueOf(cur).toCharArray();
        int length=c.length;
        for(int i=0;i<length/2;i++){
            if(c[i]!=c[length-i-1])
                return false;
        }
        return true;
    }

    private boolean isPrime(int cur){
        if(cur%2==0)
            return true;
        int max= (int) Math.sqrt(cur);
        for(int i=3;i<=max;i+=2)
            if(cur%i==0)
                return true;
        return false;
    }
}
