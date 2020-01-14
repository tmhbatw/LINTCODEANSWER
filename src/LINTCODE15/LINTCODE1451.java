package LINTCODE15;

public class LINTCODE1451 {
    /*Description
    * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
    * 至少有一个空座位，且至少有一人坐在座位上。
    * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
    * 返回他到离他最近的人的最大距离。
    * */

    public int maxDistToClosest(int[] seats) {
        int pre=-1;
        for(int i=0;i<seats.length;i++) {
            if (seats[i] == 1) {
                pre=i;
                break;
            }
        }
        int last=-1;
        for(int i=seats.length-1;i>=0;i--){
            if(seats[i]==1){
                last=i;
                break;
            }
        }
        int max=Math.max(pre,seats.length-1-last);
        for(int i=pre+1;i<=last;i++){
            if(seats[i]==1){
                max=Math.max((i-pre)/2,max);
                pre=i;
            }
        }
        return max;
        // Write your code here.
    }
}
