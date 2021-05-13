package LINTCODE24;

import java.util.Scanner;

public class LINTCODE2326 {
    /*Description
    *
    * */

    public class Solution {
        /**
         * @param num: num is used to receive incoming integer parameters
         * @methods textDaffodils(): textDaffodils() is a boolean type return
         * value member method that creates an instance of the internal class
         */
        private int num;

        public Solution(int num) {
            this.num = num;
        }

        public boolean testDaffodils() {
            Daffodils daffodils = new Daffodils();
            boolean boolean2 = daffodils .isDaffodilNumber();

            return boolean2;
        }

        private class Daffodils {
            public boolean isDaffodilNumber(){
                int n=num;
                int res=0;
                while(n>0){
                    int last=n%10;
                    n/=10;
                    res+=last*last*last;
                }
                return res==num;
            }
            // write your code here
        }
    }


    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=Integer.parseInt(s.nextLine());
        int res=1;
        for(int i=1;i<=n;i++)
            res*=i;
        System.out.println(res);
        // write your code here
        // read data from console

        // output the answer to the console according to the
        // requirements of the question

    }

    public String alphabetConversion(String str) {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            if(cur<='z'&&cur>='a')
                sb.append((char)(cur+'A'-'a'));
            else if(cur<='Z'&&cur>='A')
                sb.append((char)(cur+'a'-'A'));
            else
                sb.append(cur);
        }
        return sb.toString();
        // write your code here
    }
}
