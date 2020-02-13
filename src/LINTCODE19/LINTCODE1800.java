package LINTCODE19;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1800 {
    public int[] getArray(double[] A, int target) {
        PriorityQueue<double[]> queue=new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                double oo1=o1[0]-(int)o1[0];
                double oo2=o2[0]-(int)o2[0];
                if(oo1<=oo2)
                    return 1;
                return -1;
            }
        });
        int diff=0;
        for(int i=0;i<A.length;i++){
            queue.add(new double[]{A[i],i});
            diff+=(int)A[i];
        }
        diff=target-diff;
        int[] result=new int[A.length];
        while(diff-->0){
            double[] cur=queue.poll();
            result[(int) cur[1]]= (int) cur[0]+1;
        }
        while(!queue.isEmpty()){
            double[] cur=queue.poll();
            result[(int)cur[1]]=(int)cur[0];
        }
        return result;
    }
}
