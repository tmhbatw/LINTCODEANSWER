package LINTCODE9;

public class LINTCODE851 {
    /*Description
    * 给定一个评估图， heights[i] 表示该地的高度。所有下标对应的地面宽度均为 1。
    * 请问V个单位的水落在下标为 K 的地面之后，每个下标对应的地面水量是多少？
    * 水首先从下标K降落，接着它依据下述规则流动：
    * 首先，液滴不能流向更高的地方；如果液滴能向左最终能下降，那么向左移动；
    * 否则，如果能向右最终能下降，则向右移动；否则，留当前位置。
    * 其中，“最终能下降”意味着如果液滴像那个方向移动，最终能够处于更低高度。
    * 假设整个区域左右两侧有无限高的地形。此外，一单位水不能拆分，即每个单位必须恰好落在一个区块内。
    * */

    public int[] pourWater(int[] heights, int V, int K) {
        int length=heights.length;
        while(V-->0){
            int l=K;
            while(l>=1&&heights[l]>=heights[l-1]) {
                if(heights[l]>heights[l-1]) {
                    l--;
                    continue;
                }
                int curL=l;
                while(curL>=1&&heights[curL]==heights[curL-1])
                    curL--;
                if(curL>=1&&heights[curL]>heights[curL-1])
                    l=curL;
                else
                    break;
            }
            if(l!=K) {
                heights[l]++;
                continue;
            }
            int r=K;
            while(r<length-1&&heights[r]>=heights[r+1]) {
                if(heights[r]>heights[r+1])
                    r++;
                else{
                    int curR=r;
                    while(curR<length-1&&heights[curR]==heights[curR+1])
                        curR++;
                    if(curR<length-1&&heights[curR]>heights[curR+1])
                        r=curR;
                    else
                        break;
                }
            }
            if(r!=K){
                heights[r]++;
                continue;
            }
            heights[K]++;
        }
        return heights;
        // Write your code here
    }
}
