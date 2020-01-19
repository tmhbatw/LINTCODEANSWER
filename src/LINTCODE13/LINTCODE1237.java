package LINTCODE13;

public class LINTCODE1237 {
    /*Description
    * 在平面中给定n个点，每一对点都是不同的，“回旋镖”是一个点的的元组 (i, j, k)，其中 i 和 j 之间的距离与i和k之间的距离相同 （元组的顺序是重要的）。
    * 找到回旋镖的数量。 您可以假设n最多为500并且点的坐标都在 [-10000, 10000] （包括）范围内。
    * */

    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        for(int i=0;i<points.length;i++){
            int[] cur=points[i];
            for(int j=0;j<points.length;j++){
                if(j==i)
                    continue;
                int diff=(cur[0]-points[j][0])*(cur[0]-points[j][0])+(cur[1]-points[j][1])*(cur[1]-points[j][1]);
                System.out.println("i "+i+" "+j+" "+diff);
                for(int k=j+1;k<points.length;k++){
                    if(k==i)
                        continue;
                    int curr=(cur[0]-points[k][0])*(cur[0]-points[k][0])+(cur[1]-points[k][1])*(cur[1]-points[k][1]);
                    System.out.println("j "+i+" "+k+" "+curr);
                    if(diff==curr)
                        result+=2;
                }
            }
        }
        return result;
        // Write your code here
    }

}
