package LINTCODE18;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE1761 {
    /*Description
    * 现在你有一个3×3的矩阵，其中填了1~8和一个空白位置，空白位置用0来表示。现在，
    * 你可以将与填充0数字的格子相邻的格子移动到这个位置，原来的位置即变成空，即原来的位置变成了0。
    * 问，最少移动几次，使得最后的矩阵变成[[1,2,3],[4,5,6],[7,8,0]]。如果你得到的最小移动次数小于等于k,
    * 那么返回true，否则返回false。
    * */

    String t="true";
    String f="false";
    int target=123456780;
    class Node{
        int[][] cur;
        int i;
        int j;
        public Node(int[][] cur, int i, int j){
            this.cur=cur;
            this.i=i;
            this.j=j;
        }
    }
    public String digitalHuarongRoad(int[][] arr, int k) {
        Set<Integer> set=new HashSet<>();
        int distance=0;
        int startX=0;
        int startY=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j]==0){
                    startX=i;
                    startY=j;
                }
            }
        }
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(arr,startX,startY));
        int[][] next=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()&&distance<=k){
            distance++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                int type=getType(node.cur);
                if(type==target)
                    return t;
                if(set.contains(type)){
                    continue;
                }
                set.add(type);
                int ii=node.i;
                int jj=node.j;
                for(int[] nextPos:next){
                    int iii=ii+nextPos[0],jjj=jj+nextPos[1];
                    if(iii<3&&iii>=0&&jjj<3&&jjj>=0){
                        int[][] nextArr=new int[3][3];
                        for(int m=0;m<3;m++){
                            nextArr[m]=node.cur[m].clone();
                        }
                        nextArr[ii][jj]=nextArr[iii][jjj];
                        nextArr[iii][jjj]=0;
                        q.add(new Node(nextArr,iii,jjj));
                    }
                }
            }
        }
        return f;
        // Write your code here.
    }

    private int getType(int[][] arr){
        int res=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                res=res*10+arr[i][j];
            }
        }
        return res;
    }
}
