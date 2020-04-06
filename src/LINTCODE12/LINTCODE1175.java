package LINTCODE12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1175 {
    /*Description
    * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
    * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
    * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
    * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
    * */

    public int leastBricks(List<List<Integer>> wall) {
        if(wall==null||wall.size()==0)
            return 0;
        int width=0;
        List<Integer> list=wall.get(0);
        for(int cur:list)
            width+=cur;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(List<Integer> cur:wall){
            int curWidth=0;
            for(int num:cur){
                curWidth+=num;
                map.put(curWidth, map.getOrDefault(curWidth,0)+1);
            }
        }
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getKey()==width)
                continue;
            result=Math.max(result,(int)(entry.getValue()));
        }
        return wall.size()-result;
        // write your code here
    }
}
