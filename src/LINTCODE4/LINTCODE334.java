package LINTCODE4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE334 {
    /*Description
    * 班上的学生根据他们的年级照片的身高升序排列，确定当前未站在正确位置的学生人数
    * */

    public int orderCheck(List<Integer> heights) {
        List<Integer> list=new ArrayList<>(heights);
        Collections.sort(list);
        int result=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=heights.get(i))
                result++;
        }
        return result;
        // write your code here
    }
}
