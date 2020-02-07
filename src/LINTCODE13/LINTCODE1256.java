package LINTCODE13;

public class LINTCODE1256 {
    /*Description
    *Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
    * */

    public int findNthDigit(int n) {
        long start=1;
        int length=1;
        long count=9;
        while(n>length*count){
            n-=length*count;
            length++;
            count*=10;
            start*=10;
        }
        long last=n/length+start;
        n%=length;
        if(n==0)
            return String.valueOf(last-1).charAt(length-1)-'0';
        return String.valueOf(last).charAt(n-1)-'0';
        // write your code here
    }
}
