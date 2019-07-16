package LINTCODE6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LINTCODE528 {
    /*Description
    * Given a nested list of integers, implement an iterator to flatten it.
    * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    * */

    /*Solution
    * 将list全部展开并将所有的数字保存在一个数据结构种
    * */


      public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer,
              // rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
      }

    public class NestedIterator implements Iterator<Integer> {
          List<Integer> list;
          int index;
          public NestedIterator(List<NestedInteger> nestedList) {
            list=new ArrayList<Integer>();
            index=0;
            for(NestedInteger cur:nestedList)
                recursion(cur);
            // Initialize your data structure here.
          }

          private void recursion(NestedInteger curr){
              if(curr.isInteger()) {
                  list.add(curr.getInteger());
                  return;
              }
              if(curr.getList()==null){
                  return;
              }
              List<NestedInteger> lis=curr.getList();
              for(NestedInteger cur:lis)
                  recursion(cur);
          }

        // @return {int} the next element in the iteration
        @Override
        public Integer next() {
              return list.get(index++);
            // Write your code here
        }

        // @return {boolean} true if the iteration has more element or false
        @Override
        public boolean hasNext() {
            return index!=list.size();
            // Write your code here
        }

        @Override
        public void remove() {}
    }
}
