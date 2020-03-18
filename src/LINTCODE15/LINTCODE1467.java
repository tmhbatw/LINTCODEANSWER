package LINTCODE15;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1467 {
    /*Description
    * 你有一串的技能需要释放，释放顺序为arr。必须按照顺序释放。每个技能都有长度为n的冷却时间。也就是说，
    * 两个同类技能之间至少要间隔n秒。释放每个技能需要1秒,返回放完所有技能所需要的时间。
    * */

    public int askForCoolingTime(int[] arr, int n) {
        Map<Integer,Integer> map=new HashMap<>();
        int curTime=0;
        for(int i=0;i<arr.length;i++){
            int cur=arr[i];
            curTime++;
            if(map.containsKey(cur)){
                int pre=map.get(cur);
                if(curTime-pre<=n){
                    curTime=pre+n+1;
                }
            }
            map.put(cur,curTime);
        }
        return curTime;
        // Write your code here
    }
}
