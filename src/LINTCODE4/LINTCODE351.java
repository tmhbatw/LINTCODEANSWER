package LINTCODE4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE351 {
    /*Description
    *你需要对n个有序数组进行排序，和题目合并k个排序数组不同的是：
    * 1、你只能通过固定的接口 ArrayReader.read(i, j) 来获得第i个数组下标为j的数据。
    * 2、你只能通过固定的接口 ArrayReader.write(val) 来将某个数据加入答案数组中。
    * 3、你只能通过固定的接口 ArrayReader.getResult() 来获得答案数组。
    * */

    class ArrayReader{
        List<Integer> list;
        public ArrayReader(){
            list=new ArrayList<>();
        }
        public int read(int i,int j){
            return (int) (Math.random()*i+Math.random()*j);
        }
        public void write(int val){
            list.add(val);
        }
        public List<Integer> getResult(){
            return list;
        }
    }
    public List<Integer> sortOnDisk(ArrayReader arrayReader, int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int j=0;
            while(arrayReader.read(i,j)!=Integer.MAX_VALUE)
                list.add(arrayReader.read(i,j));
        }
        Collections.sort(list);
        return list;
        // write your code here
    }
}
