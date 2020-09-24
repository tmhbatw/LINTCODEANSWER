package LINTCODE9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE881 {
    /*Description
    * 给出一个由黑色和白色像素点组成的图形，和一个正整数N，找到满足以下条件的黑色像素点的个数（假设某个黑色像素点位于第R行和第C列）：
    * 第R行和第C列都恰好有N个黑色像素点。
    * 对于所有在第C列为黑色像素点的行，这些行需要和第R行完全一样。
    * 这个图形表示为包含'B'和'W'的二维字符型数组，其中'B' 表示黑色像素点，'W'表示白色像素点。
    * */

    public int findBlackPixel(char[][] picture, int N) {
        int row=picture.length,col=picture[0].length;
        Set<Integer> set=new HashSet<>();//用来保存黑色像素点个数为n的行号
        Map<String,Set<Integer>> map=new HashMap<>();

        for(int i=0;i<row;i++){
            char[] cur=picture[i];
            int time=0;
            for(int ii=0;ii<col;ii++){
                if(cur[ii]=='B')
                    time++;
            }
            if(time==N) {
                set.add(i);
                String curr=new String(cur);
                Set<Integer> curSet=map.getOrDefault(curr,new HashSet<>());
                curSet.add(i);
                map.put(curr,curSet);
            }
        }
        int result=0;
        for(int j=0;j<col;j++){
            int time=0;
            Set<Integer> curSet=new HashSet<>();
            for(int i=0;i<row;i++){
                if(picture[i][j]=='B') {
                    time++;
                    curSet=map.get(new String(picture[i]));
                    if(!set.contains(i))
                        time+=N;
                }
            }
            if(time==N){
                boolean flag=true;
                for(int i=0;i<row;i++){
                    if(picture[i][j]=='B'){
                        if(!curSet.contains(i)){
                            flag=false;
                            break;
                        }
                    }
                }
                result+=flag?N:0;
            }
        }
        return result;
        // write your code here
    }
}
