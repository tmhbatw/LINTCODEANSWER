package LINTCODE18;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LINTCODE1785 {
    /*Description
    * 设计一个银行账户管理系统，实现以下三个函数：
    * 1.void deposite(int id,int amount,long timestamp)
    * 2.boolean withdraw(int id,int amount,long timestamp)
    * 3.int[] check(int id,long startTime,long endTime)
    * */

    class BankSystem {
        private Map<Integer, TreeMap<Long,Integer>> map;
        public BankSystem(){
            map=new HashMap<>();
            // Write your code here
        }
        /**
         * @param id: user account id
         * @param amount: the number of bank deposits
         * @param timestamp: the data of bank transaction
         * @return: nothing
         */
        public void deposite(int id, int amount, long timestamp) {
            TreeMap<Long,Integer> cur=map.getOrDefault(id,new TreeMap<>());
            Long floorKey=cur.floorKey(timestamp);
            if(floorKey!=null)
                amount+=cur.get(floorKey);
            cur.put(timestamp,amount);
            map.put(id,cur);
            // Write your code here
        }

        /**
         * @param id: user account id
         * @param amount : the number of bank withdraw
         * @param timestamp: the data of bank transaction
         * @return: if user account can not withdraw the number of amount,return false. else return true
         */
        public boolean withdraw(int id, int amount , long timestamp) {
            TreeMap<Long,Integer> curMap=map.get(id);
            if(curMap==null)
                return false;
            Long floorKey=curMap.floorKey(timestamp);
            if(floorKey==null)
                return false;
            Integer oldAmount=curMap.get(floorKey);
            if(oldAmount<amount)
                return false;
            curMap.put(timestamp,oldAmount-amount);
            return true;
            //
        }

        /**
         * @param id: user account id
         * @param startTime: start time
         * @param endTime: end time
         * @return: need return two numbers,the first one is start time account balance,the second is end time account balance
         */
        public int[] check(int id, long startTime, long endTime) {
            TreeMap<Long,Integer> cur=map.get(id);
            if(cur==null)
                return new int[0];
            int[] result=new int[2];
            Long startFloorKey=cur.floorKey(startTime);
            if(startFloorKey!=null)
                result[0]=cur.get(startFloorKey);
            Long endFloorKey=cur.floorKey(endTime);
            if(endFloorKey!=null)
                result[1]=cur.get(endFloorKey);
            return result;
            //
        }
    }
}
