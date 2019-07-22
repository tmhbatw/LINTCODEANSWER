package NOWCODER;

import java.util.*;

public class yizhandaodi_14 {
    /*Description
    *We consider a positive integer perfect, if and only if it is equal to the sum of its positive divisors less than itself. For example,
    * 6 is perfect because 6 = 1 + 2 + 3. Could you write a program to determine if a given number is perfect or not?
    * 输入描述:
    * The first line of the input is T(1≤ T ≤ 100), which stands for the number of test cases you need to solve.Each test case contains a line with a positive integer N (2 ≤ N ≤ 105).
    * 输出描述:
    * For each test case, print the case number and determine whether or not the number is perfect.If the number is perfect, display the sum of its positive divisors less than itself.
    * The ordering of theterms of the sum must be in ascending order. If a number is not perfect, print "Not perfect.".
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        String[] res=new String[n];
        for(int i=0;i<n;i++){
            int cur=s.nextInt();
            res[i]=getList(cur);
        }
        for(int i=0;i<n;i++) {
            System.out.println("Case " + (i+1) + ":"+res[i]);
        }
    }
    private static String getList(int num){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        int sum=1;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                sum+=i;
                sum+=num/i;
                list.add(i);
                list.add(num/i);
            }
        }
        if(sum!=num)
            return " Not perfect.";
        StringBuilder result= new StringBuilder(" " + num + " = 1 ");
        for(int i=1;i<list.size();i=i+2){
            result.append("+ ").append(list.get(i)).append(" ");
        }
        for(int i=list.size()-1;i>=1;i=i-2){
            result.append("+ ").append(list.get(i)).append(" ");
        }
        String res=result.toString();
        return res.substring(0,res.length()-1);
    }
}
