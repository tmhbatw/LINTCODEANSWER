package LINTCODE13;

public class LINTCODE1286 {
    /*Description
    * 给出一个由n个正数组成的数组x。 从点(0,0)开始向北移动x [0]米，然后向西移动x [1]米，
    * 向南移动x [2]米，向东移动x[3]米，依此类推。 换句话说，每次移动后，您的方向会逆时针变化。
    * 写一个带有O(1)额外空间的算法来确定你的路径是否穿过已走过的路径。
    * */

    public boolean isSelfCrossing(int[] x) {
        if(x.length<=3)
            return false;
        if(x[3]<x[1]){
            x[2]=Math.min(x[0],x[2]);
            for(int i=4;i<x.length;i++){
                if(x[i]>=x[i-2])
                    return true;
            }
            return false;
        }else if(x[3]==x[1]){
            if(x[0]>=x[2])
                return true;
            x[2]=x[2]-x[0];
            for(int i=4;i<x.length;i++){
                if(x[i]>=x[i-2])
                    return true;
            }
            return false;
        }else{
            if(x[0]>=x[2])
                return true;
            for(int i=4;i<x.length;i++){
                if(x[i]<=x[i-2])
                    return true;
            }
            return false;
        }
        // write your code here
    }
}
