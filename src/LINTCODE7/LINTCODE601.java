package LINTCODE7;

import java.util.Iterator;
import java.util.List;

public class LINTCODE601 {
    class Vector2D implements Iterator<Integer> {

        int[] num;
        int index;
        int size;

        public Vector2D(List<List<Integer>> vec2d) {
            size=0;
            for(List<Integer> cur:vec2d)
                size+=cur.size();
            num=new int[size];
            int curIndex=0;
            for(List<Integer> cur:vec2d){
                for(int curr:cur)
                    num[curIndex++]=curr;
            }
            index=0;
            // Initialize your data structure here
        }

        @Override
        public Integer next() {
            return num[index++];
            // Write your code here
        }

        @Override
        public boolean hasNext() {
            return index<size;
            // Write your code here
        }

        @Override
        public void remove() {}
    }
}
