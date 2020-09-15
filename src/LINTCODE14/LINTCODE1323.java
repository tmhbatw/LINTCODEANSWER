package LINTCODE14;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LINTCODE1323 {
    /*Description
    * 在一个二维地图上有很多军营，每个军营的坐标为（x,y），有一条平行于y轴且长度无限的路，
    * 补给车经过这条路时会将每个军营的物资放到离他们军营最近的路边(这条马路所在的位置使得所有军营到达马路的距离和最小)，
    * 请问所有军营到马路的最短距离和是多少
    * */


    public int Fetchsupplies(List<List<Integer>> coordinates) {
        Collections.sort(coordinates, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1)-o2.get(1);
            }
        });
        int result=0;
        int size=coordinates.size();
        for(int i=0;i<size/2;i++){
            result+=coordinates.get(size-i-1).get(1)-coordinates.get(i).get(1);
        }
        return result;
        // write your code here
    }
}
