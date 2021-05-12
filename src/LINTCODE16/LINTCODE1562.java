package LINTCODE16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE1562 {
    /*Description
    * 给出一个List，里面的数据代表每一个餐厅的坐标[x, y]。顾客的坐标处于原点[0, 0]。
    * 找出 n 家离顾客位置最近的餐厅，其中 m 为这 n 家餐厅到顾客的最远距离 ，如果列表中存在超过 n 家餐厅到顾客的距离不大于 m ，
    * 则按列表内元素顺序返回先出现的 n 家餐厅。
    * */

    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        if(restaurant.size()<n)
            return Collections.emptyList();
        for(int i=0;i<restaurant.size();i++)
            restaurant.get(i).add(i);
        Collections.sort(restaurant,(o1,o2)->{
            return o1.get(0)*o1.get(0)+o1.get(1)*o1.get(1)-o2.get(0)*o2.get(0)-o2.get(1)*o2.get(1);
        });
        int m=restaurant.get(n-1).get(0)*restaurant.get(n-1).get(0)+
                restaurant.get(n-1).get(1)*restaurant.get(n-1).get(1);
        int index=n;
        for(;index<restaurant.size();index++){
            if(restaurant.get(index).get(0)*restaurant.get(index).get(0)+
                    restaurant.get(index).get(1)*restaurant.get(index).get(1)>m)
                break;
        }
        index--;
        List<List<Integer>> r=new ArrayList<>();
        for(int i=0;i<=index;i++)
            r.add(restaurant.get(i));
        Collections.sort(r,(o1,o2)->{
            return o1.get(2)-o2.get(2);
        });
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> cur=new ArrayList<>();
            cur.add(r.get(i).get(0));
            cur.add(r.get(i).get(1));
            result.add(cur);
        }
        return result;
        // Write your code here
    }
}
