package LINTCODE5;

public class LINTCODE407 {

    /*Description
    * Given a non-negative number represented as an array of digits, plus one to the number.
    * The digits are stored such that the most significant digit is at the head of the list.
    * */

    /*Solution
    * 当且仅当digits全部为9的时候数组会扩展，特殊讨论这种情况即可
    * */

    public int[] plusOne(int[] digits) {
        boolean expand=true;
        for(int num:digits){
            if(num!=9){
                expand=false;
                continue;
            }
        }
        if(expand){
            int[] result=new int[digits.length+1];
            result[0]=1;
            return result;
        }
        int count=1;
        for(int i=digits.length-1;i>=0;i--){
            digits[i]=(digits[i]+count)%10;
            count=(digits[i]==0?1:0);
            if(count==0)
                break;
        }
        return digits;
        // write your code here
    }
}
