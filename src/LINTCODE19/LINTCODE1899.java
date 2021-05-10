package LINTCODE19;

public class LINTCODE1899 {

    public double fetchSuppliesII(int[][] barracks) {
        double l=-10000,r=10000;
        double diff=0.000001;
        while(r-l>diff){
            double mid=(r+l)/2;
            double curVal=getVal(mid,barracks);
            if(curVal<getVal(mid+diff,barracks)&&curVal<getVal(mid-diff,barracks)) {
                System.out.println(curVal);
                System.out.println(getVal(mid+diff,barracks));
                System.out.println(getVal(mid-diff,barracks));
                return Math.sqrt(curVal);
            }
            if(curVal<=getVal(mid+diff,barracks))
                r=mid;
            else
                l=mid;
        }
        return Math.sqrt(getVal(l,barracks));
        // write your code here
    }


    private double getVal(double x,int[][] barracks){
        double max=Double.MIN_VALUE;
        for(int[] cur:barracks){
            max=Math.max(max,Math.sqrt((x-cur[0])*(x-cur[0])+cur[1]*cur[1]));
        }
        return max;
    }
}
