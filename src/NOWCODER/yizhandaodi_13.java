package NOWCODER;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class yizhandaodi_13 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        BigInteger sum=sin.nextBigInteger();
        int b=sin.nextInt();
        int[] zuo=new int[n];
        int[] you=new int[n];
        for(int i=0;i<n;i++)
        {
            zuo[i]=sin.nextInt();
            you[i]=sin.nextInt();
        }
        int tmp;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(zuo[i]*you[i]>zuo[j]*you[j])
                {
                    tmp=zuo[i];
                    zuo[i]=zuo[j];
                    zuo[j]=tmp;

                    tmp=you[i];
                    you[i]=you[j];
                    you[j]=tmp;
                }
            }
        }

        BigInteger max=new BigInteger("0");
        for(int i=0;i<n;i++)
        {
            BigInteger sum1=new BigInteger("0");
            sum1=sum.divide(BigInteger.valueOf(you[i]));
            max=max.max(sum1);
            sum=sum.multiply(BigInteger.valueOf(zuo[i]));

        }
        System.out.println(max);
    }


}
