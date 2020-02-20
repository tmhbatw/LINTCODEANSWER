package LINTCODE15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1477 {
    /*Description
    * N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
    * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
    * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
    * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
    * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
    * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
    * 会有多少车队到达目的地?
    * */

    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<position.length;i++){
            queue.add(new int[]{target-position[i],speed[i]});
        }
        int result=0;
        while(queue.isEmpty()){
            int[] cur=queue.poll();
            result++;
            double time=1.0*cur[0]/cur[1];
            while(!queue.isEmpty()){
                int[] curr=queue.peek();
                if(1.0*curr[0]/curr[1]<=time)
                    queue.poll();
                else
                    break;
            }
        }
        return result;
        // Write your code here
    }
}
