package LINTCODE6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE509 {
    /*Description
    *设计一个小的Yelp系统支持下列操作
    * 1.添加一个新餐馆的名字和地址
    * 2.去除一个餐馆
    * 3.在给定地点找一个临近的餐馆
    *
    * 位置由纬度和经度表示，两者都用双精度表示。Location类在代码中给出。
    * 临近餐馆是指距离小于 k km
    * 已经提供了Restaurant类，您可以直接调用Restaurant.create()来创建一个新对象。
    * 此外，还提供了一个Helper类来计算两个位置之间的距离，
    * 使用Helper.get_distance (location1、location2)。
    *
    * 提供了一个GeoHash类来将位置转换为字符串。
    * 尝试geohash .encode(location)将location转换为geohash字符串，
    * 以及geohash .decode(string)将字符串转换为location。
    * */

    public class MiniYelp {
        class Node{
            double distance;
            String name;
            public Node(double distance,String name){
                this.distance=distance;
                this.name=name;
            }
        }
        int index=1;
        Map<String,Integer> map1;//用来保存经纬度与饭店编号之间的关系
        Map<Integer,String> map2;//用来保存饭店编号与名称之间的关系
        public MiniYelp() {
            map1=new HashMap<>();
            map2=new HashMap<>();
            // initialize your data structure here.
        }

        // @param name a string
        // @param location a Location
        // @return an integer, restaurant's id
        public int addRestaurant(String name, Location location) {
            map1.put(location.latitude+" "+location.longitude,index);
            map2.put(index,name);
            return index++;
        }

        // @param restaurant_id an integer
        public void removeRestaurant(int restaurant_id) {
            map2.remove(restaurant_id);
        }

        // @param location a Location
        // @param k an integer, distance smaller than k miles
        // @return a list of restaurant's name and sort by
        // distance from near to far.
        public List<String> neighbors(Location location, double k) {
            List<Node> list=new ArrayList<>();
            for(Map.Entry<String,Integer> entry:map1.entrySet()){
                String[] loc=entry.getKey().split(" ");
                Location l=Location.create(Double.parseDouble(loc[0]),Double.parseDouble(loc[1]));
                double distance=Helper.get_distance(location,l);
                if(distance<k&&map2.containsKey(map1.get(entry.getKey()))){
                    list.add(new Node(distance,map2.get(map1.get(entry.getKey()))));
                }
            }
            list.sort((o1,o2)->{
                if(o1.distance<o2.distance)
                    return -1;
                if(o1.distance==o2.distance)
                    return 0;
                return 1;
            });
            List<String> result=new ArrayList<>();
            for(Node cur:list)
                result.add(cur.name);
            return result;
            // Write your code here
        }
    }

}

class Location {
    public double latitude, longitude;
    public static Location create(double lati, double longi) {
        // This will create a new location object
        return null;
    }
}



class Helper {
    public static double get_distance(Location location1, Location location2) {
        return 0.0;
        // return distance between location1 and location2.
    }
}