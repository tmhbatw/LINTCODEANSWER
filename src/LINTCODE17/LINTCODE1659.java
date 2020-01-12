package LINTCODE17;

public class LINTCODE1659 {
    /*Description
    *给出n个数和m个询问，每个询问包含两个整数L,R，对于每个询问输出有多少数满足取值范围在[L, R]
    * */

    /*Solution
    * 因为没有q的length与a的length之间的关系，所以未知排序二分法是否能减少时间
    * */

    public int[] getAns(int[] a, int[][] q) {
        int[] result=new int[q.length];
        for(int i=0;i<q.length;i++){
            int time=0;
            int left=q[i][0],right=q[i][1];
            for(int j=0;j<a.length;j++){
                if(a[j]<=right&&a[j]>=left)
                    time++;
            }
            result[i]=time;
        }
        return result;
        // write your code here
    }
}
