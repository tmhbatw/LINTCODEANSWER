package LINTCODE9;

public class LINTCODE848 {
    /*Description
    * 在水平数轴上，我们有加油站：stations[0], stations[1], ..., stations[N-1], 这里N = stations.length。
    * 现在，我们再增加K个加油站，D表示相邻加油站之间的最大距离，这样D就变小了。
    * 返回所有可能值D中最小值。
    * */

    public double minmaxGasDist(int[] stations, int k) {
        if(stations==null||stations.length<=1)
            return 0;
        double l=0,r=Double.MAX_VALUE;
        while(r-l>0.00000001){
            double mid = l+(r-l)/2;
            if(getRes(stations,k,mid))
                r=mid;
            else
                l=mid;
        }
        return l;
        // Write your code here
    }

    private boolean getRes(int[] stations, int k, double mid){
        int count=0;
        for(int i=1;i<stations.length;i++){
            count += (stations[i]-stations[i-1]-0.0000001)/mid;
            if(count>k)
                return false;
        }
        return true;
    }
}
