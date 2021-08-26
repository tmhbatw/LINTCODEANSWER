package LINTCODE9;

import java.util.*;

public class LINTCODE802 {
    /*Description
    * 编写一个程序，通过填充空单元来解决数独难题。
    * 空单元由数字0表示。
    * 你可以认为只有一个唯一的解决方案。
    * */

    boolean jumpFlag=false;
    public void solveSudoku(int[][] board) {
        Set<Integer>[][] set=new Set[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                Set<Integer> curSet=new HashSet<>();
                for(int k=1;k<=9;k++)
                    curSet.add(k);
                set[i][j]=curSet;
            }
        }

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=0){
                    remove(i,j,board[i][j],set,q);
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int i=cur[0],j=cur[1];
            if(board[i][j]!=0||set[i][j].isEmpty())
                continue;
            int curr=0;
            for(int num:set[i][j]){
                curr=num;
            }
            board[i][j]=curr;
            remove(i,j,curr,set,q);
        }

        List<int[]> last=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0) {
                    last.add(new int[]{i,j});
                }
            }
        }

        dfs(board,set,0,last);
        // write your code here
    }

    private void dfs(int[][] board,Set<Integer>[][] set,int index,List<int[]> list){
        if(jumpFlag)
            return;
        if(index==list.size()){
            jumpFlag=true;
            return;
        }
        int i=list.get(index)[0],j=list.get(index)[1];
        List<Integer> cur=new ArrayList<>(set[i][j]);
        for(int num:cur){
            List<int[]> influence=getLastIndex(i,j,num,set);
            board[i][j]=num;
            dfs(board,set,index+1,list);
            if(jumpFlag)
                return;
            board[i][j]=0;
            for(int[] in:influence){
                set[in[0]][in[1]].add(num);
            }
        }
    }


    private List<int[]> getLastIndex(int i,int j, int cur, Set<Integer>[][] set){
        List<int[]> influence=new ArrayList<>();
        for(int jj=0;jj<9;jj++){
            if(set[i][jj].contains(cur)){
                set[i][jj].remove(cur);
                influence.add(new int[]{i,jj});
            }
            if(set[jj][j].contains(cur)){
                set[jj][j].remove(cur);
                influence.add(new int[]{jj,j});
            }
        }

        int ii=i/3*3;
        int jj=j/3*3;
        for(int m=ii;m<ii+3;m++){
            for(int n=jj;n<jj+3;n++) {
                if(set[m][n].contains(cur)){
                    set[m][n].remove(cur);
                    influence.add(new int[]{m,n});
                }
            }
        }
        return influence;
    }

    private void remove(int i, int j, int cur, Set<Integer>[][] set,Queue<int[]> q){
        for(int jj=0;jj<9;jj++){
            f(i,jj,cur,set,q);
            f(jj,j,cur,set,q);
        }
        int ii=i/3*3;
        int jj=j/3*3;
        for(int m=ii;m<ii+3;m++){
            for(int n=jj;n<jj+3;n++) {
                f(m,n,cur,set,q);
            }
        }
    }

    private void f(int i,int j, int cur, Set<Integer>[][] set, Queue<int[]> q){
        if(set[i][j].contains(cur)){
            set[i][j].remove(cur);
            if(set[i][j].size()==1)
                q.add(new int[]{i,j});
        }
    }
}
