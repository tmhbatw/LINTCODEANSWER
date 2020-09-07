package LINTCODE3;

public class LINTCODE266 {
    /*Description
    * 小K被困在了一个山洞（山洞A）。
    * 从山洞A出发有两条路，一条路需要走 xx 千米，但是会回到山洞A；另一条路需要走 22 千米，会到达山洞B。
    * 从山洞B出发有两条路，一条路需要走 yy 千米，会到达山洞A；另一条路需要走 zz 千米，会到达山洞的出口C。
    * 小K有些健忘，记不得走过的路，所以每次在一个山洞都会随机选择一条路走，选择的概率相同。
    * 问小K走出山洞的期望路程。
    * */

    public int expectDistance(int x, int y, int z) {
        return 4+2*x+y+z;
        // write your code here.
    }
}
