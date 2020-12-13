package LINTCODE15;

public class LINTCODE1431 {
    /*Description
    * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
    * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
    * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
    * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
    * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
    * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
    * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，
    * 则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
    * 返回表示最终状态的字符串。
    * */

    public String pushDominoes(String dominoes) {
        char[] d=dominoes.toCharArray();
        int length=d.length;
        int start=0;
        for(int i=0;i<length;i++){
            if(d[i]=='.')
                continue;
            if(d[i]=='L') {
                fillCharacter(d, start, i - 1, 'L');
                start=i+1;
                continue;
            }
            start=i;
            while(i<length-1){
                char curr=d[++i];
                if(i==length-1&&(curr=='.'||curr=='R')){
                    fillCharacter(d,start,length-1,'R');
                    break;
                }
                if(curr=='.')
                    continue;
                if(curr=='R'){
                    fillCharacter(d,start,i-1,'R');
                    start=i;
                    continue;
                }
                int time=(i-1-start)/2;
                fillCharacter(d,start,start+time,'R');
                fillCharacter(d,i-time,i,'L');
                start=i+1;
                break;
            }
        }
        return new String(d);
        // Write your code here
    }

    private void fillCharacter(char[] cur,int start,int end,char curr){
        for(int i=start;i<=end;i++)
            cur[i]=curr;
    }
}
