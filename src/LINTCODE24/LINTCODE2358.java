package LINTCODE24;

import java.util.Scanner;

public class LINTCODE2358 {
    /*Description
    *
    * */

    public class Solution {
        {

        }
                   public Solution(){

        }

        // write your code here
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        int sum1=0,sum2=0;
        for(int i=1;i<=n;i+=2)
            sum1+=i;
        for(int i=2;i<=n;i+=2)
            sum2+=i;
        System.out.println(sum1);
        System.out.println(sum2);
        for(int i=2;i<=100;i++){
            boolean isPrime=true;
            for(int j=2;j<=Math.sqrt(i)&&isPrime;j++){
                if(i%j==0){
                    isPrime=false;
                }
            }
            if(isPrime)
                System.out.println(i);
        }
        // write your code here

    }
}
