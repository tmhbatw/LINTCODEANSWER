package LINTCODE12;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1114 {
    /*Description
    * 在商店中，有一些商品在出售，每个商品有个价格。
    * 然而，有一些特殊的促销方案，每个促销方案包含一个或多个不同的商品，但只对应一个价格。
    * 给定每个商品的价格和所有的促销方案表，以及每个商品需要买的数目.
    * 返回需要的最低金额，来满足每个商品都恰好达到需要的数额。
    * 每个促销方案以数组的形式表示，最后一个元素表示该促销方案的价格，其他的元素表示该方案中每个商品含有多少个。促销方案可多次使用。
    * */

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        System.out.println(price);
        System.out.println(needs);
        System.out.println(special);
        int curRes=0;
        int commodityNum=price.size();
        for(int i=0;i<commodityNum;i++) {
            curRes += price.get(i) * needs.get(i);
        }
        for(int j=0;j<special.size();j++){
            List<Integer> list=special.get(j);
            List<Integer> need=new ArrayList<>();
            for(int i=0;i<commodityNum;i++){
                if(list.get(i)>needs.get(i))
                    break;
                need.add(needs.get(i)-list.get(i));
            }
            if(need.size()==commodityNum)
                curRes=Math.min(curRes,shoppingOffers(price,special,need)+list.get(commodityNum));
        }
        return curRes;
        // write your code here
    }
}
