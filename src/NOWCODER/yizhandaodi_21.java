package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_21 {
    /*Description
    * 题目描述
    * 程序员A和B要去一起坐火车，这列火车上的每一排都有4个座位，而且这四个座位  被过道分成了两半。当A和B到了车上时，
    * 一些位子已经有人了。 A和B是好基友，于是他们想要找一对连在一起的座位。两个连在一起的座位是同一排但是不被过道隔开的两个座位。
    * 给定一列火车上的座位情况，请你寻找一下能否找到一对连座？
    * 输入描述:
    * 每组样例第一行为一个整数n，1<=n<=1000，表示火车一共有n排座位。之后的n行每行为一个含有五个字符的字符串，第i个字符串的五个字符表示第i排座位的情况。
    * 每一个字符串的第三个字符都为字符‘|’，表示过道，其余每个字符表示一个座位的占用情况。字符'O'表示座位为空，字符'X'表示座位上已经有人，即被占用。
    * 输出描述:
    * 如果能够找到一组连座，则先输出一行字符串“YES”(不要输出引号)在第一行，在接下来的n行输出车的座位情况，除了A和B的座位用字符'+'表示，
    * 其余输出格式与输入格式中车的座位情况一致。如果不能够找到一组连座，仅输出一行“NO”（不要输出引号）即可。有多组座位安排方式时，
    * 将A和B安排在前面的排，如果同一排还有两组可行解，选择将A和B排在左边。例如一组车的情况为这样的时候，应该将其安排为箭头右边的情况。
    * */

    static boolean arrange=false;
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            String[] res = new String[n];
            for (int i = 0; i < n; i++) {
                if (arrange)
                    res[i] = s.next();
                else {
                    res[i] = change(s.next());
                }
            }
            if (!arrange)
                System.out.println("NO");
            else {
                System.out.println("YES");
                for (String cur : res)
                    System.out.println(cur);
            }
        }
    }

    private static String change(String cur){
        if(cur.charAt(0)=='O'&&cur.charAt(1)=='O') {
            arrange=true;
            return "++" + cur.substring(2);
        }
        else if(cur.charAt(3)=='O'&&cur.charAt(4)=='O'){
            arrange=true;
            return cur.substring(0,3)+"++";
        }
        return cur;
    }
}
