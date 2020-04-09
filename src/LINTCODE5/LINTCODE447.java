package LINTCODE5;

public class LINTCODE447 {
    /*Description
    *给一个按照升序排序的非负整数数组。这个数组很大以至于你只能通过固定的接口 ArrayReader.get(k)
    * 来访问第k个数(或者C++里是ArrayReader->get(k))，并且你也没有办法得知这个数组有多大。
    * 找到给出的整数target第一次出现的位置。你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。
    * 如果找不到target，返回-1。
    * */

    static class ArrayReader{
        public int get(int k){
            return (int) (Math.random()*Integer.MAX_VALUE);
        }
    }

    public static final int overflow=2147483647;

    public int searchBigSortedArray(ArrayReader reader, int target) {
        if(reader.get(0)>target)
            return -1;
        if(reader.get(0)==target)
            return 0;
        int left=0,right=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            int cur=reader.get(mid);
            if(cur==target&&reader.get(mid-1)<target)
                return mid;
            if(cur<target&&reader.get(mid+1)>target)
                return -1;
            if(cur>=target) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return -1;
        // write your code here
    }
}
