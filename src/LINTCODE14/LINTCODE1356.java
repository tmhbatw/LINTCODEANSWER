package LINTCODE14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE1356 {

    public List<List<Integer>> MaximumPointsSet(int[][] Points) {
        Arrays.sort(Points,(o1,o2)->{
            return o2[0]-o1[0];
        });
        List<List<Integer>> result=new ArrayList<>();
        int maxY=-1;
        for(int[] cur:Points){
            if(cur[1]>maxY){
                List<Integer> list=new ArrayList<>();
                list.add(cur[0]);
                list.add(cur[1]);
                maxY=cur[1];
                result.add(list);
            }
        }
        Collections.reverse(result);
        return result;
        // write your code here
    }
}
