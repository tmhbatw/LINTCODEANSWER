package LINTCODE7;

public class LINTCODE698 {
    /*Description
    给 m 个数组, 每一个数组均为升序. 现在你可以从两个不同的数组中挑选两个整数(每一个数组选一个)并且计算差值.
    我们将两个整数 a 和 b 之间的差定义为它们的绝对差 |a - b|. 你的任务是去找到最大的差值.
     */

    public int maxDiff(int[][] arrs) {
        int firstmax=Integer.MIN_VALUE+1;
        int secondmax=Integer.MIN_VALUE;
        int firstmin=Integer.MAX_VALUE-1;
        int secondmin=Integer.MAX_VALUE;
        boolean sameArray=false;
        for(int i=0;i<arrs.length;i++){
            int first=arrs[i][0];
            int last=arrs[i][arrs[i].length-1];
            if(first<firstmin){
                secondmin=firstmin;
                firstmin=first;
                sameArray=false;
            }else if(first<secondmin)
                secondmin=first;
            if(last>firstmax){
                secondmax=firstmax;
                firstmax=last;
                sameArray=false;
            }else if(last>secondmax){
                secondmax=last;
            }
            if(firstmax==last&&firstmin==first){
                sameArray=true;
            }
        }
        if(sameArray&&firstmax!=secondmax&&firstmin!=secondmin)
            return Math.max(secondmax-firstmin,firstmax-secondmin);
        return firstmax-firstmin;
        // write your code here
    }
}
