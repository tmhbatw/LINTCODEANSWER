package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_12 {
    /*Description
    * 不愤不启不悱不发，王萌萌为了能够成功上研，开始刻苦背GRE单词，但是由于她过于刻苦，在背会英语单词的同时，把中文读音忘了。于是王萌萌又开始复习起中文发音，她先从数字开始复习起。。。
    * 题目很简单，王萌萌给出在[0, 10]范围内的整数的英文单词，你教她中文发音。
    * 输入描述:
    * 第一行输入一个T，表示王萌萌询问的单词。(T <= 20)后面T行每行一个英文单词，题目保证英文单词是[0, 10]数字所表示的单词且单词书写无误，单词用小写形式给出。
    * 输出描述:
    * 对于每一个输入的单词，输出它的中文读音，请用小写形式给出。
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            String cur=s.next();
            String res="";
            switch (cur){
                case "zero":
                    res="ling";
                    break;
                case "one":
                    res="yi";
                    break;
                case "two":
                    res="er";
                    break;
                case "three":
                    res="san";
                    break;
                case "four":
                    res="si";
                    break;
                case "five":
                    res="wu";
                    break;
                case "six":
                    res="liu";
                    break;
                case "seven":
                    res="qi";
                    break;
                case "eight":
                    res="ba";
                    break;
                case "nine":
                    res="jiu";
                    break;
                default:
                    res="shi";
                    break;
            }
            str[i]=res;
        }
        for(String cur:str){
            System.out.println(cur);
        }
    }
}
