package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_19 {
    /*Description
    * 判断数组中是否有一组abc满足使得x为方程的解
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int x=s.nextInt();
        int xx=x*x;
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=s.nextInt();
        for(int i=0;i<n;i++){
            int a=num[i];
            for(int j=0;j<n;j++){
                int b=num[j];
                for(int k=0;k<n;k++){
                    int c=num[k];
                    if(a*xx+b*x+c==0){
                        System.out.println("YES");
                        return;
                    }
                    if(b*b-4*a*c<0)
                        break;
                }
            }
        }
        System.out.println("NO");
    }
}
