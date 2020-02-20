package LINTCODE12;

import java.util.Arrays;
import java.util.List;

public class LINTCODE1184 {
    /*Description
    * 给出"小时:分钟"格式的24小时时钟点列表，找到列表中任意两个时间点之间的最小分钟差。
    * */

    public int findMinDifference(List<String> timePoints) {
        int[] res=new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++){
            String[] cur=timePoints.get(i).split(":");
            res[i]=Integer.parseInt(cur[0])*60+Integer.parseInt(cur[1]);
        }
        Arrays.sort(res);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<res.length;i++){
            result=Math.min(result,res[i]-res[0]);
        }
        return Math.min(result,1440-res[res.length-1]+res[0]);
        // Write your code here
    }
}
