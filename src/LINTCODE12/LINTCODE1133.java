package LINTCODE12;

public class LINTCODE1133 {
    /*Description
    * 有 x 个人打算买 A 类商品，有 y 个人打算买 B 类商品，z 个人打算买 C 类商品，每个人都只打算买 1 件商品。
    * 现在有一个团购规则，规则如下：
    * 每次团购规定买 3 件商品。
    * 每次团购至少包括 1 件 A 类商品和 1 件 B 类商品。
    * 请求出这些人最多团购多少次。
    * */

    public int groupBuyTimes(int x, int y, int z) {
        if(x<=z||y<=z)
            return Math.min(x,y);
        x-=z;
        y-=z;
        if(x>=y*2)
            return y+z;
        if(y>=x*2)
            return x+z;
        return (x+y)/3+z;
        // write your code here
    }
}
