package Interview;

import java.util.Arrays;
import java.util.Scanner;

public class moni2 {

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=s.nextInt();
        Arrays.sort(num);
        int result=0;
        for(int i=0;i<num.length;i++){
            int a=num[i];
            for(int j=i+1;j<num.length;j++){
                int b=num[j];
                result+=getC(num,j+1,num.length-1,a+b)-j;
            }
        }
        System.out.println(result);
    }

    private static int getC(int[] num,int start,int end,int target){
        if(start>end)
            return start-1;
        int mid=start+(end-start)/2;
        if(num[mid]<target&&mid==num.length-1||num[mid]<target&&num[mid+1]>=target)
            return mid;
        else if(num[mid]>=target){
            return getC(num,start,mid-1,target);
        }else
            return getC(num,mid+1,end,target);
    }
}
