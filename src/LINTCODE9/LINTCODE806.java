package LINTCODE9;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE806 {
    /*Description
    * 小明要帮公司买水果，给了一个codeList，里面装的是他买的水果，给了一个shoppingCart,里面装的是target水果，
    * 目标是检查codelist里的水果顺序是否和shoppingCart里的顺序匹配。注意的是只有codelist中的所有链表的item之和
    * 加起来小于等于shoppingcart里item之和才可能返回1，另外在codelist中有可能出现item时"anything"，它可以和任意的水果匹配。
    * */

    public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        List<String> list=new ArrayList<>();
        for(List<String> cur:codeList)
            list.addAll(cur);
            int size=list.size();
        for(int i=0;i<shoppingCart.size()-size;i++){
            for(int j=0;j<size;j++){
                String cur=list.get(j);
                if(cur.equals("anything")){
                    if(j==size-1)
                        return 1;
                    else
                        continue;
                }
                if(!cur.equals(shoppingCart.get(i+j)))
                    break;
                if(j==size-1)
                    return 1;
            }
        }
        return 0;
        // Write your code here
    }
}
