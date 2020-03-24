package LINTCODE6;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE525 {
    /*Description
    * 实现一个迷你优步
    * 司机提供他们的位置
    * 用户请求，然后返回一个匹配的司机
    * 实现下列函数
    *   report(driver_id, lat, lng)
    * 如果没有找到匹配的trip，返回null
    * 否则返回匹配trip信息
    * request(rider_id, lat, lng)
    *   建立一个trip
    * 找到一个最近的司机，标记这个司机为不可用
    * 将司机id填入trip
    * 返回trip
    * */

    /*Solution
    * report(dirver_id, lat, lng)
    * 如果在 dirver_id -> trip 的映射中查找到对应的trip, 直接返回
    * 没有查找到trip, 更新 dirver_id -> location 中的位置信息
    * request(rider_id, lat, lng)
    * 遍历 driver_id -> location , 选择距离最近的司机
    * 建立 trip 并添加至 driver_id -> trip
    * 将该司机从 dirver_id -> location 中删除
    * */

    public class Trip {
        public int id; // trip's id, primary key
        public int driver_id, rider_id; // foreign key
        public double lat, lng; // pick up location
        public Trip(int rider_id, double lat, double lng){
            this.rider_id=rider_id;
            this.lat=lat;
            this.lng=lng;
        }
    }

    static class Helper {
        public static double get_distance(double lat1, double lng1,
                                         double lat2, double lng2) {
            return Math.abs(lat1*lat1-lat2*lat2)+Math.abs(lng1*lng1-lng2*lng2);
          // return distance between (lat1, lng1) and (lat2, lng2)
        }
    }

    class MiniUber {

        Map<Integer,Trip> map1;//用来保存已经分配trip的司机
        Map<Integer,Trip> map2;//用来保存只留有司机位置的map

        public MiniUber() {
            map1=new HashMap<>();
            map2=new HashMap<>();
            // initialize your data structure here.
        }

        // @param driver_id an integer
        // @param lat, lng driver's location
        // return matched trip information if there have matched rider or null
        public Trip report(int driver_id, double lat, double lng) {
            if(map1.containsKey(driver_id))
                return map1.get(driver_id);
            map2.put(driver_id,new Trip(driver_id,lat,lng));
            return null;
            // Write your code here
        }

        // @param rider_id an integer
        // @param lat, lng rider's location
        // return a trip
        public Trip request(int rider_id, double lat, double lng) {
            double distance=Double.MAX_VALUE;
            int driver_id=-1;
            for(Map.Entry entry:map2.entrySet()){
                Trip cur= (Trip) entry.getValue();
                double lat2=cur.lat;
                double lng2=cur.lng;
                double curDistance=Helper.get_distance(lat,lng,lat2,lng2);
                if(curDistance<distance){
                    distance=curDistance;
                    driver_id=cur.rider_id;
                }
            }
            map2.remove(driver_id);
            Trip res=new Trip(rider_id,lat,lng);
            res.driver_id=driver_id;
            map1.put(driver_id,res);
            return res;
            // Write your code here
        }
    }
}
