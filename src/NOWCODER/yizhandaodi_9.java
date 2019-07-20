package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_9 {


    /*Description
    *  There are n students going to travel. And hotel has two types room:double room and triple room. The price of a double room is p2 and the price of a triple room is p3
    *  Now you need to calulate the minimum total cost of these students.
    * 输入描述:
    * The first line has three integers n, p2, p3
    * 输出描述:
    * Output the minimum total cost.
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        long n=s.nextInt();
        long p2=s.nextInt();
        long p3=s.nextInt();
        double p2PerStu=p2*1.0/2;
        double p3PerStu=p3*1.0/3;
        if(p3PerStu<p2PerStu){
            long result;
            if(n%3==0){
                result=n/3*p3;
            }else if(n%3==1){
                result=(n/3-1)*p3;
                result+=Math.min(2*p2,2*p3);
            }else{
                result=(n/3-1)*p3;
                result+=Math.min(2*p3,p2+p3);
            }
            System.out.println(result);
        }else{
            long result;
            if(n%2==0){
                result=n/2*p2;
            }else{
                result=(n/2-1)*p2;
                result+=Math.min(2*p2,p3);
            }
            System.out.println(result);
        }

    }
}
