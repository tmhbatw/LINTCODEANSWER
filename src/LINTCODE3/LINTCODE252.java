package LINTCODE3;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE252 {
    /*Description
    *
    * */

    public class Solution {
        /**
         * @param A: the Matrix
         * @param ask: the query array
         * @return: return can or can't deteime the value of A
         */
        public int[] getDetemine(int[][] A, int[][] ask) {
            int row=A.length,col=A[0].length;
            boolean[] rowReached=new boolean[row];
            boolean[] colReached=new boolean[col];
            int[][] rowNum=new int[row][6];
            int[][] colNum=new int[col][6];
            Queue<int[]> q=new LinkedList<>();
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(A[i][j]!=0){
                        addNumber(rowReached, colReached, rowNum, colNum,i,j,A[i][j],q);
                    }
                }
            }
            while(!q.isEmpty()){
                int[] cur=q.poll();
                int diff=(cur[4]-cur[2])/(cur[3]-cur[1]);
                int first= cur[2]-cur[1]*diff;
                if(cur[0]==0){
                    int i=cur[5];
                    for(int j=0;j<col;j++){
                        if(A[i][j]==0){
                            A[i][j]=first+j*diff;
                            addNumber(rowReached, colReached, rowNum, colNum,i,j,A[i][j],q);
                        }
                    }
                }else{
                    int j=cur[5];
                    for(int i=0;i<row;i++){
                        if(A[i][j]==0){
                            A[i][j]=first+i*diff;
                            addNumber(rowReached, colReached, rowNum, colNum,i,j,A[i][j],q);
                        }
                    }
                }
            }
            int[] result=new int[ask.length];
            for(int i=0;i<result.length;i++)
                result[i]=A[ask[i][0]][ask[i][1]]==0?-1:A[ask[i][0]][ask[i][1]];
            return result;
            // write your code here
        }

        private void addNumber(boolean[] rowReached, boolean[] colReached, int[][] rowNum,
                               int[][] colNum, int i, int j, int curNum, Queue<int[]> q){
            if(!rowReached[i]) {
                if (rowNum[i][0] == 0) {
                    rowNum[i][0]++;
                    rowNum[i][1] = j;
                    rowNum[i][2] = curNum;
                } else if(rowNum[i][1]!=j){
                    rowNum[i][3] = j;
                    rowNum[i][4] = curNum;
                    rowNum[i][5] = i;
                    rowNum[i][0] = 0;
                    q.add(rowNum[i]);
                    rowReached[i] = true;
                }
            }
            if(!colReached[j]) {
                if(colNum[j][0] == 0) {
                    colNum[j][0]++;
                    colNum[j][1] = i;
                    colNum[j][2] = curNum;
                } else if(colNum[j][1]!=i) {
                    colNum[j][3] = i;
                    colNum[j][4] = curNum;
                    colNum[j][5] = j;
                    colNum[j][0] = 1;
                    q.add(colNum[j]);
                    colReached[j] = true;
                }
            }
        }
    }
}
