package LINTCODE17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1629 {
    /*Description
    * 街上有一些商店和房屋。请找到最近的商店到每个房子。
    * 给定两个数组代表商店和房子的位置。
    * 返回一个数组，代表距离每一个房子最近距离的商店。如果有两个商店与房子距离相同，则返回左边的商店。
    * */

    public List<Integer> findNearestStore(List<Integer> stores, List<Integer> houses) {
        Collections.sort(stores);
        int length=stores.size();
        int min=stores.get(0);
        int max=stores.get(length-1);
        List<Integer> result=new ArrayList<>();
        for(int cur:houses){
            if(cur<=min)
                result.add(min);
            else if(cur>=max)
                result.add(max);
            else{
                int left=0,right=length-1;
                int mid=0;
                while(left<=right){
                    mid=left+(right-left)/2;
                    if(stores.get(mid)==cur||stores.get(mid)<cur&&stores.get(mid+1)>cur)
                        break;
                    if(stores.get(mid)<cur)
                        left=mid+1;
                    else
                        right=mid-1;
                }
                result.add(stores.get(mid+1)-cur<cur-stores.get(mid)?stores.get(mid+1):stores.get(mid));
            }
        }
        return result;
    }
}
