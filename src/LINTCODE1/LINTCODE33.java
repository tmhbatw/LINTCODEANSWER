package LINTCODE1;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE33 {
    /*Description
    * N皇后问题
    * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
    * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
    * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
    * */

    /*Solution
    * 递归回溯算法，创建一个字符二维矩阵用来保存当前遍历的棋子情况
    * 当插入一个皇后后，以'.'来占据会被攻击的位置，插入下一个皇后则不能占据该位置
    * 递归插入皇后，当插入n个皇后以后输出结果
    * */
    public  List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char[][] res=new char[n][n];
        recursion(result,res,0);
        return result;
        // write your code here
    }
    private  void recursion(List<List<String>> result,char[][] res,int start){
        if(start==res.length){
            fill(res);
            List<String> re=new ArrayList<>();
            for(int i=0;i<start;i++){
                String s=new String(res[i]);
                re.add(s);
            }
            result.add(re);
            return;
        }
        if(!judge(res,start)){
            return;
        }
        for(int i=0;i<res[0].length;i++){
            if(res[start][i]=='\u0000') {
                recursion(result, change(res, i, start), start + 1);
            }
        }

    }
    private char[][] change(char[][]re, int temp,int start){
        char[][] res=new char[re.length][re[0].length];
        for(int i=0;i<re.length;i++){
            for(int j=0;j<re[0].length;j++){
                res[i][j]=re[i][j];
            }
        }
        res[start][temp]='Q';
        for(int i=start+1;i<res.length;i++){
            res[i][temp]='.';
        }
        for(int i=start+1,j=temp+1;i<res.length&&j<res[0].length;i++,j++){
            res[i][j]='.';
        }
        for(int i=start+1,j=temp-1;i<res.length&&j>=0;i++,j--){
            res[i][j]='.';
        }
        return res;
    }
    private void fill(char[][] res){
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++)
                res[i][j]=res[i][j]=='\u0000'?'.':res[i][j];
        }
    }
    private boolean judge(char[][] res,int start){
        for(int i=0;i<res[0].length;i++){
            if(res[start][i]=='\u0000')
                return true;
        }
        return false;

    }
}
