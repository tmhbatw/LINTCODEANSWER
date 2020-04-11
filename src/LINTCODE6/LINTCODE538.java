package LINTCODE6;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE538 {
    /*Description
    * 实现下列几个方法：
    * 1.get(curtTime, key). 得到key的值，如果不存在返回2147483647
    * 2.set(curtTime, key, value, ttl). 设置一个pair(key,value)，有效期从curtTime到curtTime + ttl -1 , 如果ttl为0，则一直存在
    * 3.delete(curtTime, key). 删除这个key
    * 4.incr(curtTime, key, delta). 给key的value加上delta，并且返回 如果不存在返回 2147483647。
    * 5.decr(curtTime, key, delta). 给key的value减去delta，并且返回 如果不存在返回 2147483647。
    * */

    class Memcache {
        class Pair{
            int key;
            int value;
            int curTime;
            int ttl;
            public Pair(int key,int value,int curTime,int ttl){
                this.key=key;
                this.value=value;
                this.curTime=curTime;
                this.ttl=ttl;
            }
        }

        int error;
        Map<Integer,Pair> map;
        public Memcache() {
            map=new HashMap<>();
            error=2147483647;
            // do intialization if necessary
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @return: An integer
         */
        public int get(int curtTime, int key) {
            if(!map.containsKey(key))
                return error;
            Pair cur=map.get(key);
            if(cur.ttl!=0&&cur.ttl+cur.curTime<=curtTime){
                return error;
            }
            return cur.value;
            // write your code here
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param value: An integer
         * @param ttl: An integer
         * @return: nothing
         */
        public void set(int curtTime, int key, int value, int ttl) {
            map.put(key,new Pair(key,value,curtTime,ttl));
            // write your code here
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @return: nothing
         */
        public void delete(int curtTime, int key) {
            map.remove(key);
            // write your code here
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param delta: An integer
         * @return: An integer
         */
        public int incr(int curtTime, int key, int delta) {
            if(!map.containsKey(key))
                return error;
            Pair cur=map.get(key);
            if(cur.ttl!=0&&cur.curTime+cur.ttl<=curtTime)
                return error;
            cur.value=cur.value+delta;
            return cur.value;
            // write your code here
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param delta: An integer
         * @return: An integer
         */
        public int decr(int curtTime, int key, int delta) {
            if(!map.containsKey(key))
                return error;
            Pair cur=map.get(key);
            if(cur.ttl!=0&&cur.curTime+cur.ttl<=curtTime)
                return error;
            cur.value=cur.value-delta;
            return cur.value;
            // write your code here
        }
    }
}
