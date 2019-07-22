package Interview;

import java.util.Scanner;

public class zijietiaodong_2019_1 {
    /*Description
    * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
    * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
    * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
    * */

    /*Solution
    * ..
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.nextLine();
        String[] res=new String[n];
        for(int i=0;i<res.length;i++){
            res[i]=s.nextLine();
        }
        for(String cur:res){
            change(cur);
        }
    }

    private static void change(String cur){
        if(cur.length()<=2){
            System.out.println(cur);
            return;
        }
        String res=cur.substring(0,2);
        for(int i=2;i<cur.length();i++){
            if(res.charAt(res.length()-1)==res.charAt(res.length()-2)&&cur.charAt(i)==res.charAt(res.length()-2))
                continue;
            if(res.length()>=3&&res.charAt(res.length()-2)==res.charAt(res.length()-3)&&res.charAt(res.length()-1)==cur.charAt(i))
                continue;
            res+=cur.charAt(i);
        }
        System.out.println(res);
    }
}
