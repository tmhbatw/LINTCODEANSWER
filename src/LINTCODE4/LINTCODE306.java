package LINTCODE4;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE306 {
    /*Description
    * 有一个商品列表，该列表是由L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表L1、L2中获取商品进行展示。展示规则如下：
    * 用户可以进行多次翻页，用offset表示用户已经浏览过的商品数量。比如，offset是4，表示用户已经看了4个商品
    * n表示一个页面可以展示的商品数量。
    * 展示商品时首先使用列表L1，如果列表L1不够，再从列表L2中选取商品。
    * 从列表L2中补全商品时，也可能存在数量不足的情况。
    * 给定offset，n，列表L1和L2的长度。请根据上述规则，计算列表L1和L2中哪些商品在当前页面被展示了。
    * */

    public List<Integer> ProductList(int offset, int n, int len1, int len2) {
        List<Integer> result=new ArrayList<>();
        if(offset>=len1){
            result.add(len1);
            result.add(len1);
            offset-=len1;
            if(offset>=len2) {
                result.add(len2);
                result.add(len2);
            }else{
                result.add(offset);
                result.add(Math.min(n+offset,len2));
            }
        }else{
            result.add(offset);
            if(offset+n<=len1){
                result.add(offset+n);
                result.add(0);
                result.add(0);
            }else{
                result.add(len1);
                result.add(0);
                result.add(Math.min(len2,offset+n-len1));
            }
        }
        return result;
        // write your code here
    }
}
