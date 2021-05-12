package LINTCODE16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1567 {
    /*Description
    * 给定一个长度为n的数组a，现在你有一次任意选择两个数a[i],a[j]进行交换的机会，当然你也可以选择放弃这个机会。
    * 问如何选择，能够使数组中具有最大和的子数组最大，输出最大子数组的和。
    * */

    public int getAnswer(int[] a) {
        int length=a.length;
        List<Integer> list=new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        for(int i=length-1;i>=0;i--){
            int pop=list.get(list.size()-1);
            if(a[i]>=pop)
                list.add(a[i]);
        }
        Collections.reverse(list);
        int result=Integer.MIN_VALUE;
        int preMax=Integer.MIN_VALUE;
        int startIndex=0;
        for(int i=0;i<length;i++){
            int curSum=0;
            int curStartIndex=startIndex;
            int min=Integer.MAX_VALUE;
            for(int j=i;j<length;j++){
                curSum+=a[j];
                if(a[j]==list.get(curStartIndex))
                    curStartIndex++;
                min=Math.min(min,a[j]);
                int max=Math.max(preMax,list.get(curStartIndex));
                result=Math.max(result,curSum+(max>min?max-min:0));
            }
            preMax=Math.max(preMax,a[i]);
            if(a[i]==list.get(startIndex))
                startIndex++;
        }
        return result;
        // Write your code here
    }
}
