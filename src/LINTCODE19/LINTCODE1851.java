package LINTCODE19;

public class LINTCODE1851 {
    /*Description
    * 亚历克斯计划参观博物馆，并在柜台上购买通行证。管理员决定不一次出售多张通行证，一次只提供一张。
    * 如果访客需要一张以上的通行证，他/她必须再次重新排队到柜台并购买下一张通行证。亚历克斯想购买许多通行证。
    * 访客顺序和每位访客需要的通行证数量是已知的，亚历克斯需要多少时间才能买到所有的通行证？Alex在队列中的位置将被给定，每次交易需要1个时间单位。可以忽略每次转到行后面所需的时间。
    * */

    public int buyPasses(int[] arr, int k) {
        int result=0;
        int limit=arr[k];
        for(int i=0;i<arr.length;i++){
            result+= Math.min(arr[i], limit);
            if(i==k)
                limit--;
        }
        return result;
        // Write your code here.
    }
}
