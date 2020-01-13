package LINTCODE12;

public class LINTCODE1104 {
    /*Description
    * 最初，机器人位于(0, 0)处。 给定一系列动作，判断该机器人的移动轨迹是否是一个环，这意味着它最终会回到原来的位置。
    * 移动的顺序由字符串表示。 每个动作都由一个字符表示。 有效的机器人移动是R（右），L（左），U（上）和D（下）。 输出应该为true或false，表示机器人是否回到原点。
    * */

    public boolean judgeCircle(String moves) {
        int index1=0,index2=0;
        for(int i=0;i<moves.length();i++){
            char cur=moves.charAt(i);
            switch (cur){
                case ('R'):
                    index1++;
                    break;
                case ('L'):
                    index1--;
                    break;
                case('U'):
                    index2++;
                    break;
                case ('D'):
                    index2--;
                    break;
            }
        }
        return index1==0&&index2==0;
        // Write your code here
    }
}
