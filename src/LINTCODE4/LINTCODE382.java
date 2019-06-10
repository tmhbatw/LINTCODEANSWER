package LINTCODE4;

import java.util.Arrays;

public class LINTCODE382 {
    /*Description
    *给定一个整数数组，在该数组中，寻找三个数，分别代表三角形三条边的长度，问，可以寻找到多少组这样的三个数来组成三角形？
    * */

    /*Solution
    * 三次遍历搜查是否能构成三角形
    * 简化思路：
    * 可以先进行排序对于一组abc,假设c>b>a
    * 那么如果a+b>c,那么b到c之间的任意一点都可以构成三角形
    * 可以简化到n*n*log(n)复杂度
    * */

    public int triangleCount(int[] S) {
        Arrays.sort(S);
        int result=0;
        for(int i=0;i<S.length-2;i++){
            for(int j=i+1;j<S.length-1;j++){
                int m=j+1,n=S.length-1;
                while(m<n){
                    int mid=(m+n+1)/2;
                    if(judge(S[i],S[j],S[mid]))
                        i=mid;
                    else
                        j=mid-1;
                }
                result+=m-j;
            }
        }
        return result;
        // write your code here
    }


    private boolean judge(int num1,int num2,int num3){
        return num1+num2>num3;
    }

    /*    public int triangleCount(int[] S) {
        Arrays.sort(S);
        int result=0;
        for(int i=0;i<S.length-2;i++){
            for(int j=i+1;j<S.length-1;j++){
                for(int m=j+1;m<S.length;m++){
                    if(judge(S[i],S[j],S[m]))
                        result++;
                }
            }
        }
        return result;
        // write your code here
    }*/
}
