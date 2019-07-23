package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_17 {
    /*Description
    * 总算到暑假了，小姐姐是非常的闲，所以想去找梅溪湖的小名玩，可是她从没去过梅溪湖，所以只能凭小名告诉她的地方走，每次只能向上下左右四个方向走1步。
    * 小姐姐的坐标为(0,0)，小名在(a,b)，小姐姐有点近视，小名也有点近视。所以到了(a,b)也不一定能和小名会面，不过还好，小姐姐最后找到了小名。
    * 小姐姐想要小名知道自己来一趟是多么不容易，所以在聊天的过程中小姐姐说自己为了到这里走了n步。小名，你觉得她说的可能是真话么。
    * 有可能就输出YES,否则输出NO(如果用random的话,小姐姐觉得你好像不在意她，明年暑假就不来了)
    * 输入描述:
    * a,b,n(-1000<=a,b<=1000,a*b>0,1<=n<=2000)
    * 输出描述:
    * "YES" or "NO"
    * */

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int he=Math.abs(a+b);
        int n=scanner.nextInt();
        if(n<he||(he-n)%2!=0)
            System.out.println("NO");
        else{
            System.out.println("YES");
        }
    }
}
