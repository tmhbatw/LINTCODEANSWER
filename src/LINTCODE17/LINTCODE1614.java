package LINTCODE17;

import java.util.List;

public class LINTCODE1614 {
    /*Description
    *给定一个list存放股票的 ID，初始价格和最终价格，找到增长率最大的股票，返回它的 ID(如果增长率相同，返回原始顺序中最靠前的那个)
    * */

    public String highestGrowth(List<List<String>> Stock) {
        double rate=0.0;
        String res="";
        for(List<String> list:Stock){
            double before= Double.parseDouble(list.get(1));
            double after= Double.parseDouble(list.get(2));
            double curRate=after/before;
            if(curRate>rate){
                rate=curRate;
                res=list.get(0);
            }
        }
        return res;
        // Write your code here
    }
}
