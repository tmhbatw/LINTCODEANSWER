package LINTCODE15;

import java.util.HashMap;
import java.util.List;

public class LINTCODE1483 {
    /*Description
    *给出一组学生的名字以及他们的成绩，求最高的平均分(一位学生可能有多门课成绩)
    * */

    public double maximumAverageScore(List<String> names, int[] grades) {
        HashMap<String,Integer> score=new HashMap<>();
        HashMap<String,Integer> time=new HashMap<>();
        for(int i=0;i<names.size();i++){
            String name=names.get(i);
            score.put(name,score.getOrDefault(name,0)+grades[i]);
            time.put(name,time.getOrDefault(name,0)+1);
        }
        double max=Double.MIN_VALUE;
        for(HashMap.Entry entry:score.entrySet()){
            String name=(String) entry.getKey();
            max=Math.max(max,score.get(name)*1.0/time.get(name));
        }
        return max;
        // Write your code here
    }
}
