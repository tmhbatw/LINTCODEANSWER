package NOWCODER;

import java.util.Scanner;

public class zijietiaodong_2019_6 {
    /*Description
    * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
     * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int cur=1024-s.nextInt();


        int result=0;
        result+=(cur>>6);
        result+=(cur&(63))>>4;
        result+=(cur&(15))>>2;
        result+=cur&(3);
        System.out.println(result);
    }
}
