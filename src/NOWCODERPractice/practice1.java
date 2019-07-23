package NOWCODERPractice;

import java.util.Scanner;

public class practice1 {
    /*Description
    * ZiZi登录各种账号的时候，总是会忘记密码，所以他把密码都记录在一个记事本上。其中第一个密码就是牛客网的密码。
    * 牛客网专注于程序员的学习、成长及职位发展，连接C端程序员及B端招聘方，通过IT笔试面试题库、在线社区、在线课程等提高候选人的求职效率，通过在线笔试、面试及其他工具提升企业的招聘效率。
    * 团队由来自Google、百度、阿里、网易等知名互联网巨头的热血技术青年组成，用户覆盖全国2000多所高校的100W求职程序员及全部一线互联网企业，并仍在高速增长中。
    * 谨慎的ZiZi当然不会直接把密码记录在上面，而是把上面的字符串经过转化后才是真正的密码。转化的规则是把字符串以n行锯齿形写出来，然后再按从左到右，从上到下读取，
    * 即为真正的密码。如ABABCADCE以3行写出：          所以真正的密码是ACEBBACAD。但是每一次都要写出来就太麻烦了，您如果能帮他写出一个转换程序，他就送你一个气球。
    * 输入描述:
    * 第一行一个整数T，表示数据组数对于每组数据，首先一个正整数n（n<=100,000),然后下一行为一个字符串，字符串长度len<=100,000。
    * 输出描述:
    * 对于每组数据，输出一个字符串，代表真正的密码。
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        String[] res=new String[T];
        for(int i=0;i<T;i++){
            int num=s.nextInt();
            res[i]=getStr(s.next(),num);
        }
        for(String cur:res)
            System.out.println(cur);
    }

    private static String getStr(String cur,int num){
        int pair=num+num-2;
        String res="";
        for(int i=0;i<cur.length();i+=pair)
            res+=cur.charAt(i);
        for(int j=1;j<num-1;j++){
            for(int i=j;i<cur.length();i+=pair){
                res+=cur.charAt(i);
                res+=i+pair-j-1<cur.length()?cur.charAt(i+pair-j-1):"";
            }
        }
        for(int i=num-1;i<cur.length();i+=pair)
            res+=cur.charAt(i);
        return res;
    }
}
