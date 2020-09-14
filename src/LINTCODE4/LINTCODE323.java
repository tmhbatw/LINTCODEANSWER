package LINTCODE4;

public class LINTCODE323 {
    /*Description
    * Alice与Bob在一起玩一个游戏。现在有一个字符串s，每个人可以选择字符串中的某一个区间和一种字符，
    * 删除这个区间内的所有该字符（需要删除字符的数量至少为1）。从Alice开始，Alice与Bob轮流进行进行这个操作，若在某个玩家删除前，字符串已经为空，则该玩家获胜。
    * 假设Alice和Bob都会按照其最优的解法删除，Alice想知道，她是否可以获胜。
    * */

    /*Solution
    * Nim游戏
    * */

    public boolean stringGame(String s) {
        int[] time=new int[128];
        for(int i=0;i<s.length();i++){
            time[s.charAt(i)]++;
        }
        int result=0;
        int time1=0;
        int time2=0;
        for(int cur:time) {
            if(cur==1)
                time1++;
            if(cur!=0)
                time2++;
            result ^= cur;
        }
        if(time1==time2&&result==0||time1!=time2&&result!=0)
            return true;
        return false;
        // Write your code here
    }

    public static void main(String[] args){
        int a=1;
        int b=4;
        System.out.println(b^a^a);
    }
}
