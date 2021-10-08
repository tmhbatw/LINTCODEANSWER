package LINTCODE16;

import java.util.*;

public class LINTCODE1504 {
    /*Description
    *给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，
    * （"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
    * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。
    * 我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
    * 假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。
    * 换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
    * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
    * */

    int target=0;
    int[] val=new int[]{1,2,4,8,16,32};
    int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        int row=grid.length,col=grid[0].length();
        char[][] board=new char[grid.length][];
        for(int i=0;i<row;i++)
            board[i]=grid[i].toCharArray();

        for(char[] cur:board){
            System.out.println(Arrays.toString(cur));
        }


        Queue<int[]> q=new LinkedList<>();
        char tar='A'-1;

        HashSet[][] set=new HashSet[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                set[i][j]=new HashSet();
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='@') {
                    board[i][j]='.';
                    q.add(new int[]{i, j, 0});
                    set[i][j].add(0);
                }
                if(board[i][j]<='F'&&board[i][j]>='A')
                    tar= (char) Math.max(tar,board[i][j]);
            }
        }
        target=getTarget(tar);

        int result=0;
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] n:next){
                    int ii=cur[0]+n[0];
                    int jj=cur[1]+n[1];
                    int keys=cur[2];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col){
                        if(board[ii][jj]>='a'&&board[ii][jj]<='z'){
                            if((keys&val[board[ii][jj]-'a'])==0)
                                keys+=val[board[ii][jj]-'a'];
                        }
                        if(keys==target)
                            return result;

                        if(board[ii][jj]!='#'&&!set[ii][jj].contains(keys)){
                            set[ii][jj].add(cur[2]);
                            //这种情况下说明不包含该钥匙
                            if(board[ii][jj]>='A'&&board[ii][jj]<='Z'){
                                int key=val[board[ii][jj]-'A'];
                                if((cur[2]&key)==0)
                                    continue;
                            }
                            //其他情况则可以
                            q.add(new int[]{ii,jj,keys});
                        }
                    }
                }
            }
        }
        return -1;
        // write your code here
    }

    private int getTarget(char cur){
        return (int) (Math.pow(2,cur-'A'+1)-1);
    }

    public static void main(String[] args){
        int a=1000;
        System.out.println(Math.log10(a));
    }
}
