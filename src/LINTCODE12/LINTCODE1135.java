package LINTCODE12;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1135 {
    /*Description
    *小明想从猫咪的视频里挖掘一些猫咪的运动信息。为了提取运动信息，他需要从视频的每一帧提取“猫咪特征”。
    * 一个猫咪特征是一个两维的vector<x, y>。如果x_1=x_2 and y_1=y_2，那么这俩是同一个特征。
    * 如果喵咪特征连续一致，可以认为喵咪在运动。也就是说，如果特征<a, b>在持续帧里出现，那么它将构成特征运动。
    * 比如，特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4 和7-8。
    * 现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动的长度。
    * */

    public int FeatureExtraction(int[][] frames) {
        int result=0;
        Map<String,Integer> map=new HashMap<>();
        for(int[] cur:frames){
            Map<String,Integer> curMap=new HashMap<>();
            for(int i=1;i<cur.length;i+=2){
                String s=cur[i]+" "+cur[i+1];
                int curS=map.getOrDefault(s,0)+1;
                result=Math.max(curS,result);
                curMap.put(s,curS);
            }
            map=curMap;
        }
        return result;
        // write your code here
    }
}
