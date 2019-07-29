package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class moni5 {

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=s.nextInt();
        int start=0;
        int curMax=num[0];
        int sIndex=-1;
        for(int i=1;i<n;i++){
            if(num[i]>curMax)
                continue;
            else if(sIndex==-1){
                curMax=Math.min(num[i],curMax);
            }
        }
    }
}
