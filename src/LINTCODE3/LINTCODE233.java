package LINTCODE3;

import java.util.Arrays;

public class LINTCODE233 {
    /*Description
    * 给定一个正整数，找出其用二进制表示拥有同样1的数量的比它小的最大正整数和比它大的最小正整数。
    * 如果找不到则输出-1，这里的正整数都是指32位带符号正整数。
    * */


    public int getPrev(int n) {
        if(n==Integer.MAX_VALUE)
            return -1;
        //这种情况下必然存在0
        boolean[] num=changeNumberToArray(n);
        int count=0;
        for(int i=0;i<31;i++){
            if(num[i])
                count++;
            if(!num[i]){
                for(int j=i+1;j<31;j++){
                    if(num[j]){
                        count++;
                        num[j]=false;
                        for(int k=j-1;k>=(j-count);k--){
                            num[k]=true;
                        }
                        for(int k=j-count-1;k>=0;k--){
                            num[k]=false;
                        }
                        return changeArrayToNumber(num);
                    }
                }
                return -1;
            }
        }
        return -1;
        // write your code here
    }

    public int getNext(int n) {
        if(n==Integer.MAX_VALUE)
            return -1;
        boolean[] num=changeNumberToArray(n);
        int count=0;
        for(int i=0;i<31;i++){
            if(num[i]){
                count++;
            }
            else{
                if(count==0)
                    continue;
                num[i]=true;
                for(int j=0;j<count-1;j++){
                    num[j]=true;
                }
                for(int j=count-1;j<i;j++)
                    num[j]=false;
                return changeArrayToNumber(num);
            }
        }
        return -1;
        // write your code here
    }

    private boolean[] changeNumberToArray(int num){
        boolean[] res=new boolean[32];
        for(int i=0;i<31;i++){
            if(num%2==1)
                res[i]=true;
            num/=2;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    private int changeArrayToNumber(boolean[] num){
        int base=1;
        int res=0;
        for(int i=0;i<31;i++){
            if(num[i])
                res+=base;
            base*=2;
        }
        return res;
    }

    /*
     * @param n: a positive integer
     * @return: a positive integer or -1
     */

    public static void main(String[] args){
        int num=Integer.MAX_VALUE;
        new LINTCODE233().changeNumberToArray(num);

    }
}
