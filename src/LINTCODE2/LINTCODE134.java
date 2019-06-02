package LINTCODE2;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE134 {
    /*Description
    * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set）。
    * 获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
    * 写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
    * */

    /*Solution
    * 题意表面为最近最少，其实为最近
    * 将最远的使用的踢出即可
    * 当然可以使用队列等数据结构，下为使用数组的解法
    * */

    int index=0;
    int time=0;
    int[] keys;
    int[] times;
    Map<Integer,Integer> map=new HashMap<>();

    public LINTCODE134(int capacity) {
        keys=new int[capacity];
        times=new int[capacity];
        // do intialization if necessary
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        int i=-1;
        for(int j=0;j<index;j++){
            if(key==keys[j]) {
                i=j;
                break;
            }
        }
        if(i==-1)
            return i;
        times[i]=++time;
        return map.get(key);
        // write your code here
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        for(int i=0;i<index;i++){
            if(keys[i]==key){
                times[i]=++time;
                map.put(key,value);
                return;
            }
        }
        if(index<keys.length){
            keys[index]=key;
            times[index]=++time;
            map.put(key,value);
            index++;
        }else{
            int temp=0;
            for(int i=1;i<index;i++){
                if(times[i]<times[temp]){
                    temp=i;
                }
            }
            keys[temp]=key;
            times[temp]=++time;
            map.put(key,value);
        }
        // write your code here
    }
}
