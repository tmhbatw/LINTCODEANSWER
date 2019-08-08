package NOWCODER;

import java.util.HashMap;
import java.util.Scanner;

public class yizhandaodi_20 {
    /*Description
    * 题目描述
    * 这天,托米家的电影院门口排起了长队--因为最新的电影"托米历险记"就要上映了! 每个人都有且仅有一张面值为25或50或100元的钞票.
    * 一张电影票的价格是25元. 托米想知道售票员能否在初始金钱为0并且按排队顺序售票的情况下完成找零.
    * 输入描述:
    * 第一行一个数字n,表示排队的人的数量.第二行n个数字,第i个数字为ai,表示队伍中第i个人所持有的钞票的面值.
    * 输出描述:
    * 如果售票员能完成找零,输出"YES"(不含引号).反之输出"NO".
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(25,0);
        map.put(50,0);
        for(int i=0;i<n;i++){
            int cur=s.nextInt();
            switch(cur){
                case 25:
                    map.put(25,map.get(25)+1);
                    break;
                case 50:
                    if(map.get(25)==0) {
                        System.out.println("NO");
                        return;
                    }
                    map.put(50,map.get(50)+1);
                    map.put(25,map.get(25)-1);
                    break;
                case 100:
                    if(map.get(25)==0||map.get(50)==0) {
                        System.out.println("NO");
                        return;
                    }
                    map.put(25,map.get(25)-1);
                    map.put(50,map.get(50)-1);
                    break;
            }
        }
        System.out.println("YES");
    }
}
