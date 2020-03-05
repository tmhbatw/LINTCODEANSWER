package LINTCODE16;

public class LINTCODE1546 {
    /*Description
    *小明是一个销售员，客人在他的地方买了东西，付给了小明一定面值的钱之后，小明需要把多余的钱退给客人。
    * 客人付给了小明n，小明的东西的售价为m，小明能退回给客人的面额只能为[100,50,20,10,5,2,1]的组合。现在小明想要使纸币数量之和最小，请返回这个最小值。
    * */

    public int coinProblem(int n, int m) {
        int back=n-m;
        int result=0;
        int[] currency=new int[]{100,50,20,10,5,2,1};
        for(int i=0;i<7;i++){
            int time=back/currency[i];
            result+=time;
            back-=time*currency[i];
        }
        return result;
        // Write your code here
    }
}
