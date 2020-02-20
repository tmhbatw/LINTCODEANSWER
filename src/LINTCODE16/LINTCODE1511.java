package LINTCODE16;

public class LINTCODE1511 {
    /*Description
    * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
    * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
    * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
    * */

    public int mirrorReflection(int p, int q) {
        boolean is1=true;
        int height=0;
        while(true){
            height+=q;
            if(height%p==0){
                if((height/p)%2==0){
                    if(is1)
                        return 0;
                }
                else{
                    if(is1)
                        return 1 ;
                    else
                        return 2;
                }
            }
            is1=!is1;
        }
        // Write your code here
    }
}
