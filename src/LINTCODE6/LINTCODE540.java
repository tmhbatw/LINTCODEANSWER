package LINTCODE6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LINTCODE540 {
    /*Description
    * 给你两个一维向量，实现一个迭代器，交替返回两个向量的元素
    * */

    /*Solution
    * 将两个向量保存到一个向量中然后实现迭代器即可
    * */

    class ZigzagIterator {
        /*
         * @param v1: A 1d vector
         * @param v2: A 1d vector
         */
        List<Integer> list;
        int index;
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            list=new ArrayList<Integer>();
            Iterator i1=v1.iterator();
            Iterator i2=v2.iterator();
            while(i1.hasNext()&&i2.hasNext()){
                list.add((int)i1.next());
                list.add((int)i2.next());
            }
            Iterator i=i1.hasNext()?i1:i2;
            while(i.hasNext())
                list.add((int)i.next());
            index=0;
            // do intialization if necessary
        }

        /*
         * @return: An integer
         */
        public int next() {
            return list.get(index++);
            // write your code here
        }

        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            return list.size()!=index;
            // write your code here
        }
    }

}
