package LINTCODE10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LINTCODE960 {
    /*Description
    *我们需要实现一个叫 DataStream 的数据结构。并且这里有 两 个方法需要实现：
    * void add(number) // 加一个新的数
    * int firstUnique() // 返回第一个独特的数
    * */

    class DataStream {
        List<Integer> list1;
        HashSet<Integer> set;

        public DataStream(){
            list1=new ArrayList<>();
            set=new HashSet<>();
            // do intialization if necessary
        }
        /**
         * @param num: next number in stream
         * @return: nothing
         */
        public void add(int num) {
            if(list1.size()==0){
                list1.add(num);
                return;
            }
            for(int i=0;i<list1.size();i++){
                if(list1.get(i)==num) {
                    set.add(num);
                    break;
                }
                if(i==list1.size()-1) {
                    list1.add(num);
                    break;
                }
            }
            // write your code here
        }

        /**
         * @return: the first unique number in stream
         */
        public int firstUnique() {
            System.out.println(list1);
            System.out.println(set);
            for(int num:list1){
                if(!set.contains(num))
                    return num;
            }
            return -1;
            // write your code here
        }
    }
}
