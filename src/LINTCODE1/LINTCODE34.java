package LINTCODE1;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE34 {
    /*Description
    * 根据n皇后问题，现在返回n皇后不同的解决方案的数量而不是具体的放置布局。
    * */

    /*Solution
    * 与上一题思路相同，返回数量即可；
    * */
    public int totalNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        char[][] res=new char[n][n];
        recursion(result,res,0);
        return result.size();
        // write your code here
        // write your code here
    }
    private  void recursion(List<List<String>> result, char[][] res, int start){
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
