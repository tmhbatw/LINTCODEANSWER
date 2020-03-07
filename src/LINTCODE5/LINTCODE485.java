package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE485 {
    /*Description
    * 给你一个大小size,生成一个元素从1 到 size的数组
    * */

    public List<Integer> generate(int size) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=size;i++)
            result.add(i);
        return result;
        // write your code here
    }

}
