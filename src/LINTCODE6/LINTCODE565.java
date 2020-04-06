package LINTCODE6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE565 {
    /*Description
    *在Master-Slave结构模式中，slave端会每隔k秒向master端发送ping请求表示自己还在运行。
    * 如果master端在 2 * k 秒内没有接收到任何来自slave的ping请求，那么master端会向管理员发送一个警告(比如发送一个电子邮件)。
    * 现在让我们来模拟master端，你需要实现以下三个功能：
    * 1.initialize(slaves_ip_list, k)，slaves_ip_list是所有slaves的ip地址列表，k为一个定值。
    * 2.ping(timestamp, slave_ip)，这个方法在master端从slave端收到ping请求时执行，timestamp指当前的时间戳，slave_ip代表当前发送请求的slave端的ip地址
    * 3.getDiedSlaves(timestamp)，这个方法会定期的(两次执行之间的时间间隔不确定)执行，timestamp代表当前的时间戳，此方法需要返回不再运行的slave端的所有ip地址列表，如果没有发现则返回空集合。
    * 你可以假设当master端开始运行的时候时间戳为0，所有的方法都会根据全局的增长的时间戳来运行。
    * */

    class HeartBeat {

        List<String> list;
        int[] time;
        Map<String,Integer> map;
        int interval;
        public HeartBeat() {
            // do intialization if necessary
        }

        /*
         * @param slaves_ip_list: a list of slaves'ip addresses
         * @param k: An integer
         * @return: nothing
         */
        public void initialize(List<String> slaves_ip_list, int k) {
            list=slaves_ip_list;
            interval=k*2;
            time=new int[list.size()];
            map=new HashMap<>();
            for(int i=0;i<list.size();i++){
                map.put(list.get(i),i);
            }
            // write your code here
        }

        /*
         * @param timestamp: current timestamp in seconds
         * @param slave_ip: the ip address of the slave server
         * @return: nothing
         */
        public void ping(int timestamp, String slave_ip) {
            if(!map.containsKey(slave_ip))
                return;
            int index=map.get(slave_ip);
            time[index]=timestamp;
            // write your code here
        }

        /*
         * @param timestamp: current timestamp in seconds
         * @return: a list of slaves'ip addresses that died
         */
        public List<String> getDiedSlaves(int timestamp) {
            List<String> result=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                if(timestamp-time[i]>=interval)
                    result.add(list.get(i));
            }
            return result;
            // write your code here
        }
    }
}
