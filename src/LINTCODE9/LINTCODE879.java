package LINTCODE9;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE879 {
    /*Description
    * 在NBA季后赛期间，我们总是安排一支实力相当强的球队去和实力较弱的球队比赛，
    * 比如让排名第1的球队和第n的球队一起比赛，这是一个让比赛更有趣的好策略。
    * 现在给定n个球队，你需要以字符串的形式返回他们的最终赛程。
    * n 组球队以正整数的形式给出，从1到n，表示它们的初始排名。排名第1的是实力最强的球队，
    * 排名n最弱的球队。我们将使用括号() 和逗号, 来表示比赛团队的配对——括号()表示比赛的组而逗号,
    * 表示间隔。在每一轮的配对过程中，你都需要遵循这个策略，那就是让一个相当强的和一个相当弱的配对。
    * */

    public String findContestMatch(int n) {
        List<String> result=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
            result.add("("+i+","+(n-i+1)+")");
        }
        System.out.println(result);
        while(result.size()!=1){
            int size=result.size();
            List<String> cur=new ArrayList<>();
            for(int i=0;i<size/2;i++){
                cur.add("("+result.get(i)+","+result.get(size-i-1)+")");
            }
            result=cur;
        }
        return result.get(0);
        // write your code here
    }
}
