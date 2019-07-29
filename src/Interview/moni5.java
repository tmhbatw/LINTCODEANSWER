package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class moni5 {

    /*Description
    * 题目要求获取一个数组中连续上升的数组子序列，最多有一个数字不满足连续上升要求
    * */

    private static int getNum(int[] num){
        int res=0;
        int start=0;
        int curMax=num[0];
        int curIndex=-1;
        for(int i=1;i<num.length;i++){
            if(num[i]>curMax) {
                curMax=num[i];
                continue;
            }
            if(curIndex==-1){
                if(i-start==1||num[i]>num[i-2]){
                        curMax=num[i];
                        curIndex=i-1;

                }else{
                    curIndex=i;
                }
            }else{
                res=Math.max(res,i-start);
                System.out.println(res);
                while(curIndex!=-1){
                    start++;
                    if(start>curIndex)
                        curIndex=-1;
                }
                if(i-start==1||num[i]>num[i-2]){
                    curMax=num[i];
                    curIndex=i-1;

                }else{
                    curIndex=i;
                }
            }
        }
        res=Math.max(res,num.length-start);
        return res;
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] num=new int[n];
        for(int i=0;i<n;i++)
            num[i]=s.nextInt();
        int res=getNum(num);
        System.out.println(res);
    }
}
