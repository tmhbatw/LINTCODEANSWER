package LINTCODE9;

public class LINTCODE807 {
    /*Description
    * 判断一个非负整数 n 的二进制表示是否为回文数
    * */

    public boolean isPalindrome(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n/=2;
        }
        int left=0,right=sb.length()-1;
        while(left<right){
            if(sb.charAt(left)!=sb.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
        // Write your code here
    }
}
