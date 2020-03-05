package LINTCODE18;

public class LINTCODE1747 {
    /*Description
    * 在2D平面上有一个从位置（0,0）开始的机器人。 给定其移动序列，判断该机器人在完成移动后是否在（0,0）处结束。
    * 移动序列由字符串表示，字符move [i]表示其第i个移动。 有效移动是R（右），L（左），U（上）和D（下）。 如果机器人在完成所有移动后返回原点，则返回true。 否则，返回false。
    * */

    public boolean robotReturntoOrigin(String moves) {
        int x=0;
        int y=0;
        for(int i=0;i<moves.length();i++){
            char cur=moves.charAt(i);
            switch ((cur)){
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                default:
                    y--;
            }
        }
        return x==0&&y==0;
        // Write your code here.
    }
}
