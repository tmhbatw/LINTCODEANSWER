package LINTCODE18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1792 {
    /*Description
    * 给你N根不等长的木棍。 有一个切割操作：将所有木棒切成最短的高度，并记录切割的宽度（木棒的数量）并扔掉切割的部分。
    * 重复此切割操作，直到所有木棒都被扔掉。 您需要输出每次切割的记录宽度（棒数）。您需要输出每次切割记录的棒数。
    * */

    public int[] CutTheSticks(int[] sticks) {
        if(sticks.length==0)
            return new int[0];
        Arrays.sort(sticks);
        List<Integer> list=new ArrayList<>();
        int length=sticks.length;
        list.add(length);
        for(int i=0;i<length;i++){
            int cur=sticks[i];
            while(i<length-1&&sticks[i+1]==cur)
                i++;
            if(i==length-1)
                break;
            list.add(length-i-1);
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
        // write your code here
    }


}
