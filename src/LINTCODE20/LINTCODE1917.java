package LINTCODE20;

public class LINTCODE1917 {
    /*Description
    *金属棒工厂的厂长拥有 n 根多余的金属棒。当地的一个承包商提出，只要所有的棒材具有相同的长度
    * （用 saleLength 表示棒材的长度），就将金属棒工厂的剩余棒材全部购买。
    * 厂长可以通过将每根棒材切割零次或多次来增加可销售的棒材数量，但是每次切割都会产生一定的成本（用 costPerCut 表示每次切割的成本）。
    * 等所有的切割完成以后，多余的棒材将被丢弃，没有利润。金属棒工厂的厂长获得的销售总利润计算公式如下：
    * totalProfit = totalUniformRods * saleLength * salePrice - totalCuts * costPerCut
    * 其中 totalUniformRods 是可销售的金属棒数量，salePrice 是承包商同意支付的每单位长度价格，totalCuts是需要切割棒材的次数。
    * */

    public static void main(String[] args){
        int costPerCut=1;
        int salePrice=10;
        int[] lengths=new int[]{30,59,110};
        System.out.println(new LINTCODE1917().maxProfit(costPerCut,salePrice,lengths));
    }

    public int maxProfit(int costPerCut, int salePrice, int[] lengths) {
        int result=0;
        for(int i=0;i<=10000;i++){
            result=Math.max(result,getVal(lengths,i,salePrice,costPerCut));
        }
        return result;
        // write your code here
    }

    private int getVal(int[] lengths,int saleLength,int salePrice,int costPerCut){
        if(saleLength<=0)
            return 0;
        int totalUniformRods=0;
        int totalCuts=0;
        for(int cur:lengths){
            if(cur>=saleLength)
                totalUniformRods+=cur/saleLength;
                totalCuts+=(cur/saleLength);
                if(cur%saleLength==0){
                    totalCuts--;
            }
        }
        //System.out.println(totalUniformRods+" "+totalCuts+" "+saleLength);
        return totalUniformRods*saleLength*salePrice-totalCuts*costPerCut;
    }
}
