package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1160 {
    /*Description
    * 在由 2D 网格表示的校园里有n位工人（worker）和 m 辆自行车（bike），n≤m。
    * 所有工人和自行车的位置都用网格上的 2D 坐标表示。
    * 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对 (worker, bike) ，
    * 并将其中的自行车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。
    * 类似地，如果有多种不同的分配方法，则选择自行车索引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
    * */

    //桶排序可以优化
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int workersNumber=workers.length;
        int bikesNumber=bikes.length;
        int[][] distance=new int[workersNumber*bikesNumber][3];
        int index=0;
        for(int i=0;i<workersNumber;i++){
            for(int j=0;j<bikesNumber;j++){
                int curDistance=Math.abs(workers[i][0]-bikes[i][0])+Math.abs(workers[i][1]-bikes[i][1]);
                distance[index][0]=curDistance;
                distance[index][1]=i;
                distance[index][2]=j;
            }
        }
        Arrays.sort(distance,(o1,o2)->{
            if(o1[0]==o2[0]&&o1[1]==o2[1])
                return o1[2]-o2[2];
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        boolean[] workerReached=new boolean[workersNumber];
        boolean[] bikeReached=new boolean[bikesNumber];
        int[] result=new int[workersNumber];
        for(int i=0;i<distance.length;i++){
            int workerIndex=distance[i][1];
            int bikeIndex=distance[i][2];
            if(workerReached[workerIndex]||bikeReached[bikeIndex])
                continue;
            workerReached[workerIndex]=true;
            bikeReached[bikeIndex]=true;
            result[workerIndex]=bikeIndex;
        }
        return result;
        // write your code here
    }
}
