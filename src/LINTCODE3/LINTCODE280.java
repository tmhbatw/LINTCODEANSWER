package LINTCODE3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE280 {
    /*Description
    * 在一个二维平面上有许多城市，所有的城市都有着自己的名字c[i]，以及位置坐标(x[i],y[i])(都为整数）。
    * 有q组询问，每组询问给出一个城市名字，你需要回答离该城市距离最近的，x相同或者y相同的城市名称。
    * */

    public String[] NearestNeighbor(int[] x, int[] y, String[] c, String[] q) {
        HashMap<Integer, List<Integer>> row=new HashMap<>();
        HashMap<Integer, List<Integer>> col=new HashMap<>();
        for(int i=0;i<c.length;i++){
            List<Integer> curRow=row.getOrDefault(x[i],new ArrayList<>());
            curRow.add(i);
            row.put(x[i],curRow);
            List<Integer> curCol=col.getOrDefault(y[i],new ArrayList<>());
            curCol.add(i);
            col.put(y[i],curCol);
        }
        int qLength=q.length;
        String[] result=new String[qLength];
        for(int i=0;i<qLength;i++){
            String cur=q[i];
            for(int j=0;j<c.length;j++){
                if(cur.equals(c[j])){
                    String res="NONE";
                    int min=Integer.MAX_VALUE;
                    List<Integer> curRow=row.get(x[j]);
                    for(int index:curRow){
                        if(index==j)
                            continue;
                        int distance=Math.abs(y[index]-y[j]);
                        if(distance<min||distance==min&&c[index].compareTo(res)<0){
                            min=distance;
                            res=c[index];
                        }
                    }
                    List<Integer> curCol=col.get(y[j]);
                    for(int index:curCol){
                        if(index==j)
                            continue;
                        int distance=Math.abs(x[index]-x[j]);
                        if(distance<min||distance==min&&c[index].compareTo(res)<0){
                            min=distance;
                            res=c[index];
                        }
                    }
                    result[i]=res;
                }
            }
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        String a="aaa";
        String b="bbb";
        System.out.println(a.compareTo(b));
    }
}
