package NOWCODER;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class yizhandaodi_4 {
    /*Description
    *  铁子最近犯上了强迫症，他总是想要把一个序列里的元素变得两两不同，而他每次可以执行一个这样的操作，
    * 他可以选择序列里的任意两个元素相加，不妨记作ai和aj，然后把ai+aj放进序列里，再删掉ai和aj其中的随便一个，问最少操作多少次可以完成铁子的愿望？
    * 输入描述:
    * 第一行一个整数n表示序列的长度(1≤n≤105)第二行n个整数ai表示序列的每个整数(1≤ai≤109)
    * 输出描述:
    * 输出一行表示答案
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<n;i++){
            set.add(s.nextInt());
        }
        System.out.println(n-set.size());
    }
}
