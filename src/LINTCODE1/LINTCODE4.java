package LINTCODE1;

public class LINTCODE4 {
    /*Description
    Ugly number is a number that only have prime factors 2, 3 and 5.
Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
    * */

    /*Solution
    使用动态规划
    丑数一定是已有的丑数乘以2或3或5后得到的数
    故丑数可以分为三个类别即2派系、3派系以及5派系
    易得第一个丑数为1
    那么1*2=2即为2派系，1*3即为3派系，1*5即为5派系
    保留这三个派系中最小的数即为当前最小丑数
    每个派系中的数被保留则获取该派系下一丑数继续进行保留比较
    直到获得第n个丑数即为要求的结果
    * */


    public static int nthUglyNumber(int n) {
        int[] result=new int[n];
        result[0]=1;
        int two=0,three=0,five=0;
        for(int i=1;i<n;i++){
            result[i]=Math.min(result[two]*2,Math.min(result[three]*3,result[five]*5));
            if(result[i]==result[two]*2)
                two++;
            if(result[i]==result[three]*3)
                three++;
            if(result[i]==result[five]*5)
                five++;
        }
        return result[n-1];
    }

    public static void main(String[] args){
        System.out.println(nthUglyNumber(1665));
    }
}
