package LINTCODE15;

import java.util.HashSet;

public class LINTCODE1471 {
    /*Description
    * 给定两个集合A,B，分别输出A和B的并集、交集和差集的大小
    * */

    public int[] getAnswer(int[] A, int[] B) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:A)
            set.add(num);
        int or=set.size();
        int and=0;
        for(int num:B){
            if(set.contains(num))
                and++;
            else
                or++;

        }
        return new int[]{or,and,A.length-and};
        // Write your code here
    }
}
